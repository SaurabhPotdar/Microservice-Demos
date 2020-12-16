package com.cg.productservicecatalog.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.productservicecatalog.dto.Product;

@Component
public class FeignProxyFallback implements FeignProxy {

	@Override
	public List<Product> get() {
		return new ArrayList<>(Arrays.asList( new Product[] { 
			new Product("TV", "Generic Brand"),
			new Product("Mobile", "Generic Brand"), 
			new Product("Washing Machine", "Generic Brand"), 
			})
		);
	}

}
