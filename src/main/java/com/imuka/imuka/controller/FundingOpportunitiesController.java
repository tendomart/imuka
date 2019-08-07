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
import com.imuka.imuka.model.FundingOpportunities;
import com.imuka.imuka.service.ImukaService;

@Controller
@RequestMapping("funds")
public class FundingOpportunitiesController extends BaseController<FundingOpportunities>{
	private static final Logger log = LogManager.getLogger("com.imuka.imuka.controller.FundingOpportunitiesController");

	//install service
	@Autowired(required = true)
	@Qualifier(value = "fundingOpportunitiesServiceImpl")
	private ImukaService<FundingOpportunities> fnd;
	
	//get form
	@GetMapping(value = "/")
	@Override
		public ModelAndView getForm(ModelAndView md) {
		 md.addObject("funds",new FundingOpportunities());
		md.setViewName("FundingOpportunities");
		return md;
		}
	
	@Override
	@PostMapping(value = "/")
	public ModelAndView addItem(@Valid FundingOpportunities fn, BindingResult result, ModelAndView md, RedirectAttributes red) {
		if (result.hasErrors()) {
			md.setViewName("403");
            return md;
        }
        fnd.addItem(fn);
        md.addObject("funds",new FundingOpportunities());
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
          Optional<FundingOpportunities> byId = fnd.getItemById(id);
		
		if (byId == null) {
			log.info("Sorry Requested Id is not available");
			return null;
		}
		md.addObject("result", byId);
		md.setViewName("FundingOpportunities");
		return md;
		}
	
	@DeleteMapping(value = "/{id}")
	@Override
		public ModelAndView removeItem(HttpServletRequest request) {
		Long Id = Long.parseLong(request.getParameter("id"));
		Optional<FundingOpportunities> fn = fnd.getItemById(Id);
					fnd.removeItem(Id);
		return new ModelAndView("redirect:/").addObject("FundingOpportunitiesList", fn);
		}
	
	@GetMapping(value = "/fnds")
		public ModelAndView getAllGuests(ModelAndView md) {
		md.addObject("FundingOpportunitiesList", fnd.getAllItems());
		md.setViewName("FundingOpportunitiesList");
		return md;
		}
	
	//Delete all students
	@DeleteMapping(value = "/")
	@Override
		public ModelAndView removeAllItems(ModelAndView md) {
		fnd.removeAllItems();
		md.addObject("fundingOpportunitiesList", fnd.getAllItems());
		md.setViewName("FundingOpportunitiesList");
		return md;
		}
}