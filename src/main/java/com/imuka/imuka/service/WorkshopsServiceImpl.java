package com.imuka.imuka.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.imuka.imuka.dao.WorkshopsDaoImpl;
import com.imuka.imuka.model.VisitOpportunities;
import com.imuka.imuka.model.Workshops;

/**
 * 
 * @author Tendo Martyn
 *Business Class For Workshops
 */
@Service
@Qualifier("workshopsServiceImpl")
public class WorkshopsServiceImpl implements ImukaService<Workshops> {
  @Autowired
	WorkshopsDaoImpl wk;

	@Override
	public Iterable<Workshops> getAllItems() {
		return wk.findAll();
	}

	@Override
	public void addItem(Workshops fm) {
		wk.save(fm);
	}

	@Override
	public Optional<Workshops> getItemById(long id) {
		return wk.findById(id);
	}

	@Override
	public void removeItem(Long id) {
		wk.deleteById(id);
	}

	@Override
	public void removeAllItems() {
		wk.deleteAll();
	}

	@Override
	public boolean exists(Long primaryKey) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Page<Workshops> findPaginated(int page, int size) {
		return wk.findAll(new PageRequest(page, size));
	}
	
}
