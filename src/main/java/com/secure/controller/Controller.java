package com.secure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller 
{
	
	@GetMapping("/home")
	public String homeHandler()
	{
		return "This is home page!!";
	}

}
