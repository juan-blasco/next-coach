package com.nextcoach.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nextcoach.dto.ClubDTO;
import com.nextcoach.dto.CoachDTO;
import com.nextcoach.dto.ProfileDTO;
import com.nextcoach.dto.UserDTO;
import com.nextcoach.service.UserService;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	public UserDTO getUser(@PathVariable Long userId) {
		return userService.getUser(userId);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public UserDTO saveUser(@RequestBody UserDTO userDTO) {
		return userService.saveUser(userDTO);
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admins", method = RequestMethod.POST)
	public UserDTO saveAdmin(@RequestBody UserDTO userDTO) {
		return userService.saveAdmin(userDTO);
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<UserDTO> getUsers(@RequestBody UserDTO userDTO) {
		return userService.getUsers();
	}

	@RequestMapping(value = "/users/{userId}/profile", method = RequestMethod.GET)
	public ProfileDTO getUserProfile(@PathVariable Long userId) {
		return userService.getUserProfile(userId);
	}

	@RequestMapping(value = "/users/{userId}/club", method = RequestMethod.POST)
	public UserDTO saveUserProfile(@PathVariable Long userId, @RequestBody ClubDTO clubDTO) {
		return userService.saveUserClubProfile(userId, clubDTO);
	}

	@RequestMapping(value = "/users/{userId}/coach", method = RequestMethod.POST)
	public UserDTO saveUserProfile(@PathVariable Long userId, @RequestBody CoachDTO coachDTO) {
		return userService.saveUserCoachProfile(userId, coachDTO);
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
	public UserDTO editUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
		return userService.editUser(userId, userDTO);
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.PATCH)
	public UserDTO setActive(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
		if (userDTO.getActive()) {
			return userService.enable(userId);
		} else {
			return userService.disable(userId);
		}
	}
}
