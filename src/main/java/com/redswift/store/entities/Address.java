package com.redswift.store.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Address extends BaseEntity {

	public Address(String addressLine1, String addressLine2, String city) {
		this.addressLine1=addressLine1;
		this.addressLine2=addressLine2;
		this.city=city;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private Long id;
	private String addressLine1;
	private String addressLine2;
	private String city;

	// getters and setters
}