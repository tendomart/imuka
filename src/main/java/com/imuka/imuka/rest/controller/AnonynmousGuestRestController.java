package com.imuka.imuka.rest.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.imuka.imuka.dao.AnonynmousGuestDaoImpl;
import com.imuka.imuka.model.AnonynmousGuest;
import com.imuka.imuka.service.ImukaService;

@RestController
public class AnonynmousGuestRestController {
	@Autowired(required = true)
	@Qualifier(value = "anonynmousGuestServiceImpl")
	private ImukaService<AnonynmousGuest> an;
	
	private AnonynmousGuestDaoImpl any;
	//Get Guest By ID
//	 @GetMapping("/guest/{id}")
//	    public AnonynmousGuest getEmployeeById(@PathVariable Long id) throws Exception {
//	        System.out.println(this.getClass().getSimpleName() + " - Get employee details by id is invoked.");
//	 
//	        Optional<AnonynmousGuest> st =  an.getItemById(id);
//	        if(!st.isPresent())
//	            throw new Exception("Could not find Guest with id- " + id);
//	 
//	        return st.get();
//	    }
	 //Get All Guests
	 @GetMapping("/guests")
	 public List<AnonynmousGuest> retrieveAllGuests() {
	 	return (List<AnonynmousGuest>) any.findAll();
	 }
	 
	 @PostMapping("/guest")
	 public ResponseEntity<Object> createGeust(@RequestBody AnonynmousGuest gs) {
		 AnonynmousGuest savedAnonynmousGuest=  any.save(gs);

	 	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
	 			.buildAndExpand(savedAnonynmousGuest.getId()).toUri();

	 	return ResponseEntity.created(location).build();

	 }
	 
	 @GetMapping("/guest/{id}")
	 public AnonynmousGuest retrieveAnonynmousGuest(@PathVariable long id) {
	 	Optional<AnonynmousGuest> anony = any.findById(id);

	 	if (!anony.isPresent())
//	 		throw new StudentNotFoundException("id-" + id);
	 		throw new HibernateError("Sorry We Cannot Find "+id);
	 	return anony.get();
	 }
	 
	 @DeleteMapping("/guest/{id}")
	 public void deleteAnonynmousGuest(@PathVariable long id) {
	 	any.deleteById(id);
	 }
	 
	 @PutMapping("/students/{id}")
	 public ResponseEntity<Object> updateAnonynmousGuest(@RequestBody AnonynmousGuest anon, @PathVariable long id) {

	 	Optional<AnonynmousGuest> studentOptional = any.findById(id);

	 	if (!studentOptional.isPresent())
	 		return ResponseEntity.notFound().build();
	 	anon.setId(id);
	 	any.save(anon);
	 	return ResponseEntity.noContent().build();
	 }
}