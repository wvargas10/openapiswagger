package com.swagger.openapi.service;

import com.swagger.openapi.dto.PersonPayloadInput;
import com.swagger.openapi.dto.PersonPayloadOutput;

public interface PersonRegistrationService {
	public String registerPersonGreetGeneral();
	public String registerPersonGreetName(String name);
	public PersonPayloadOutput registPerson(PersonPayloadInput input);
}
