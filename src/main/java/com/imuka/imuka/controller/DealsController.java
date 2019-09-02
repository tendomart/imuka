package com.imuka.imuka.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.imuka.imuka.model.Deals;

@Controller
@RequestMapping("deals")
public class DealsController extends BaseController<Deals>{

	@Override
	public ModelAndView addItem(@Valid Deals it, BindingResult result, ModelAndView md, RedirectAttributes red) {
		// TODO Auto-generated method stub
		return super.addItem(it, result, md, red);
	}
	
	@Override
	public ModelAndView getAllItems(ModelAndView md) {
		// TODO Auto-generated method stub
		return super.getAllItems(md);
	}
	
	
	@Override
	public ModelAndView getItemById(long id, ModelAndView md) {
		// TODO Auto-generated method stub
		return super.getItemById(id, md);
	}
	
	@Override
	public ModelAndView getForm(ModelAndView md) {
		// TODO Auto-generated method stub
		return super.getForm(md);
	}
	
	
	@Override
	public ModelAndView removeAllItems(ModelAndView md) {
		// TODO Auto-generated method stub
		return super.removeAllItems(md);
	}
	
	@Override
	public ModelAndView removeItem(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return super.removeItem(request);
	}
	
	
	@Override
	public ModelAndView updateItem(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return super.updateItem(request);
	}
}
