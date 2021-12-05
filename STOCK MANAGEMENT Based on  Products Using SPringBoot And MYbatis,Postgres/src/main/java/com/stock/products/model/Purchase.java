package com.stock.products.model;

import java.math.BigInteger;
import java.util.Date;

 
import lombok.Data;

@Data

public class Purchase {

	private int purchaseId;
	private int id;
	private BigInteger contactNo;
	private String purchasedBy;
	private int quantity;
	private Date createdAt;
	private Date updatedAt;
	private Boolean isDeleted;
	private Product product;
	

}
