package com.imuka.imuka.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public abstract class BaseController<Item>{
	public BaseController() {}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	 SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	 dateFormat.setLenient(false);
	 webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	 }
	
	
	public Date parseDate(String dateStr) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = dateFormat.parse(dateStr);
		return date;
	}
	//@InitBinder
   // public void initBinder (WebDataBinder binder) {
      //  binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true));
   // }
	public ModelAndView getForm(ModelAndView md) {
		return md;
		}

	public ModelAndView addItem(@Valid @ModelAttribute Item it, BindingResult result, ModelAndView md,
	        RedirectAttributes red) {
				return md;

		}

	public ModelAndView updateItem(HttpServletRequest request){
		return null;
		}
	public ModelAndView getAllItems(ModelAndView md) {
		return null;
		}
	public ModelAndView getItemById(@PathVariable("id") long id, ModelAndView md) {
		return null;
		}
	public ModelAndView getItemByName(@RequestParam("name") String name, ModelAndView md){
		return null ;
		}

	public ModelAndView removeItem(HttpServletRequest request){
		return null;};

	public ModelAndView removeItemByName(String Name){
		return null;};

	public ModelAndView removeAllItems(ModelAndView md) {
		return null;};
}
