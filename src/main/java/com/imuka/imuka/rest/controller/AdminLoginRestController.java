package com.imuka.imuka.rest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.imuka.imuka.model.AnonynmousGuest;

@RestController
//@CrossOrigin(origins = "http://localhost:4000/")
public class AdminLoginRestController {

	@GetMapping(value = "/")
	//@Override
	public ModelAndView getForm(ModelAndView md) {
	 //md.addObject("anonynmousGuest",new AnonynmousGuest());
	md.setViewName("swagger-ui.html");
	return md;
	}
}
