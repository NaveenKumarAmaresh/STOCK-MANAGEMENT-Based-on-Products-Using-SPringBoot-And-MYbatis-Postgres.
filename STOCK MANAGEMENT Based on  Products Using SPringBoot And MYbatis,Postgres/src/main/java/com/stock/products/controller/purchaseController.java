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

import com.stock.products.Service.PurchaseService;
import com.stock.products.model.Purchase;
@RestController
@RequestMapping("/purchase")
public class purchaseController {
	@Autowired
	private PurchaseService service;
	
	@GetMapping("/purchase/showAll")
	public ResponseEntity<List<Purchase>>findAll(){
		return new ResponseEntity<List<Purchase>>(service.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/byProductId")
	public List<Purchase>byId(@RequestParam("id") Integer id){
		return service.byId(id);
	}
	

	@GetMapping("/purchase/findById")
	public ResponseEntity<Purchase>findById(@RequestParam("purchaseId") Integer purchaseId){
		return new ResponseEntity<Purchase>(service.findById(purchaseId),HttpStatus.OK);
	}
	
	
	@PostMapping("/purchase/save")
	public void insert(@RequestBody Purchase purchase) {
		service.insert(purchase);
	}
	
	@PutMapping("/purchase/update")
	public void update(@RequestBody Purchase purchase) {
		service.update(purchase);
	}
	
	@DeleteMapping("/purchase/deleteById")
	public void deletrById(@RequestParam("purchaseId") Integer purchaseId) {
		service.deleteById(purchaseId);
	}

}
