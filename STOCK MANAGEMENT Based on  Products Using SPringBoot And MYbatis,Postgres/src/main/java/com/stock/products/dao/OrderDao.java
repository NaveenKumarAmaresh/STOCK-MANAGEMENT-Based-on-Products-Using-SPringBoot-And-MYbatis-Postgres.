package com.stock.products.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stock.products.mapper.OrderMapper;
import com.stock.products.model.OrderDetails;
@Component
public class OrderDao {

	@Autowired
	public OrderMapper ordermapper;

	public List<OrderDetails>findAll(){
		return ordermapper.findAll();
	}
	public List<OrderDetails>byProductId(Integer id){
		return ordermapper.byProductId(id);
	}
	
	public OrderDetails findById(Integer orderId) {
		return ordermapper.findById(orderId);
	}
	
	public void insert(OrderDetails orders) {
		ordermapper.insert(orders);
	}
	
	public void update(OrderDetails orders) {
		ordermapper.update(orders);
	}
	
	public void delete(Integer orderId) {
		 ordermapper.deleteById(orderId);
	}
	
	
}
