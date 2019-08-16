package com.imuka.imuka.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imuka.imuka.controller.ResourceNotFound;
import com.imuka.imuka.model.Events;
import com.imuka.imuka.service.ImukaService;

@RestController
public class EventsRestController {

	@Autowired(required = true)
	@Qualifier(value = "eventsServiceImpl")
	private ImukaService<Events> evt;
 
    //@RequestMapping(value = "/rs/events", params = { "page", "size" }, 
      //method = RequestMethod.GET)
    @GetMapping(value = "/rs/events", params = { "page", "size" })
    public Page<Events> findPaginated(
      @RequestParam("page") int page, @RequestParam("size") int size) throws ResourceNotFound {
 
        Page<Events> resultPage = evt.findPaginated(page, size);
        if (page > resultPage.getTotalPages()) {
            throw new ResourceNotFound();
        }
 
        return resultPage;
    }
}
