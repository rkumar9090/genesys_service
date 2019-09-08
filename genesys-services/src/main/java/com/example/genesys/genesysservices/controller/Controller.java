package com.example.genesys.genesysservices.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping("/test")
	public String test() {
		return "Hello World";
	}
}
