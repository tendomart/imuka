package com.imuka.imuka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
//@RequestMapping("/")
public class IndexController {
	//get form
			@GetMapping(value = "/")
				//@Override
				public ModelAndView getForm(ModelAndView md) {
				// md.addObject("anonynmoususer",new AnonynmousGuest());
				md.setViewName("index");
				return md;
				}
}
