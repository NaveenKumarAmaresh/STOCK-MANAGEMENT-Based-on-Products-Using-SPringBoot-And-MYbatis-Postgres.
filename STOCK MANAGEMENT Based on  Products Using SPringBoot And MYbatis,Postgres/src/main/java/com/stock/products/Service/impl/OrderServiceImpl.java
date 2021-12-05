package com.stock.products.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.products.Service.OrderService;
import com.stock.products.dao.OrderDao;
import com.stock.products.model.OrderDetails;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao dao;

	@Override
	public List<OrderDetails> findAll() {
		return dao.findAll();
	}

	@Override
	public OrderDetails findByid(Integer Orderid) {
		return dao.findById(Orderid);
	}

	@Override
	public void insert(OrderDetails orders) {
		dao.insert(orders);
	}

	@Override
	public void update(OrderDetails orders) {
		dao.update(orders);
	}

	@Override
	public void delete(Integer orderId) {
		dao.delete(orderId);
	}

	@Override
	public List<OrderDetails> byProductId(Integer id) {
				return dao.byProductId(id);
	}

	
	
	
	
}
