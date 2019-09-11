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
import com.imuka.imuka.model.VisitOpportunities;
import com.imuka.imuka.service.ImukaService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("rs")
@Api(value="Visit Opportunities", description="Visit Opportunities Rest-API for CRUD Operations")
public class VisitOpportunitiesRestController extends BaseRestController<VisitOpportunities>{

	@Autowired(required = true)
	@Qualifier(value = "visitOpportunitiesServiceImpl")
	private ImukaService<VisitOpportunities> vs;
	
	 @GetMapping("/visits")
	@Override
	public ResponseEntity<Object> getAllItems() {
		 return new ResponseEntity<>(vs.getAllItems(), HttpStatus.OK);
		    
	}
	
@PostMapping("/visit")
@Override
	public ResponseEntity<Object> addItem(@Valid VisitOpportunities vst, RedirectAttributes red) {
	       vs.addItem(vst);
	        return new ResponseEntity("Visit Opportunity saved successfully", HttpStatus.CREATED);
	}
	
@GetMapping("/visit/{id}")
@Override
public ResponseEntity<Object> getItemById(long id) {
	Optional<VisitOpportunities> vst = vs.getItemById(id);

 	if (!vst.isPresent()) {
 		//throw new HibernateError("Sorry We Cannot Find Visit with id "+id);
 		return new ResponseEntity<>("Sorry We Cannot Find Visit with id  "+id, HttpStatus.NOT_FOUND);

 	}
 	 return new ResponseEntity<>(vst, HttpStatus.OK);
}
@DeleteMapping("/visit/{id}")
@Override
public ResponseEntity<Object> removeItemById(@PathVariable("id") long id) {
	Optional<VisitOpportunities> vst = vs.getItemById(id);

 	if (!vst.isPresent()) {
 		throw new HibernateError("Sorry We Cannot Find Visit with Id "+id);
 	}
 	vs.removeItem(id);
 	 return new ResponseEntity<>("Successfully Removed Visit Opportunity with id "+id, HttpStatus.GONE);
}

@DeleteMapping("/visits")
@Override
public ResponseEntity<Object> removeAllItems() {
	vs.removeAllItems();
	 return new ResponseEntity<>("Successfully Deleted All Visit Opportunities", HttpStatus.GONE);
}

@PutMapping("/visit/{id}")
@Override
public ResponseEntity<Object> updateItem(@Valid VisitOpportunities it, long id, RedirectAttributes red) {
	Optional<VisitOpportunities> vst = vs.getItemById(id);
 	if (!vst.isPresent()) {
 		//throw new HibernateError("Sorry We Cannot Find Workshop with Id "+id);
 		return new ResponseEntity<>("Sorry We Cannot Find Visit Opportunity with Id !", HttpStatus.NOT_FOUND);

 	}
 	vs.addItem(it);
 	 return new ResponseEntity<>("Visit Opportunity Updated Successfully !", HttpStatus.ACCEPTED);
}
	
}
