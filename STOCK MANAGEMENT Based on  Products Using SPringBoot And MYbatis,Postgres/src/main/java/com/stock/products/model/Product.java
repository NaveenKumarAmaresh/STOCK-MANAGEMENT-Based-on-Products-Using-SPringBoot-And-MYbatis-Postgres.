package com.stock.products.model;

import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.stock.products.exception.NoSpace;

import lombok.Data;

@Data
 
public class Product {

  	private int id;
  	@NoSpace(message=" White space is not accepted ")
 	@Size(min=2,message="Name is mandatory it should have minimum 2 characters")  
  	private String name;
    
  	@DecimalMin("1.00")
	private int price;
  	
  	@NotEmpty
  	@Size(min=5,message="Please enter proper details")
	private String specs;
  
	
	private int availQty;
	
 	private Date createdAt;
	 
	private Date updatedAt;
	 
	private Boolean isdeleted;
 
	
	}