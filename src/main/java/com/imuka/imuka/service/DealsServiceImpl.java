package com.imuka.imuka.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.imuka.imuka.dao.DealsDaoImpl;
import com.imuka.imuka.model.Deals;
/*
 * Business Class for Deals
 */
@Service
@Qualifier("dealsServiceImpl")
public class DealsServiceImpl implements ImukaService<Deals>{
    @Autowired
	DealsDaoImpl dl;
	@Override
	public Iterable<Deals> getAllItems() {
		return dl.findAll();
	}

	@Override
	public void addItem(Deals fm) {
		dl.save(fm);
	}

	@Override
	public Optional<Deals> getItemById(long id) {
		return dl.findById(id);
	}

	@Override
	public void removeItem(Long id) {
		dl.deleteById(id);
	}

	@Override
	public void removeAllItems() {
		dl.deleteAll();
	}

	@Override
	public boolean exists(Long primaryKey) {
		return false;
	}

	@Override
	public Page<Deals> findPaginated(int page, int size) {
		return null;
	}

	@Override
	public Page<Deals> findAllProductsPageable(Pageable pageable) {
		return null;
	}

}
