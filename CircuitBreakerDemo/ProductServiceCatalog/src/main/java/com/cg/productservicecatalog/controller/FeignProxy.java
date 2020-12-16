package com.cg.productservicecatalog.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.cg.productservicecatalog.dto.Product;

@FeignClient(name="product-service")
public interface FeignProxy {
	
	@GetMapping("/products/get")
	public List<Product> get();

}
