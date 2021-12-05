package com.stock.products.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.products.Service.ProductService;
import com.stock.products.dao.ProductDao;
import com.stock.products.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productdao;
	
	
	@Override
	public List<Product> findAll() {
		return productdao.findAll();
	}

	@Override
	public Product findById(Integer id) {
		return productdao.findById(id);
	}

	@Override
	public void insert(Product product) {		 
			   productdao.insert(product);	 
	}

	@Override
	public void update(Product product) {
		   productdao.update(product);

	}

	@Override
	public void deleteById(Integer id) {
		  productdao.delete(id);
	}

}
