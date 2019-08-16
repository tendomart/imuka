package com.imuka.imuka.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.imuka.imuka.model.Workshops;
@Repository
public interface WorkshopsDaoImpl 
extends PagingAndSortingRepository<Workshops, Long>, CrudRepository<Workshops,Long> {
	Page<Workshops> findAll(Pageable pageable);
	@Override
	default boolean existsById(Long id) {
		//new Session.
		return false;
	}
}
