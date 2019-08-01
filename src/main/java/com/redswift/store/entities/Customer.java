package com.redswift.store.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Customer extends BaseEntity {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Customer(String name, Address address) {
        super();
        this.name = name;
        this.address = address;
    }
 
    private String name;
 
    @OneToOne(cascade = CascadeType.ALL)
    Address address;
 
    // getters and setters
}