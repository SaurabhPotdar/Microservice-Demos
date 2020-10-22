package com.cg.productservicecatalog.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.productservicecatalog.dto.Product;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("")
	public List<Product> getTop3(){
		//Get response from ProductService
		ResponseEntity<Product[]> response = restTemplate.getForEntity("http://localhost:8081/products/get",Product[].class);
		Product[] products = response.getBody();
		return Arrays.asList(products);
	}
	
}
