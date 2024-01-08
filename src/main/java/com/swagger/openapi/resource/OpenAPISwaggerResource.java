package com.swagger.openapi.resource;

import static com.swagger.openapi.constants.OpenAPISwaggerAppConstants.API_CONTEXT_ROOT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.openapi.dto.PersonPayloadInput;
import com.swagger.openapi.dto.PersonPayloadOutput;
import com.swagger.openapi.exception.ServiceInvocationException;
import com.swagger.openapi.service.PersonRegistrationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = API_CONTEXT_ROOT)
@RestController
@Tag(name = "OpenApi Swagger API")
public class OpenAPISwaggerResource {

	@Autowired
	PersonRegistrationService personRegistrationService;
	
	@Operation(method = "GET",
            summary = "General greeting",
            description = "REST method returns a general greeting",
            responses = @ApiResponse(responseCode = "200", description = "Success response") )
	@GetMapping(value = "/registerpersongreeting")
	public String getRegisterPersonGreeting() {
		final String methodName = "getGreeting";
		log.debug("[{}] Started", methodName);
		String greet = personRegistrationService.registerPersonGreetGeneral();
		
 		return greet;
	}
	
	@Operation(method = "GET",
            summary = "Register person greeting name through path variable",
            description = "REST method  returns personlized name greting provided by path variable",
            responses = @ApiResponse(responseCode = "200", description = "Success response") )
	@GetMapping(value = "/registerpersongreeting/{name}")
	public String getRegisterPersonGreetingNamePathVariable(@PathVariable(value = "name") String name) {
		final String methodName = "getGreetinNamePathVariable";
		log.debug("[{}] Started", methodName);
		
		log.debug("name = {} ", name);
		String greet = personRegistrationService.registerPersonGreetName(name);
		
		return greet;
	}
	
	@Operation(method = "GET",
            summary = "Register person greeting name through request param",
            description = "REST method  returns personlized name greting provided by request param",
            responses = @ApiResponse(responseCode = "200", description = "Success response") )
	@GetMapping(value = "/registerpersongreet")
	public String getRegisterPersonGreetingNameRequestParam(@RequestParam (value = "name", required = false, defaultValue = "Empty") String name) {
		final String methodName = "getGreetinNameRequestParam";
		log.debug("[{}] Started", methodName);
		
		log.debug("name = {} ", name);
		String greet = personRegistrationService.registerPersonGreetName(name);
		
		return greet;
	}
	
	@Operation(method = "POST",
            summary = "Register person",
            description = "REST method  registers person",
            responses = @ApiResponse(responseCode = "200", description = "Success response") )
	@PostMapping("/registerperson")
	public PersonPayloadOutput registerPerson(@RequestBody PersonPayloadInput payloadInput) throws ServiceInvocationException {
		final String methodName = "registerPerson";
		log.debug("[{}] Started", methodName);
		
		log.debug("payloadInput = {} ", payloadInput);
		PersonPayloadOutput output = personRegistrationService.registPerson(payloadInput);
		
		return output;
	}
}
