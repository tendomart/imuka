package com.imuka.imuka.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.imuka.imuka.Util.Pager;
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
public class IndexController {
	private static final int INITIAL_PAGE = 0;
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
	
			@GetMapping(value = "/")
				//@Override
				public ModelAndView getForm(@RequestParam("page") Optional<Integer> page,ModelAndView md ) {
				  // Evaluate page. If requested parameter is null or less than 0 (to
		        // prevent exception), return initial size. Otherwise, return value of
		        // param. decreased by 1.
		        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

		        Page<Events> ev = evt.findAllProductsPageable(new PageRequest(evalPage, 5));
		       Pager<Events> evpager = new Pager<Events>(ev);
				
		        Page<FundingOpportunities> fn = fnd.findAllProductsPageable(new PageRequest(evalPage, 5));
		        Pager<FundingOpportunities> fnpager = new Pager<FundingOpportunities>(fn);
				
		        Page<TrainingSessions> t = tr.findAllProductsPageable(new PageRequest(evalPage, 5));
		        Pager<TrainingSessions> tpager = new Pager<TrainingSessions>(t);
				
		        Page<VisitOpportunities> v = vs.findAllProductsPageable(new PageRequest(evalPage, 5));
		        Pager<VisitOpportunities> vpager = new Pager<VisitOpportunities>(v);
				
		        Page<Workshops> w = wk.findAllProductsPageable(new PageRequest(evalPage, 5));
		        Pager<Workshops> wpager = new Pager<Workshops>(w);
				
		        
				md.addObject("events",evt.getAllItems());
				  md.addObject("evpager", evpager);
				 md.addObject("funds",fnd.getAllItems());
				 md.addObject("fnpager", fnpager);
				 md.addObject("training",tr.getAllItems());
				 md.addObject("tpager", tpager);
				 md.addObject("visits",vs.getAllItems());
				 md.addObject("vpager", vpager);
				 md.addObject("workshops",wk.getAllItems());
				 md.addObject("wpager", wpager);
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
