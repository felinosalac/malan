package com.redswift.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redswift.store.entities.Address;
import com.redswift.store.entities.Customer;

import io.ebean.Ebean;
import io.ebean.EbeanServer;

@RestController
public class HelloController {
	
	@Autowired
	private EbeanServer server;

	@RequestMapping("/")
	public String index() {
		return "<h1><font color='red'>Red Swift © 2019 FFSII</font></h1>";
	}
	
	
	@RequestMapping("/callie")
	public String callie() {
		
//		Address a1 = new Address("5", "Wide Street", "New York");
//		Customer c1 = new Customer("John Wide", a1);
//		 
//		server.save(c1);
//		 
//		c1.setName("Jane Wide");
//		c1.setAddress(null);
//		server.save(c1);
//		 
//		Customer foundC1 = Ebean.find(Customer.class, c1.getId());
//		 
//		server.delete(foundC1);

		
		return "Callie";
	}

}
