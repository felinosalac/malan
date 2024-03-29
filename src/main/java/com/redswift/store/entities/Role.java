package com.redswift.store.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Role extends BaseEntity{

    public Role(String role) {
		this.name=role;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    private Long id;
	private String name;
    
}
