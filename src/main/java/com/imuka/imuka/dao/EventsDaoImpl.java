package com.imuka.imuka.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imuka.imuka.model.Events;
@Repository
public interface EventsDaoImpl extends CrudRepository<Events,Long> {

}
