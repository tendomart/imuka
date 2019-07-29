package com.imuka.imuka.dao;

import org.springframework.data.repository.CrudRepository;

import com.imuka.imuka.model.Events;

public interface EventsDaoImpl extends CrudRepository<Events,Long> {

}
