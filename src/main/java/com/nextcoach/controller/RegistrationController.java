package com.nextcoach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nextcoach.dto.ClubDTO;
import com.nextcoach.dto.CoachDTO;
import com.nextcoach.dto.UserDTO;
import com.nextcoach.security.SecurityService;
import com.nextcoach.service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registrationPage(Model model) {
		UserDTO user = new UserDTO();
		model.addAttribute("user", user);
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String register(@ModelAttribute UserDTO userDTO) {
		UserDTO user = userService.saveUser(userDTO);
		if (user.getId() != null) {
			securityService.autologin(userDTO.getUsername(), userDTO.getPass());
		}
		return "/choose-profile";
	}

	@RequestMapping(value = "/edit-club-profile", method = RequestMethod.GET)
	public String editClubProfile(Model model) {
		ClubDTO club = new ClubDTO();
		model.addAttribute("club", club);
		return "edit-club-profile";
	}

	@RequestMapping(value = "/edit-club-profile", method = RequestMethod.POST)
	public String saveClubProfile(@ModelAttribute ClubDTO clubDTO) {
		Long id = securityService.getAuthenticatedUser().getId();
		userService.saveUserClubProfile(id, clubDTO);
		return "redirect:/home";
	}

	@RequestMapping(value = "/edit-coach-profile", method = RequestMethod.GET)
	public String editCoachProfile(Model model) {
		CoachDTO coach = new CoachDTO();
		model.addAttribute("coach", coach);
		return "edit-coach-profile";
	}

	@RequestMapping(value = "/edit-coach-profile", method = RequestMethod.POST)
	public String saveCoachProfile(@ModelAttribute CoachDTO coachDTO) {
		Long id = securityService.getAuthenticatedUser().getId();
		userService.saveUserCoachProfile(id, coachDTO);
		return "redirect:/home";
	}
}
