package com.redswift.store;

import java.util.Arrays;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.redswift.store.entities.Role;
import com.redswift.store.entities.User;
import com.redswift.store.security.WebSecurityConfig;
import com.redswift.store.services.UserService;
import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
@EnableJpaAuditing
public class StoreApplication implements CommandLineRunner  {
	
	@Autowired
    DataSource dataSource;
	
	Logger logger = LoggerFactory.getLogger(StoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

//	@Bean
//    public CommandLineRunner setupDefaultUser(UserService service) {
//        return args -> {
//            service.save(new User(
//                    "admin", //username
//                    "admin", //password
//                    Arrays.asList(new Role("USER"), new Role("ACTUATOR")),//roles 
//                    true//Active
//            ));
//        };
//    }
//	
	@Override
    public void run(String... args) throws Exception {
		logger.info("DATASOURCE = " + dataSource);
        if(dataSource.getClass() == HikariDataSource.class) {
        	HikariDataSource hikariDataSource = (HikariDataSource)dataSource;
        	logger.info("Jdbc Url: " + hikariDataSource.getJdbcUrl());
        }
    }
}
