package com.cg.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Value("${app.property}")
	private String message;
	
	@RequestMapping
	public String getProperty() {
		return message;
	}
	
}
