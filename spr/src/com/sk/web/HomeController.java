package com.sk.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class HomeController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home() {
		System.out.println("/ requested");
		return "sk";
	}
	
	@RequestMapping(value="/homePage",method=RequestMethod.GET)
	public String homepage() {
		System.out.println("home requested");
		return "homePage";
	}
	
	@RequestMapping(value="/loginPage",method=RequestMethod.GET)
	public String loginpage(@RequestParam(value="error",required=false) String error,@RequestParam(value="logout",required=false) String logout,Model model) {
		System.out.println("/loginPage requested");
		if(error !=null) {
			model.addAttribute("error", "Invalid credintials provided");
		}
		if (logout !=null) {
			model.addAttribute("logout", "Logged out successfully..");
		}
		return "loginPage";
	}
	

}
