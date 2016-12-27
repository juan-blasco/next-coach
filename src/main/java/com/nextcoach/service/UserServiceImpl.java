package com.nextcoach.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextcoach.domain.Admin;
import com.nextcoach.domain.Club;
import com.nextcoach.domain.Coach;
import com.nextcoach.domain.User;
import com.nextcoach.domain.visitor.AdminVisitor;
import com.nextcoach.domain.visitor.ClubVisitor;
import com.nextcoach.domain.visitor.CoachVisitor;
import com.nextcoach.dto.ClubDTO;
import com.nextcoach.dto.CoachDTO;
import com.nextcoach.dto.ProfileDTO;
import com.nextcoach.dto.UserDTO;
import com.nextcoach.dto.mapper.Mapper;
import com.nextcoach.repository.UserRepository;
import com.nextcoach.utils.HashUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private Mapper mapper;

	@Override
	public List<UserDTO> getUsers() {
		return StreamSupport.stream(userRepository.findAll().spliterator(), false)
				.map(user -> fromUser(user))
				.collect(Collectors.toList());
	}

	@Override
	public UserDTO saveUser(UserDTO userDTO) {
		User user = toUser(userDTO);
		user.setPass(HashUtils.hash(userDTO.getPass()));
		user = userRepository.save(user);
		return fromUser(user);
	}

	@Override
	public UserDTO getUser(Long userId) {
		User user = userRepository.findOne(userId);
		return fromUser(user);
	}

	@Override
	public UserDTO getUser(String username) {
		User user = userRepository.findByUsername(username);
		return fromUser(user);
	}

	@Override
	public UserDTO editUser(Long userId, UserDTO userDTO) {
		User user = userRepository.findOne(userId);
		user.setEmail(userDTO.getEmail());
		user.setPass(userDTO.getPass());
		user.setReceiveNotifications(userDTO.getReceiveNotifications());
		user.setUsername(userDTO.getUsername());
		user.setDob(userDTO.getDob());
		userRepository.save(user);
		return fromUser(user);
	}

	@Override
	public UserDTO enable(Long userId) {
		User user = userRepository.findOne(userId);
		user.setActive(true);
		userRepository.save(user);
		return fromUser(user);
	}

	@Override
	public UserDTO disable(Long userId) {
		User user = userRepository.findOne(userId);
		user.setActive(false);
		userRepository.save(user);
		return fromUser(user);
	}

	@Override
	public UserDTO verify(Long userId) {
		User user = userRepository.findOne(userId);
		user.setVerified(true);
		userRepository.save(user);
		return fromUser(user);
	}

	@Override
	public UserDTO saveUserClubProfile(Long userId, ClubDTO clubDTO) {
		User user = userRepository.findOne(userId);
		user.setProfile(toClub(clubDTO));
		user = userRepository.save(user);
		return fromUser(user);
	}

	@Override
	public UserDTO saveUserCoachProfile(Long userId, CoachDTO coachDTO) {
		User user = userRepository.findOne(userId);
		user.setProfile(toCoach(coachDTO));
		user = userRepository.save(user);
		return fromUser(user);
	}

	@Override
	public ProfileDTO getUserProfile(Long userId) {
		User user = userRepository.findOne(userId);
		return fromUser(user).getProfile();
	}

	@Override
	public UserDTO saveAdmin(UserDTO userDTO) {
		User user = toUser(userDTO);
		user.setProfile(new Admin());
		user.setPass(HashUtils.hash(userDTO.getPass()));
		user = userRepository.save(user);
		return fromUser(user);
	}

	private User toUser(UserDTO userDTO) {
		return mapper.map(userDTO, User.class);
	}

	private UserDTO fromUser(User user) {
		UserDTO userDTO = mapper.map(user, UserDTO.class);
		if (user.getProfile() != null) {
			if (user.getProfile().accepts(new AdminVisitor())) {
				userDTO.setIsAdmin(true);
			}
			if (user.getProfile().accepts(new ClubVisitor())) {
				userDTO.setIsClub(true);
			}
			if (user.getProfile().accepts(new CoachVisitor())) {
				userDTO.setIsCoach(true);
			}
		}
		return userDTO;
	}

	private Coach toCoach(CoachDTO coachDTO) {
		return mapper.map(coachDTO, Coach.class);
	}

	private Club toClub(ClubDTO clubDTO) {
		return mapper.map(clubDTO, Club.class);
	}
}
