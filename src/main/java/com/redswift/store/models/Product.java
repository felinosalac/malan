package com.redswift.store.models;

public class Product {

	private long id;
	private String code;
	private String name;
	private String description;

	public Product() {
		super();
	}

	public Product(long id, String code, String name, String description) {
		super();
		this.id = id;
		this.code= code;
		this.name = name;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
