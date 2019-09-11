package com.imuka.imuka.rest.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.HibernateError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.imuka.imuka.controller.ResourceNotFound;
import com.imuka.imuka.model.Events;
import com.imuka.imuka.model.VisitOpportunities;
import com.imuka.imuka.service.ImukaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("rs")
@Api(value="Events", description="Events Rest-API for CRUD Operations")
public class EventsRestController extends BaseRestController<Events>{

	@Autowired(required = true)
	@Qualifier(value = "eventsServiceImpl")
	private ImukaService<Events> ev;
 
	@ApiOperation(value = "View Paginated EVents", response = Page.class)
    @GetMapping(value = "/eventsp", params = { "page", "size" })
    public Page<Events> findPaginated(
      @RequestParam("page") int page, @RequestParam("size") int size) throws ResourceNotFound {
 
        Page<Events> resultPage = ev.findPaginated(page, size);
        if (page > resultPage.getTotalPages()) {
            throw new ResourceNotFound();
        }
 
        return resultPage;
    }
    
	@GetMapping("/events")
	@Override
	public ResponseEntity<Object> getAllItems() {
		 return new ResponseEntity<>(ev.getAllItems(), HttpStatus.OK);
		    
	}
	
@PostMapping("/event")
@Override
	public ResponseEntity<Object> addItem(@Valid Events evt, RedirectAttributes red) {
	       ev.addItem(evt);
	        return new ResponseEntity("Event saved successfully", HttpStatus.CREATED);
	}
	
@GetMapping("/event/{id}")
@Override
public ResponseEntity<Object> getItemById(long id) {
	Optional<Events> evt = ev.getItemById(id);

 	if (!evt.isPresent()) {
 		//throw new HibernateError("Sorry We Cannot Find Visit with id "+id);
 		return new ResponseEntity<>("Sorry We Cannot Find The Event with id  "+id, HttpStatus.NOT_FOUND);

 	}
 	 return new ResponseEntity<>(evt, HttpStatus.OK);
}
@DeleteMapping("/event/{id}")
@Override
public ResponseEntity<Object> removeItemById(@PathVariable("id") long id) {
	Optional<Events> evt = ev.getItemById(id);

 	if (!evt.isPresent()) {
 		throw new HibernateError("Sorry We Cannot Find Event with Id "+id);
 	}
 	ev.removeItem(id);
 	 return new ResponseEntity<>("Successfully Removed  Event with id "+id, HttpStatus.GONE);
}

@DeleteMapping("/events")
@Override
public ResponseEntity<Object> removeAllItems() {
	ev.removeAllItems();
	 return new ResponseEntity<>("Successfully Deleted All Events", HttpStatus.GONE);
}

@PutMapping("/event/{id}")
@Override
public ResponseEntity<Object> updateItem(@Valid Events it, long id, RedirectAttributes red) {
	Optional<Events> vst = ev.getItemById(id);
 	if (!vst.isPresent()) {
 		//throw new HibernateError("Sorry We Cannot Find Workshop with Id "+id);
 		return new ResponseEntity<>("Sorry We Cannot Find Events with Id !", HttpStatus.NOT_FOUND);

 	}
 	ev.addItem(it);
 	 return new ResponseEntity<>("Visit Events Updated Successfully !", HttpStatus.ACCEPTED);
}
	
}
