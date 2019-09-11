package com.imuka.imuka.rest.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.HibernateError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.imuka.imuka.model.AnonynmousGuest;
import com.imuka.imuka.model.Workshops;
import com.imuka.imuka.service.ImukaService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("rs")
@Api(value="Workshops", description="Workshops Rest-API for CRUD Operations")
public class WorkshopsRestController extends BaseRestController<Workshops> {

	@Autowired(required = true)
	@Qualifier(value = "workshopsServiceImpl")
	private ImukaService<Workshops> wk;
	
	 @GetMapping("/workshops")
	@Override
	public ResponseEntity<Object> getAllItems() {
		 return new ResponseEntity<>(wk.getAllItems(), HttpStatus.OK);
		    
	}
	
@PostMapping("/workshop")
@Override
	public ResponseEntity<Object> addItem(@Valid Workshops it, RedirectAttributes red) {
	       wk.addItem(it);
	        return new ResponseEntity("Workshop saved successfully", HttpStatus.OK);
	}
	
@GetMapping("/workshop/{id}")
@Override
public ResponseEntity<Object> getItemById(long id) {
	Optional<Workshops> wrk = wk.getItemById(id);

 	if (!wrk.isPresent()) {
 		throw new HibernateError("Sorry We Cannot Find "+id);
 	}
 	 return new ResponseEntity<>(wrk, HttpStatus.OK);
}
@DeleteMapping("/workshop/{id}")
@Override
public ResponseEntity<Object> removeItemById(@PathVariable("id") long id) {
	Optional<Workshops> wrk = wk.getItemById(id);

 	if (!wrk.isPresent()) {
 		throw new HibernateError("Sorry We Cannot Find "+id);
 	}
 	wk.removeItem(id);
 	 return new ResponseEntity<>("Successfully Removed Workshop with id "+id, HttpStatus.OK);
}

@DeleteMapping("/workshops")
@Override
public ResponseEntity<Object> removeAllItems() {
	wk.removeAllItems();
	 return new ResponseEntity<>("Successfully Deleted All Workshops", HttpStatus.OK);
}

@PutMapping("/workshop")
@Override
public ResponseEntity<Object> updateItem(@Valid Workshops it, long id, RedirectAttributes red) {
	Optional<Workshops> wrk = wk.getItemById(id);
 	if (!wrk.isPresent()) {
 		throw new HibernateError("Sorry We Cannot Find Workshop with Id "+id);
 	}
 	wk.addItem(it);
 	 return new ResponseEntity<>("Workshop Updated Successfully !", HttpStatus.OK);
}

}
