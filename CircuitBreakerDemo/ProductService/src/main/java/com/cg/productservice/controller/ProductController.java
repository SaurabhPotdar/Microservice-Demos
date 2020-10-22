package com.cg.productservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.productservice.dto.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

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
	@HystrixCommand(fallbackMethod = "getTop3Fallback", threadPoolKey = "productPool", 
	threadPoolProperties = {
		@HystrixProperty(name = "coreSize", value = "20"),
	}, 
	commandProperties = {
		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
		@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
		@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
		@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"), })
	public List<Product> getTop3Products(){
		//Simulate delay
		simulateDelay();
		return topThree;
	}
	
	public List<Product> getTop3Fallback(){
		//Hardcoded fallback response
		List<Product> topThree = new ArrayList<>(
			Arrays.asList(new Product[] {
				new Product("TV", "Generic Brand"),
				new Product("Mobile", "Generic Brand"),
				new Product("Washing Machine", "Generic Brand"),
			})
		);
		return topThree;
	}
	
	public void simulateDelay() {
		Random rand = new Random();
		//Generate random number between 1 and 3.
		int randomNum = rand.nextInt(3) + 1;
		if (randomNum==3) {
			sleep();
		}
	}

	private void sleep() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
	}

}
