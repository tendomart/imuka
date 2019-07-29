package com.imuka.imuka.controller;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.imuka.imuka.model.AnonynmousGuest;
import com.imuka.imuka.service.ImukaService;

@Controller
@RequestMapping("anonynm")
public class AnonynmousGuestController extends BaseController<AnonynmousGuest>{
	private static final Logger log = LogManager.getLogger("com.imuka.farm.controller.AnonynmousGuestController");

	//install servicse
		@Autowired(required = true)
		@Qualifier(value = "anonynmousGuestServiceImpl")
		private ImukaService<AnonynmousGuest> anon;
		
		//get form
		@GetMapping(value = "/")
		@Override
			public ModelAndView getForm(ModelAndView md) {
			 md.addObject("anonynmoususer",new AnonynmousGuest());
			md.setViewName("anonynmoususer");
			return md;
			}
		@Override
		@PostMapping(value = "/")
		public ModelAndView addItem(@Valid AnonynmousGuest an, BindingResult result, ModelAndView md, RedirectAttributes red) {
			//red.addFlashAttribute("message", "Failed");
		    //red.addFlashAttribute("alertClass", "alert-danger");
			if (result.hasErrors()) {
				md.setViewName("403");
	            return md;
	        }
	        anon.addItem(an);
	        md.addObject("anonynmousGuest",new AnonynmousGuest());
	       // md.setViewName("registerStudent");
	        red.addFlashAttribute("message", "Success");
	        red.addFlashAttribute("alertClass", "alert-success");
	        return md;
			}
		@Override
			public ModelAndView updateItem(HttpServletRequest request) {
				// TODO Auto-generated method stub
				return super.updateItem(request);
			}
		//Get Client By ID
		@GetMapping("/{id}")
		@Override
			public ModelAndView getItemById(long id, ModelAndView md) {
	          Optional<AnonynmousGuest> byId = anon.getItemById(id);
			
			if (byId == null) {
				log.info("Sorry Requested Id is not available");
				return null;
			}
			md.addObject("result", byId);
			md.setViewName("AnonymousGuest");
			return md;
			}
		
		@DeleteMapping(value = "/{id}")
		@Override
			public ModelAndView removeItem(HttpServletRequest request) {
			Long Id = Long.parseLong(request.getParameter("id"));
			Optional<AnonynmousGuest> an = anon.getItemById(Id);
						anon.removeItem(Id);
			return new ModelAndView("redirect:/").addObject("AnonymousGuestList", an);
			}
		
		@GetMapping(value = "/gs")
			public ModelAndView getAllGuests(ModelAndView md) {
			md.addObject("anonymousGuestList", anon.getAllItems());
			md.setViewName("AnonymousGuestList");
			return md;
			}
		
		//Delete all students
		@DeleteMapping(value = "/")
		@Override
			public ModelAndView removeAllItems(ModelAndView md) {
			anon.removeAllItems();
			md.addObject("anonymousGuestList", anon.getAllItems());
			md.setViewName("AnonymousGuestList");
			return md;
			}
		
	
}