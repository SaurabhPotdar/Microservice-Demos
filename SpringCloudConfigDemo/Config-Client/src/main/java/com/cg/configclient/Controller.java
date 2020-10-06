package com.cg.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Value("${app.property}")
	private String propertyFromConfigClient;
	
	@Value("${db.connection}")
	private String commonPropertyFromConfigServer;
	
	@RequestMapping
	public String getProperty() {
		System.out.println(commonPropertyFromConfigServer + "\n" + propertyFromConfigClient);
		return commonPropertyFromConfigServer + "\n" + propertyFromConfigClient;
	}
	
}
