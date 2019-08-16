package com.imuka.imuka.dao;

public interface BaseDao<Item>{
  Boolean IfExists(Item it);
}
