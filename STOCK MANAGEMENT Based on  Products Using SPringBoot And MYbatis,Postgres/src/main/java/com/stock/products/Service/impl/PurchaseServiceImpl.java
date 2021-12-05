package com.stock.products.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.products.Service.PurchaseService;
import com.stock.products.dao.PurchaseDao;
import com.stock.products.model.Purchase;
@Service
public class PurchaseServiceImpl implements PurchaseService {
	
	@Autowired
	private PurchaseDao dao;

	@Override
	public List<Purchase> findAll() {
		return dao.findAll();
	}

	@Override
	public Purchase findById(Integer purchaseId) {
		return dao.findById(purchaseId);
	}

	@Override
	public void insert(Purchase purchase) {
		dao.insert(purchase);

	}

	@Override
	public void update(Purchase purchase) {
		dao.update(purchase);

	}

	@Override
	public void deleteById(Integer purchaseId) {
		dao.deleteById(purchaseId);

	}

	@Override
	public List<Purchase> byId(Integer id) {
		return dao.byId(id);
	}

}
