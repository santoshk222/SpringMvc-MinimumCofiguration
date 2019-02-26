package com.sk.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class HomeController {

	public static final Logger logger = Logger.getLogger(HomeController.class);
	public static final String log = HomeController.class + "-";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.debug(log + "/");
		return "sk";
	}

	@RequestMapping(value = "/homePage", method = RequestMethod.GET)
	public String homepage() {
		logger.debug(log + "/homePage");
		return "homePage";
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String loginpage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		logger.debug(log + "/loginPage");
		if (error != null) {
			model.addAttribute("error", "Invalid credintials provided");
			logger.debug(log + "Error Invalid credintials");
		}
		if (logout != null) {
			model.addAttribute("logout", "Logged out successfully..");
			logger.debug(log + "Logged out");
		}
		return "loginPage";
	}

}
