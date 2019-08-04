package com.redswift.store.dao;

import com.redswift.store.entities.BaseEntity;

/*
 * This is the generic interface that needs to be implemented
 * 
 */
public interface GenericDao<T extends BaseEntity> {

	void save(T t);

}
