package com.redswift.store.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.redswift.store.models.Product;

@Service
public class ProductService {

	private List<Product> products = new ArrayList<>(Arrays.asList(

			new Product(1, "RS000001", "Beatles Tshirt", "Customized Beatles Tshirt made by Felino Salac II."),
			new Product(2, "RS000002", "Red Swift Bag", "Bag designed by Red Swift."),
			new Product(3, "RS000003", "Milk Tea", "The best milk tea in town brewed by Red Swift.")

	));

	public List<Product> getAllProducts() {
		return products;
	}

	public Product getProduct(String code) {
		return products.stream().filter(p -> p.getCode().equals(code)).findFirst().get();
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}

	public void updateProduct(String code, Product product) {
		for (Product p : products) {
			if(code.equalsIgnoreCase(p.getCode())) {
				products.set(products.indexOf(p), product);
			}
		}
		
		
	}

	public void deleteProduct(String code) {
		products.removeIf(t -> t.getCode().equals(code));
	}

}
