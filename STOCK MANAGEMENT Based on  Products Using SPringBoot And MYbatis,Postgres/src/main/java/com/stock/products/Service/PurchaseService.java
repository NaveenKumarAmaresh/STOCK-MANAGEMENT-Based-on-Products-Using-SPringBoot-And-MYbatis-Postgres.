package com.stock.products.Service;

import java.util.List;

import com.stock.products.model.Purchase;

public interface PurchaseService {
	
	public List<Purchase>findAll();
	public List<Purchase>byId(Integer id);
	public Purchase findById(Integer purchaseId);
	public void insert(Purchase purchase);
	public void update(Purchase purchase);
	public void deleteById(Integer purchaseId);

}
