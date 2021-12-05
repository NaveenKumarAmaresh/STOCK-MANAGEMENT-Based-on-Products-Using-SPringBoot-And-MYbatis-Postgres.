package com.stock.products.controller;

import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stock.products.Service.OrderService;
import com.stock.products.model.OrderDetails;


@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService service;

	@GetMapping("/Order/ShowAll")
	public ResponseEntity<List<OrderDetails>>findAll(){
		return new ResponseEntity<List<OrderDetails>>(service.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/Order/byProductId")
	public ResponseEntity<List<OrderDetails>>byProductId(Integer id){
		return new ResponseEntity<List<OrderDetails>>(service.byProductId(id),HttpStatus.OK);
	}
	
	@GetMapping("/order/byId")
	public  ResponseEntity<OrderDetails>findById
	(@RequestParam(required=false)    Integer orderId) {
		return new ResponseEntity<OrderDetails>(service.findByid(orderId),HttpStatus.OK);	
	}
	
	@PostMapping("/orders/save")
	public void  insert(@RequestBody OrderDetails orders) {
		service.insert(orders);
	}
	
	@PutMapping("/order/update")
	public void update(@RequestBody OrderDetails orders) {
		service.update(orders);
	}
	
	@DeleteMapping("/orders/deleteById")
	public void deleteById(@RequestParam("orderId") Integer orderId) {
		service.delete(orderId);
	}
	
}
