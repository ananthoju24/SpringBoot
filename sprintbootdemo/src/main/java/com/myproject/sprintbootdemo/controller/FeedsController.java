package com.myproject.sprintbootdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedsController {

	@Value("${welcome.message}")
	private String welcomeMessage ;

	@GetMapping("/")
	public String getWelComeMessage() {
		return welcomeMessage;
	}
	
	@GetMapping("/default")
	public String getDefaultFeed() {
		return "This is default feed";
	}

}
