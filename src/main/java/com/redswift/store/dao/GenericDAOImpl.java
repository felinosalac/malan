package com.redswift.store.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.redswift.store.entities.BaseEntity;

import io.ebean.EbeanServer;
import io.ebean.annotation.Transactional;

/*
 * The generic implementation is itself parameterized – allowing the client to choose the correct parameter in a case by case basis. 
 * This will mean that the clients get all the benefits of type safety without needing to create multiple artifacts for each entity.
 */

public class GenericDAOImpl<T extends BaseEntity> {

	@Autowired
	private EbeanServer server;

	public Class<T> clazz;

	@SuppressWarnings("unchecked")
	@Autowired
	public GenericDAOImpl() {
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Transactional
	public T find(long id) {
		T t = getServer().find(clazz, id);
		return t;
	}

	public EbeanServer getServer() {
		return server;
	}

	public void setServer(EbeanServer server) {
		this.server = server;
	}

}
