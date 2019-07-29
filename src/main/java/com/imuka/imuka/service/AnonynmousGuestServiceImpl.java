package com.imuka.imuka.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.imuka.imuka.dao.AnonynmousGuestDaoImpl;
import com.imuka.imuka.model.AnonynmousGuest;
/*
 * Annonymous Object Business Class
 */

@Service
@Qualifier("anonynmousGuestServiceImpl")
public class AnonynmousGuestServiceImpl implements ImukaService<AnonynmousGuest>{

AnonynmousGuestDaoImpl gs;
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


}
