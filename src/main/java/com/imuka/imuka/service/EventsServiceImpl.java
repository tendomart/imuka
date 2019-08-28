package com.imuka.imuka.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.imuka.imuka.dao.EventsDaoImpl;
import com.imuka.imuka.model.Events;
/**
 * 
 * @author Tendo Martyn
 *Business Class For Events
 */
@Service
@Qualifier("eventsServiceImpl")
public class EventsServiceImpl implements ImukaService<Events> {
	@Autowired
	EventsDaoImpl ev;

	@Override
	public Iterable<Events> getAllItems() {
		return ev.findAll();
	}

	@Override
	public void addItem(Events fm) {
	ev.save(fm);
	}

	@Override
	public Optional<Events> getItemById(long id) {
		return ev.findById(id);
	}


	@Override
	public void removeItem(Long id) {
		ev.deleteById(id);
	}

	@Override
	public void removeAllItems() {
		ev.deleteAll();
	}

	@Override
	public boolean exists(Long primaryKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Page<Events> findPaginated(int page, int size) {
		return ev.findAll(new PageRequest(page, size));
	}

	@Override
	public Page<Events> findAllProductsPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
