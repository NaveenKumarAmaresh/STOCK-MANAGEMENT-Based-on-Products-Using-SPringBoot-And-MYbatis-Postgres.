package com.stock.products.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stock.products.mapper.ProductMapper;
import com.stock.products.model.Product;

@Component
public class ProductDao {

	@Autowired
	private ProductMapper productmapper;
	
	public List<Product>findAll(){
		return productmapper.findAll();
	}
	
	public Product findById(Integer id) {
		return productmapper.findById(id);
	}
	
	public void insert (Product product) {
	    	 productmapper.insert(product);
	
	}
	
	public void update(Product product) {
		  productmapper.update(product);
	}
	
	
	public void delete(Integer id) {
		  productmapper.deleteById(id);
		
	}
	
}
