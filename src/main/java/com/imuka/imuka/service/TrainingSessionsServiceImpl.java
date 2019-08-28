package com.imuka.imuka.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.imuka.imuka.dao.TrainingSessionsDaoImpl;
import com.imuka.imuka.model.FundingOpportunities;
import com.imuka.imuka.model.TrainingSessions;
/**
 * 
 * @author Tendo Martyn
 *Business Class For Training Sessions
 */
@Service
@Qualifier("trainingSessionsServiceImpl")
public class TrainingSessionsServiceImpl implements ImukaService<TrainingSessions> {
    @Autowired
	TrainingSessionsDaoImpl ts;
	@Override
	public Iterable<TrainingSessions> getAllItems() {
		return ts.findAll();
	}

	@Override
	public void addItem(TrainingSessions fm) {
		ts.save(fm);
	}

	@Override
	public Optional<TrainingSessions> getItemById(long id) {
		// TODO Auto-generated method stub
		return ts.findById(id);
	}

	@Override
	public void removeItem(Long id) {
			ts.deleteById(id);
	}

	@Override
	public void removeAllItems() {
	ts.deleteAll();
	}

	@Override
	public boolean exists(Long primaryKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Page<TrainingSessions> findPaginated(int page, int size) {
		return ts.findAll(new PageRequest(page, size));
	}

	@Override
	public Page<TrainingSessions> findAllProductsPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
