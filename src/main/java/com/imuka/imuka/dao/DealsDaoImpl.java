package com.imuka.imuka.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imuka.imuka.model.Deals;
@Repository
public interface DealsDaoImpl extends CrudRepository<Deals, Long> {
}
