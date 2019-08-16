package com.imuka.imuka.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imuka.imuka.model.AnonynmousGuest;
@Repository
public interface AnonynmousGuestDaoImpl 
extends CrudRepository<AnonynmousGuest,Long>,BaseDao<AnonynmousGuest> {
@Override
default boolean existsById(Long id) {
	return false;
}

@Override
	default Boolean IfExists(AnonynmousGuest it) {
		// TODO Auto-generated method stub
		return null;
	}
}
