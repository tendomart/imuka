package com.imuka.imuka.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.imuka.imuka.model.VisitOpportunities;
@Repository
public interface VisitOpportunitiesDaoImpl
extends PagingAndSortingRepository<VisitOpportunities, Long>,CrudRepository<VisitOpportunities,Long> {
	Page<VisitOpportunities> findAll(Pageable pageable);
	@Override
	default boolean existsById(Long id) {
		//new Session.
		return false;
	}
}
