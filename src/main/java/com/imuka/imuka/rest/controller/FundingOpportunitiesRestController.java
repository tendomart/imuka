package com.imuka.imuka.rest.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.HibernateError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.imuka.imuka.model.FundingOpportunities;
import com.imuka.imuka.service.ImukaService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("rs")
@Api(value="Funding Opportunities", description="Funding Opportunities Rest-API for CRUD Operations")
public class FundingOpportunitiesRestController extends BaseRestController<FundingOpportunities>{
	@Autowired(required = true)
	@Qualifier(value = "fundingOpportunitiesServiceImpl")
	private ImukaService<FundingOpportunities> fn;
	
	 @GetMapping("/funds")
	@Override
	public ResponseEntity<Object> getAllItems() {
		 return new ResponseEntity<>(fn.getAllItems(), HttpStatus.OK);
		    
	}
	
@PostMapping("/fund")
@Override
	public ResponseEntity<Object> addItem(@Valid FundingOpportunities fnd, RedirectAttributes red) {
	       fn.addItem(fnd);
	        return new ResponseEntity("Funding Opportunity saved successfully", HttpStatus.OK);
	}
	
@GetMapping("/fund/{id}")
@Override
public ResponseEntity<Object> getItemById(long id) {
	Optional<FundingOpportunities> fnd = fn.getItemById(id);

 	if (!fnd.isPresent()) {
 		throw new HibernateError("Sorry We Cannot Find Opportunity with id "+id);
 	}
 	 return new ResponseEntity<>(fnd, HttpStatus.OK);
}
@DeleteMapping("/fund/{id}")
@Override
public ResponseEntity<Object> removeItemById(@PathVariable("id") long id) {
	Optional<FundingOpportunities> fnd = fn.getItemById(id);

 	if (!fnd.isPresent()) {
 		throw new HibernateError("Sorry We Cannot Find "+id);
 	}
 	fn.removeItem(id);
 	 return new ResponseEntity<>("Successfully Removed Funding Opportunity with id "+id, HttpStatus.OK);
}

@DeleteMapping("/funds")
@Override
public ResponseEntity<Object> removeAllItems() {
	fn.removeAllItems();
	 return new ResponseEntity<>("Successfully Deleted All Funding Opportunities", HttpStatus.OK);
}

@PutMapping("/fund/{id}")
@Override
public ResponseEntity<Object> updateItem(@Valid FundingOpportunities it, long id, RedirectAttributes red) {
	Optional<FundingOpportunities> fnd = fn.getItemById(id);
 	if (!fnd.isPresent()) {
 		throw new HibernateError("Sorry We Cannot Find Workshop with Id "+id);
 	}
 	fn.addItem(it);
 	 return new ResponseEntity<>("Funding Opportunity Updated Successfully !", HttpStatus.OK);
}
}
