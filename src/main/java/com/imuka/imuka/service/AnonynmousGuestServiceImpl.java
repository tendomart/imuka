package com.imuka.imuka.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imuka.imuka.dao.AnonynmousGuestDaoImpl;
import com.imuka.imuka.model.AnonynmousGuest;
/*
 * Annonymous Object Business Class
 */

@Service
@Transactional
@Qualifier("anonynmousGuestServiceImpl")
public class AnonynmousGuestServiceImpl implements ImukaService<AnonynmousGuest>{

@Autowired
public AnonynmousGuestDaoImpl gs;
	@Override
	public Iterable<AnonynmousGuest> getAllItems() {
		// TODO Auto-generated method stub
		return gs.findAll();
	}

	@Override
	public void addItem(AnonynmousGuest fm) {
			gs.save(fm);
	}

	@Override
	public Optional<AnonynmousGuest> getItemById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeItem(Long id) {
		gs.deleteById(id);
	}

	@Override
	public void removeAllItems() {
		gs.deleteAll();
	}

	@Override
	public boolean exists(Long primaryKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<AnonynmousGuest> findPaginated(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<AnonynmousGuest> findAllProductsPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


}
