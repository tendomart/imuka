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

import com.imuka.imuka.model.Events;
import com.imuka.imuka.service.ImukaService;

@Controller
@RequestMapping("events")
public class EventsController extends BaseController<Events>{
	private static final Logger log = LogManager.getLogger("com.imuka.farm.controller.EventsController");

	
	//install service
			@Autowired(required = true)
			@Qualifier(value = "eventsServiceImpl")
			private ImukaService<Events> evt;
			
			//get form
			@GetMapping(value = "/")
			@Override
				public ModelAndView getForm(ModelAndView md) {
				 md.addObject("events",new Events());
				md.setViewName("Events");
				return md;
				}
			
			@GetMapping(value = "/p")
			public ModelAndView getHome(ModelAndView md) {
			    md.addObject("event",new Events());
				md.setViewName("Home");
				return md;
				}
			@Override
			@PostMapping(value = "/")
			public ModelAndView addItem(@Valid Events ev, BindingResult result, ModelAndView md, RedirectAttributes red) {
				if (result.hasErrors()) {
					md.addObject("result",result);
					md.setViewName("403");
		            return md;
		        }
		        evt.addItem(ev);
		        md.addObject("events",new Events());
		        md.setViewName("Events");
		        red.addFlashAttribute("message", "Success");
		        red.addFlashAttribute("alertClass", "alert-success");
		        return md;
				}
			//@GetMapping("/{id}")
			//@Override
				//public ModelAndView updateItem(HttpServletRequest request) {
					// TODO Auto-generated method stub
					//return super.updateItem(request);
				//}
//			Get Client By ID
			@GetMapping("/{id}")
			@Override
				public ModelAndView getItemById(long id, ModelAndView md) {
		          Optional<Events> byId = evt.getItemById(id);
				
				if (byId == null) {
					log.info("Sorry Requested Id is not available");
					return null;
				}
				md.addObject("event", byId);
				md.setViewName("Home");
				return md;
				}
			
			@DeleteMapping(value = "/{id}")
			@Override
				public ModelAndView removeItem(HttpServletRequest request) {
				Long Id = Long.parseLong(request.getParameter("id"));
				Optional<Events> ev = evt.getItemById(Id);
							evt.removeItem(Id);
				return new ModelAndView("redirect:/").addObject("EventsList", ev);
				}
			
			@GetMapping(value = "/evts")
				public ModelAndView getAllGuests(ModelAndView md) {
				md.addObject("eventsList", evt.getAllItems());
				md.setViewName("EventsList");
				return md;
				}
			
			//Delete all students
			@DeleteMapping(value = "/")
			@Override
				public ModelAndView removeAllItems(ModelAndView md) {
				evt.removeAllItems();
				md.addObject("eventList", evt.getAllItems());
				md.setViewName("EventList");
				return md;
				}
}