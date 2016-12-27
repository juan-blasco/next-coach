package com.nextcoach.service;

import java.util.List;

import com.nextcoach.dto.ClubDTO;
import com.nextcoach.dto.CoachDTO;
import com.nextcoach.dto.ProfileDTO;
import com.nextcoach.dto.UserDTO;

public interface UserService {

	List<UserDTO> getUsers();

	UserDTO saveUser(UserDTO user);

	UserDTO saveAdmin(UserDTO user);

	UserDTO getUser(Long userId);

	UserDTO editUser(Long userId, UserDTO userDTO);

	UserDTO enable(Long userId);

	UserDTO disable(Long userId);

	UserDTO getUser(String username);

	UserDTO verify(Long userId);

	ProfileDTO getUserProfile(Long userId);

	UserDTO saveUserClubProfile(Long userId, ClubDTO clubDTO);

	UserDTO saveUserCoachProfile(Long userId, CoachDTO coachDTO);

}
