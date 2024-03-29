package com.imuka.imuka.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.imuka.imuka.dao.FundingOpportunitiesDaoImpl;
import com.imuka.imuka.model.Events;
import com.imuka.imuka.model.FundingOpportunities;
/**
 * 
 * @author Tendo Martyn
 *Business Class For Funding Opportunities
 */
@Service
@Qualifier("fundingOpportunitiesServiceImpl")
public class FundingOpportunitiesServiceImpl implements ImukaService<FundingOpportunities> {
    @Autowired
	FundingOpportunitiesDaoImpl fn;

	@Override
	public Iterable<FundingOpportunities> getAllItems() {
		return fn.findAll();
	}

	@Override
	public void addItem(FundingOpportunities fm) {
		fn.save(fm);
	}

	@Override
	public Optional<FundingOpportunities> getItemById(long id) {
		// TODO Auto-generated method stub
		return fn.findById(id);
	}

	@Override
	public void removeItem(Long id) {
		fn.deleteById(id);
	}

	@Override
	public void removeAllItems() {
		fn.deleteAll();
	}

	@Override
	public boolean exists(Long primaryKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Page<FundingOpportunities> findPaginated(int page, int size) {
		return fn.findAll(new PageRequest(page, size));
	}

	@Override
	public Page<FundingOpportunities> findAllProductsPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
