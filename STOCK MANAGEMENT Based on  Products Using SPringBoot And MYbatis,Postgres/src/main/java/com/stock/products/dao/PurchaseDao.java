package com.stock.products.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stock.products.mapper.PurchaseMapper;
import com.stock.products.model.Purchase;
@Component
public class PurchaseDao {
	
	@Autowired
	private PurchaseMapper mapper;
	
	public List<Purchase>findAll() {
		return mapper.findAll();
	}
	
	public List<Purchase>byId(Integer id){
		return mapper.byId(id);	
	}
	
	public Purchase findById(Integer purchaseId) {
		return mapper.findById(purchaseId);	
	}
	
	public void insert(Purchase purchase) {
		mapper.insert(purchase);
	}
	
	public void update(Purchase purchase) {
		mapper.update(purchase);
	}
	
	public void deleteById(Integer purchaseId)
	{
		 mapper.deleteById(purchaseId);
	}
	
}
