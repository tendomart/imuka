package com.imuka.imuka.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imuka.imuka.model.Workshops;
@Repository
public interface WorkshopsDaoImpl extends CrudRepository<Workshops,Long> {

}
