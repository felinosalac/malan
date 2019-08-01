package com.redswift.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.redswift.store.models.Product;
import com.redswift.store.services.ProductService;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("private/products")
public class ProductController {
	
 	@Autowired
	private ProductService productService;

	@RequestMapping(value="", method = RequestMethod.GET)
	public List<Product> getProducts() {
		return productService.getAllProducts();
	}
	
	@RequestMapping(value="/{code}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable String code) {
		return productService.getProduct(code);
	}
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}
	
	@RequestMapping(value="/{code}", method = RequestMethod.PUT)
	public void updateProduct(@RequestBody Product product, @PathVariable String code) {
		productService.updateProduct(code, product);
	}
	
	@RequestMapping(value="/{code}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable String code) {
		productService.deleteProduct(code);
	}

}
