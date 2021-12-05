package com.stock.products.Service;

import java.util.List;

import com.stock.products.model.OrderDetails;

public interface OrderService {
	
	public List<OrderDetails>findAll();
	public List<OrderDetails>byProductId(Integer id);
	public OrderDetails findByid(Integer Orderid);
	public void insert(OrderDetails orders);
	public void update(OrderDetails orders);
	public void delete (Integer orderId);
	
}
