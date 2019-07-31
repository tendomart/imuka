package com.imuka.imuka.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imuka.imuka.model.AnonynmousGuest;
@Repository
public interface AnonynmousGuestDaoImpl extends CrudRepository<AnonynmousGuest,Long> {

}
