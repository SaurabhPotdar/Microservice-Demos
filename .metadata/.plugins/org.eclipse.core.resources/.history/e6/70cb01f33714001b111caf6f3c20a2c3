package com.cg.productservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.productservice.dto.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	List<Product> topThree = new ArrayList<>(
		Arrays.asList(new Product[] {
			new Product("TV", "Samsung"),
			new Product("Mobile", "Apple"),
			new Product("Washing Machine", "LG"),
		})
	);
	
	@RequestMapping("/get")
	public List<Product> getTop3Products(){
		return topThree;
	}

}
