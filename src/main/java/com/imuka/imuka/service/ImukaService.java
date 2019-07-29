package com.imuka.imuka.service;

import java.util.Optional;

public interface ImukaService<Entity> {

	Iterable<Entity> getAllItems();
	
	 void addItem(Entity fm);
	
	 Optional<Entity> getItemById(long id);
	
	 void removeItem(Long id);
	
	// void removeItemByName(Entity bio);
	
	 void removeAllItems();
	 boolean exists(Long primaryKey);  
}
