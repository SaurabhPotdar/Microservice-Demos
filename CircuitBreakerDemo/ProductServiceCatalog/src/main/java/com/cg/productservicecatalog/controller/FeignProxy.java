package com.cg.productservicecatalog.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.cg.productservicecatalog.dto.Product;

//Name of external service we want to call
@FeignClient(name="product-service", fallback = FeignProxyFallback.class)
public interface FeignProxy {
	
	//url of external service
	@GetMapping("/products/get")
	public List<Product> get();

}
