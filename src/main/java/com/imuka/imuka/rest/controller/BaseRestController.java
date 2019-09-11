package com.imuka.imuka.rest.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.swagger.annotations.ApiOperation;

public abstract class BaseRestController<Item>{
	public BaseRestController() {}

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
	@ApiOperation(value = "Add a New Item", response = ResponseEntity.class)
	public ResponseEntity<Object> addItem(@Valid @ModelAttribute Item it,
	        RedirectAttributes red) {
				return null;

		}
	@ApiOperation(value = "Update Item with given Id", response = ResponseEntity.class)
	public ResponseEntity<Object> updateItem(@Valid @ModelAttribute Item it,
			@PathVariable("id") long id, RedirectAttributes red){
		//return new ResponseEntity<>(null, HttpStatus.OK);
		return null;
		}
	@ApiOperation(value = "Return All Items", response = ResponseEntity.class)
	public ResponseEntity<Object> getAllItems() {
		return null;
		}
	@ApiOperation(value = "Get Item by Id", response = ResponseEntity.class)
	public ResponseEntity<Object> getItemById(@PathVariable("id") long id) {
		return null;
		}
	@ApiOperation(value = "Get Item By Name", response = ResponseEntity.class)
	public ResponseEntity<Object> getItemByName(@RequestParam("name") String name){
		return null ;
		}

	@ApiOperation(value = "Remove Item", response = ResponseEntity.class)
	public ResponseEntity<Object> removeItem(HttpServletRequest request){
		return null;};
		
		@ApiOperation(value = "Delete Item By Id", response = ResponseEntity.class)
	public ResponseEntity<Object> removeItemById(@PathVariable("id") long id){
		return null;};

		@ApiOperation(value = "Delete All Items", response = ResponseEntity.class)
	public ResponseEntity<Object> removeAllItems() {
		return null;};
}
