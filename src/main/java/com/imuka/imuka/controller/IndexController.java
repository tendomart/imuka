package com.imuka.imuka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.imuka.imuka.model.AnonynmousGuest;
@Controller
//@RequestMapping("/")
public class IndexController {
	//get form
			@GetMapping(value = "/")
				//@Override
				public ModelAndView getForm(ModelAndView md) {
				 md.addObject("anonynmousGuest",new AnonynmousGuest());
				md.setViewName("index");
				return md;
				}
}
