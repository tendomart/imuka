package com.imuka.imuka.rest.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.hibernate.HibernateError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.imuka.imuka.dao.AnonynmousGuestDaoImpl;
import com.imuka.imuka.model.AnonynmousGuest;
import com.imuka.imuka.service.ImukaService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/rs")
@Api(value="Guest", description="Anonynmous Guest API")
public class AnonynmousGuestRestController {
	@Autowired(required = true)
	@Qualifier(value = "anonynmousGuestServiceImpl")
	private ImukaService<AnonynmousGuest> an;
	
	@Autowired
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
	
	 @PostMapping(value = "/guest1", produces = {MediaType.APPLICATION_JSON_VALUE})
	    @ResponseBody
	    public GuestResponse saveGuest(@ModelAttribute @Valid AnonynmousGuest gst,
	                                        BindingResult result) {
	 
	        GuestResponse response = new GuestResponse();
	 
	        if (result.hasErrors()) {
	 
	            Map<String, String> errors = result.getFieldErrors().stream()
	                    .collect(
	                            Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
	                    );
	 
	            response.setValidated(false);
	            response.setErrorMessages(errors);
	        } else {
	 
	            response.setValidated(true);
	        }
	        return response;
	    }
	 
	 @GetMapping("/guest/{id}")
	 public AnonynmousGuest retrieveAnonynmousGuest(@PathVariable long id) {
	 	Optional<AnonynmousGuest> anony = any.findById(id);

	 	if (!anony.isPresent())
//	 		throw new StudentNotFoundException("id-" + id);
	 		throw new HibernateError("Sorry We Cannot Find "+id);
	 	return anony.get();
	 }
	 
//	 @RequestMapping(value = "/guest", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	 public @ResponseBody List<AnonynmousGuest> loadCityByCountry(@RequestBody AnonynmousGuest anon) {
//	  List<AnonynmousGuest> an = any.findById(id)
//	  
//	  return an;
//	 }
	 
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
