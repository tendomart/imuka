package com.imuka.imuka.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.imuka.imuka.model.Events;
@Repository
public interface EventsDaoImpl 
extends PagingAndSortingRepository<Events, Long>,CrudRepository<Events,Long> ,BaseDao<Events>{
	Page<Events> findAll(Pageable pageable);
@Override
default boolean existsById(Long id) {
	//new Session.
	return false;
}

@Override
	default Boolean IfExists(Events it) {
		// TODO Auto-generated method stub
		return null;
	}
}
