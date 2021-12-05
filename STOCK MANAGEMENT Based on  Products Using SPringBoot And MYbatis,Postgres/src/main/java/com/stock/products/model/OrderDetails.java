package com.stock.products.model;

import java.math.BigInteger;
import java.util.Date;
 

import lombok.Data;

@Data

public class OrderDetails {
	
  	private int orderId;
	private int id;
	private String orderedBy;
	private String address;
	private BigInteger contactNo;
 	private Date createdAt;
 	private Date updatedAt;
	private Boolean isDeleted;
	private Product product;
	
	
	
	
	
	

}
