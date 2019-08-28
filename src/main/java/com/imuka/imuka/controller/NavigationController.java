package com.imuka.imuka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.imuka.imuka.model.Events;
import com.imuka.imuka.model.FundingOpportunities;
import com.imuka.imuka.model.TrainingSessions;
import com.imuka.imuka.model.VisitOpportunities;
import com.imuka.imuka.model.Workshops;
import com.imuka.imuka.service.EventsServiceImpl;
import com.imuka.imuka.service.FundingOpportunitiesServiceImpl;
import com.imuka.imuka.service.TrainingSessionsServiceImpl;
import com.imuka.imuka.service.VisitOpportunitiesServiceImpl;
import com.imuka.imuka.service.WorkshopsServiceImpl;

@Controller
public class NavigationController {
  
	EventsServiceImpl evt ;
	FundingOpportunitiesServiceImpl fnd;
	TrainingSessionsServiceImpl tr;
	VisitOpportunitiesServiceImpl vs;
	WorkshopsServiceImpl wk;
	@Autowired
    public NavigationController(EventsServiceImpl evt, FundingOpportunitiesServiceImpl fnd,
    		TrainingSessionsServiceImpl tr,VisitOpportunitiesServiceImpl vs,WorkshopsServiceImpl wk) {
       this.evt=evt;
       this.fnd=fnd;
       this.tr=tr;
       this.vs=vs;
       this.wk=wk;
    }
	@GetMapping("evts")
	public ModelAndView events(ModelAndView md) {
	   md.addObject("event", evt.getAllItems());
	   md.setViewName("main_events_fragment");
		return md;
		}
   
   @GetMapping("fnd")
	public ModelAndView funds(ModelAndView md) {
	   md.addObject("funds", fnd.getAllItems());
	   md.setViewName("main_funding_opportunities");
		return md;
		}
   
   @GetMapping("wks")
	public ModelAndView workshops(ModelAndView md) {
	   md.addObject("workshops", wk.getAllItems());
	   md.setViewName("main_workshop_fragment");
		return md;
		}
   
   @GetMapping("vst")
	public ModelAndView visits(ModelAndView md) {
	   md.addObject("visits", vs.getAllItems());
	   md.setViewName("main_visits_fragment");
		return md;
		}
   
   @GetMapping("/trn")
	public ModelAndView training(ModelAndView md) {
	   md.addObject("train", tr.getAllItems());
	   md.setViewName("main_training_session");
		return md;
		}
}


