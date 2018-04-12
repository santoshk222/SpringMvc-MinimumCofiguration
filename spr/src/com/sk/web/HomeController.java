package com.sk.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sk")
public class HomeController {
	@RequestMapping(method=RequestMethod.GET)
	public String home() {
		System.out.println("sk requested");
		return "sk";
	}
	

}
