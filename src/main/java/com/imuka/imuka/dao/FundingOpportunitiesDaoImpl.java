package com.imuka.imuka.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.imuka.imuka.model.FundingOpportunities;
@Repository
public interface FundingOpportunitiesDaoImpl 
extends PagingAndSortingRepository<FundingOpportunities, Long>,CrudRepository<FundingOpportunities,Long>,BaseDao<FundingOpportunities> {

	Page<FundingOpportunities> findAll(Pageable pageable);
@Override
	default Boolean IfExists(FundingOpportunities it) {
		// TODO Auto-generated method stub
		return null;
	}
}
