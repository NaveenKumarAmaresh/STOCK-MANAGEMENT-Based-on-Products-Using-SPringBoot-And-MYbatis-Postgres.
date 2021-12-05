package com.stock.products.Service;

import java.util.List;

import com.stock.products.model.Product;

public interface ProductService {

	public List<Product> findAll();
	public Product findById(Integer id);
	public void insert(Product product);
	public void update(Product product);
	public void deleteById(Integer id);
	
}
