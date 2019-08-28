package com.imuka.imuka.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.imuka.imuka.dao.VisitOpportunitiesDaoImpl;
import com.imuka.imuka.model.FundingOpportunities;
import com.imuka.imuka.model.VisitOpportunities;

/**
 * 
 * @author Tendo Martyn
 *Business Class For Visit Opportunities
 */
@Service
@Qualifier("visitOpportunitiesServiceImpl")
public class VisitOpportunitiesServiceImpl implements ImukaService<VisitOpportunities> {
@Autowired
	VisitOpportunitiesDaoImpl vs;
	
	@Override
	public Iterable<VisitOpportunities> getAllItems() {
		return vs.findAll();
	}

	@Override
	public void addItem(VisitOpportunities fm) {
			vs.save(fm);
	}

	@Override
	public Optional<VisitOpportunities> getItemById(long id) {
		return vs.findById(id);
	}

	@Override
	public void removeItem(Long id) {
		vs.deleteById(id);
	}

	@Override
	public void removeAllItems() {
		vs.deleteAll();
	}

	@Override
	public boolean exists(Long primaryKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Page<VisitOpportunities> findPaginated(int page, int size) {
		return vs.findAll(new PageRequest(page, size));
	}

	@Override
	public Page<VisitOpportunities> findAllProductsPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
