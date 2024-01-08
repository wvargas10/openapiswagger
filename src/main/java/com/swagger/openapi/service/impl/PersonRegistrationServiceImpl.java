package com.swagger.openapi.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.swagger.openapi.dto.PersonPayloadInput;
import com.swagger.openapi.dto.PersonPayloadOutput;
import com.swagger.openapi.service.PersonRegistrationService;

public class PersonRegistrationServiceImpl implements PersonRegistrationService {
	private static final Logger logger = LoggerFactory.getLogger(PersonRegistrationServiceImpl.class);

	@Override
	public PersonPayloadOutput registPerson(PersonPayloadInput input) {
		final String methodName = "registPerson";
		logger.debug("[{}] Started", methodName);
		logger.debug("payloadInput = [{}] ", input);
		
		PersonPayloadOutput output = PersonPayloadOutput.builder()
														.isRegister(true)
														.build();
		logger.debug("payloadOuput = [{}] ", output);
		
		return output;
	}

	@Override
	public String registerPersonGreetGeneral() {
		final String methodName = "greetGeneral";
		logger.debug("[{}] Started", methodName);
		return "Greeting from Spring Boot";
	}

	@Override
	public String registerPersonGreetName(String name) {
		final String methodName = "greetName";
		logger.debug("[{}] Started", methodName);
		return "Greeting from Spring Boot:" + name;
	}
}
