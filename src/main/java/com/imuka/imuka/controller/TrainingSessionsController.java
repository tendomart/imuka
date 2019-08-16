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
import com.imuka.imuka.model.TrainingSessions;
import com.imuka.imuka.service.ImukaService;
@Controller
@RequestMapping("training")
public class TrainingSessionsController extends BaseController<TrainingSessionsController>{
	private static final Logger log = LogManager.getLogger("com.imuka.imuka.controller.TrainingSessionsController");

	//install service
	@Autowired(required = true)
	@Qualifier(value = "trainingSessionsServiceImpl")
	private ImukaService<TrainingSessions> tss;
	
	//get form
	@GetMapping(value = "/")
	@Override
		public ModelAndView getForm(ModelAndView md) {
		 md.addObject("training",new TrainingSessions());
		md.setViewName("TrainingSessions");
		return md;
		}
	
	@PostMapping(value = "/")
	public ModelAndView addItem(@Valid TrainingSessions ts, BindingResult result, ModelAndView md, RedirectAttributes red) {
		if (result.hasErrors()) {
			md.setViewName("403");
            return md;
        }
        tss.addItem(ts);
        md.addObject("training",new TrainingSessions());
        md.setViewName("TrainingSessions");
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
          Optional<TrainingSessions> byId = tss.getItemById(id);
		
		if (byId == null) {
			log.info("Sorry Requested Id is not available");
			return null;
		}
		md.addObject("result", byId);
		md.setViewName("TrainingSessions");
		return md;
		}
	
	@DeleteMapping(value = "/{id}")
	@Override
		public ModelAndView removeItem(HttpServletRequest request) {
		Long Id = Long.parseLong(request.getParameter("id"));
		Optional<TrainingSessions> ts = tss.getItemById(Id);
					tss.removeItem(Id);
		return new ModelAndView("redirect:/").addObject("TrainingSessionsList", ts);
		}
	
	@GetMapping(value = "/sessions")
		public ModelAndView getAllGuests(ModelAndView md) {
		md.addObject("trainingSessionsList", tss.getAllItems());
		md.setViewName("TrainingSessionsList");
		return md;
		}
	
	//Delete all students
	@DeleteMapping(value = "/")
	@Override
		public ModelAndView removeAllItems(ModelAndView md) {
		tss.removeAllItems();
		md.addObject("trainingSessionsList", tss.getAllItems());
		md.setViewName("TrainingSessionsList");
		return md;
		}
	
}