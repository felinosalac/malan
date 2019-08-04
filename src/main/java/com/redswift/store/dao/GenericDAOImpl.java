package com.redswift.store.dao;

import java.lang.reflect.ParameterizedType;

import org.springframework.beans.factory.annotation.Autowired;

import com.redswift.store.entities.BaseEntity;

/*
 * The generic implementation is itself parameterized – allowing the client to choose the correct parameter in a case by case basis. 
 * This will mean that the clients get all the benefits of type safety without needing to create multiple artifacts for each entity.
 */

public class GenericDAOImpl<T extends BaseEntity>  implements GenericDao<T>{

	public Class<T> clazz;

	@SuppressWarnings("unchecked")
	@Autowired
	public GenericDAOImpl() {
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void save(T t) {
		//save(t);
		
	}

}
