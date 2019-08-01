package com.redswift.store.dao;

import com.redswift.store.entities.BaseEntity;

import io.ebean.EbeanServer;

/*
 * This is the generic interface that needs to be implemented
 * 
 */
public interface GenericDao<T extends BaseEntity> {

	EbeanServer getServer();

}
