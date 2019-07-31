package com.imuka.imuka.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imuka.imuka.model.VisitOpportunities;
@Repository
public interface VisitOpportunitiesDaoImpl extends CrudRepository<VisitOpportunities,Long> {

}
