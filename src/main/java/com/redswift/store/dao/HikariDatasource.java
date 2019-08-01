package com.redswift.store.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@Component
public class HikariDatasource {

//	@Value("${spring.datasource.hikari.username}")
//	private String user;
//	
//	@Value("${spring.datasource.hikari.password}")
//	private String password;
//	
//	@Value("${spring.datasource.hikari.jdbc-url}")
//	private String dataSourceUrl;
//	
//	@Value("${spring.datasource.hikari.pool-name}")
//	private String poolName;
//	
//	@Value("${spring.datasource.hikari.connection-timeout}")
//	private int connectionTimeout;
//	
//	@Value("${spring.datasource.hikari.max-lifetime}")
//	private int maxLifetime;
//	
//	@Value("${spring.datasource.hikari.maximum-pool-size}")
//	private int maximumPoolSize;
//	
//	@Value("${spring.datasource.hikari.minimum-idle}")
//	private int minimumIdle;
//	
//	@Value("${spring.datasource.hikari.idle-timeout}")
//	private int idleTimeout;
//	
//	
//	@Value("${spring.datasource.hikari.driver-class-name}")
//	private String driverClassname;
	
	
	public DataSource primaryDataSource() {
	
	    HikariConfig config = new HikariConfig();
	    config.setPoolName("SpringBootHikariCP");
	    config.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/malan");
	    config.setUsername("root");
	    config.setPassword("root");
	    config.setConnectionTimeout(3000);
	    config.setMinimumIdle(3);
	    config.setIdleTimeout(30000);
	    config.setMaximumPoolSize(60);
	    config.setMaxLifetime(2000000);
	    config.addDataSourceProperty("cachePrepStmts", "true");
	    config.addDataSourceProperty("prepStmtCacheSize", "250");
	    config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
	    config.setDriverClassName("com.mysql.jdbc.Driver");
	
	    HikariDataSource ds = new HikariDataSource(config);
	    return ds;
	}
}
