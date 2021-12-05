package com.stock.products.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.stock.products.Service.ProductService;
 
import com.stock.products.model.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService service;

	@GetMapping("/product/showAll")
	public ResponseEntity<List<Product>>findAll()
	{
		return new ResponseEntity<List<Product>>(service.findAll(),HttpStatus.OK);
	}
	
	
	@GetMapping("/product/findById")
	public ResponseEntity<Product>findById(@RequestParam("id") Integer id)
	{
		if ( service.findById(id)==null)                                  // the value is empty or null or invalid it will throw exception
			throw new NoSuchElementException();
		return new ResponseEntity<Product>(service.findById(id),HttpStatus.OK);				
	}
	
	@PostMapping("/product/save")
	@ResponseStatus(HttpStatus.CREATED)
	 public void insert( @RequestBody @Valid   Product product)
	{	 	 
			  service.insert(product);
	}
	
 	
	@PutMapping("/product/update")
  public void update(@RequestBody Product product)
	{		 
		service.update(product);
	}
	  
	@DeleteMapping("/product/delete")
	@ResponseStatus(HttpStatus.OK)
	public void deleteByid(@RequestParam("id")Integer id)
	{
	  service.deleteById(id);
	}
	 	
	
}
