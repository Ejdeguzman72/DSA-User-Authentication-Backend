package com.dsa.DeGuzmanServerApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/app-controller")
public class AppController {

	@GetMapping("/hello-world")
	public String SayHelloWorld() {
		return "Hello World!";
	}
}
