package com.imuka.imuka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.imuka.imuka.model.AnonynmousGuest;
import com.imuka.imuka.model.Events;
import com.imuka.imuka.service.EventsServiceImpl;
import com.imuka.imuka.service.FundingOpportunitiesServiceImpl;
import com.imuka.imuka.service.ImukaService;
import com.imuka.imuka.service.TrainingSessionsServiceImpl;
import com.imuka.imuka.service.VisitOpportunitiesServiceImpl;
import com.imuka.imuka.service.WorkshopsServiceImpl;
@Controller
public class IndexController {
	EventsServiceImpl evt ;
	FundingOpportunitiesServiceImpl fnd;
	TrainingSessionsServiceImpl tr;
	VisitOpportunitiesServiceImpl vs;
	WorkshopsServiceImpl wk;
	@Autowired
    public IndexController(EventsServiceImpl evt, FundingOpportunitiesServiceImpl fnd,
    		TrainingSessionsServiceImpl tr,VisitOpportunitiesServiceImpl vs,WorkshopsServiceImpl wk) {
       this.evt=evt;
       this.fnd=fnd;
       this.tr=tr;
       this.vs=vs;
       this.wk=wk;
    }
	//@Autowired(required = true)
	//@Qualifier(value = "eventsServiceImpl")
	//private ImukaService<Events> evt;
	//get form
			@GetMapping(value = "/")
				//@Override
				public ModelAndView getForm(ModelAndView md) {
				 md.addObject("events",evt.getAllItems());
				 md.addObject("funds",fnd.getAllItems());
				 md.addObject("training",tr.getAllItems());
				 md.addObject("visits",vs.getAllItems());
				 md.addObject("workshops",wk.getAllItems());
				md.setViewName("Home");
				return md;
				}
			
			@GetMapping(value = "/home")
			//@Override
			public ModelAndView getHome(ModelAndView md) {
					md.setViewName("index");
			return md;
			}
}
