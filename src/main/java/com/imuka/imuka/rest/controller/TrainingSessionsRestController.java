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
import com.imuka.imuka.model.TrainingSessions;
import com.imuka.imuka.service.ImukaService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("rs")
@Api(value="Training Sessions", description="Training Sessions Rest-API for CRUD Operations")
public class TrainingSessionsRestController extends BaseRestController<TrainingSessions>{
	@Autowired(required = true)
	@Qualifier(value = "trainingSessionsServiceImpl")
	private ImukaService<TrainingSessions> tr;
	
	 @GetMapping("/train")
	@Override
	public ResponseEntity<Object> getAllItems() {
		 return new ResponseEntity<>(tr.getAllItems(), HttpStatus.OK);
		    
	}
	
@PostMapping("/train")
@Override
	public ResponseEntity<Object> addItem(@Valid TrainingSessions trn, RedirectAttributes red) {
	       tr.addItem(trn);
	        return new ResponseEntity("Training Session saved successfully", HttpStatus.OK);
	}
	
@GetMapping("/train/{id}")
@Override
public ResponseEntity<Object> getItemById(long id) {
	Optional<TrainingSessions> trn = tr.getItemById(id);

 	if (!trn.isPresent()) {
 		throw new HibernateError("Sorry We Cannot Training Session with id "+id);
 	}
 	 return new ResponseEntity<>(trn, HttpStatus.OK);
}
@DeleteMapping("/train/{id}")
@Override
public ResponseEntity<Object> removeItemById(@PathVariable("id") long id) {
	Optional<TrainingSessions> trn = tr.getItemById(id);

 	if (!trn.isPresent()) {
 		throw new HibernateError("Sorry We Cannot Find  Trainind Session with Id "+id);
 	}
 	tr.removeItem(id);
 	 return new ResponseEntity<>("Successfully Removed Training Session with id "+id, HttpStatus.OK);
}

@DeleteMapping("/trains")
@Override
public ResponseEntity<Object> removeAllItems() {
	tr.removeAllItems();
	 return new ResponseEntity<>("Successfully Deleted All Training Sessions", HttpStatus.OK);
}

@PutMapping("/train/{id}")
@Override
public ResponseEntity<Object> updateItem(@Valid TrainingSessions it, long id, RedirectAttributes red) {
	Optional<TrainingSessions> trn = tr.getItemById(id);
 	if (!trn.isPresent()) {
 		throw new HibernateError("Sorry We Cannot Find Training Session with Id "+id);
 	}
 	tr.addItem(it);
 	 return new ResponseEntity<>("Training Session Updated Successfully !", HttpStatus.OK);
}
}
