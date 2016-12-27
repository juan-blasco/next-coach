package com.nextcoach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nextcoach.dto.UserDTO;
import com.nextcoach.security.SecurityService;
import com.nextcoach.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Model model) {
		UserDTO user = userService.getUser(securityService.getAuthenticatedUser().getId());
		model.addAttribute("user", user);
		return "home";
	}
}
