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
import com.imuka.imuka.model.Workshops;
import com.imuka.imuka.service.ImukaService;
@Controller
@RequestMapping("workshop")
public class WorkshopsController extends BaseController<Workshops>{
	private static final Logger log = LogManager.getLogger("com.imuka.farm.controller.WorkshopsController");

	//install servicse
	@Autowired(required = true)
	@Qualifier(value = "workshopsServiceImpl")
	private ImukaService<Workshops> wk;
	
	//get form
	@GetMapping(value = "/")
	@Override
		public ModelAndView getForm(ModelAndView md) {
		 md.addObject("events",new Events());
		md.setViewName("Workshops");
		return md;
		}
	
	@PostMapping(value = "/")
	public ModelAndView addItem(@Valid Workshops w, BindingResult result, ModelAndView md, RedirectAttributes red) {
		if (result.hasErrors()) {
			md.setViewName("403");
            return md;
        }
        wk.addItem(w);
        md.addObject("events",new Events());
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
          Optional<Workshops> byId = wk.getItemById(id);
		
		if (byId == null) {
			log.info("Sorry Requested Id is not available");
			return null;
		}
		md.addObject("result", byId);
		md.setViewName("Workshops");
		return md;
		}
	
	@DeleteMapping(value = "/{id}")
	@Override
		public ModelAndView removeItem(HttpServletRequest request) {
		Long Id = Long.parseLong(request.getParameter("id"));
		Optional<Workshops> w = wk.getItemById(Id);
					wk.removeItem(Id);
		return new ModelAndView("redirect:/").addObject("WorkshopsList", wk);
		}
	
	@GetMapping(value = "/wks")
		public ModelAndView getAllGuests(ModelAndView md) {
		md.addObject("workshopsList", wk.getAllItems());
		md.setViewName("WorkshopsList");
		return md;
		}
	
	//Delete all students
	@DeleteMapping(value = "/")
	@Override
		public ModelAndView removeAllItems(ModelAndView md) {
		wk.removeAllItems();
		md.addObject("workshopsList", wk.getAllItems());
		md.setViewName("WorkshopsList");
		return md;
		}
}