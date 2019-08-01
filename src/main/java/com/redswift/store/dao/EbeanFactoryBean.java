package com.redswift.store.dao;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;

/**
 * Spring factory for creating the EbeanServer singleton.
 */
@Component
public class EbeanFactoryBean implements FactoryBean<EbeanServer> {

	@Autowired
	HikariDatasource dataSource;
	

	@Override
	public EbeanServer getObject() throws Exception {

		ServerConfig config = new ServerConfig();
		config.setName("db");
		config.setDefaultServer(true);
		config.setDataSource(dataSource.primaryDataSource());
		
		return EbeanServerFactory.create(config);
	}

	@Override
	public Class<?> getObjectType() {
		return EbeanServer.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
