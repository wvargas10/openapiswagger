package com.swagger.openapi.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.swagger.openapi.service.PersonRegistrationService;
import com.swagger.openapi.service.impl.PersonRegistrationServiceImpl;

@Configuration
@ComponentScan(basePackages = { "com.swagger.openapi" })
public class OpenAPISwaggerApplicationConfig {
	private static Logger logger = LoggerFactory.getLogger(OpenAPISwaggerApplicationConfig.class);

	@Bean
	public PersonRegistrationService personRegistrationServiceImpl() {
		return new PersonRegistrationServiceImpl();
	}

}
