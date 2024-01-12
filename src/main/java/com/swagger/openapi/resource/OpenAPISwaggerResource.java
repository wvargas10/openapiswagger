package com.swagger.openapi.resource;

import static com.swagger.openapi.constants.OpenAPISwaggerAppConstants.REGISTER_PERSON_GREETING_ENDPOINT;
import static com.swagger.openapi.constants.OpenAPISwaggerAppConstants.REGISTER_PERSON_GREET_ENDPOINT;
import static com.swagger.openapi.constants.OpenAPISwaggerAppConstants.REQUEST_ID;
import static com.swagger.openapi.constants.OpenAPISwaggerAppConstants.HTTP_200;
import static com.swagger.openapi.constants.OpenAPISwaggerAppConstants.HTTP_400;
import static com.swagger.openapi.constants.OpenAPISwaggerAppConstants.SUCCESS_RESPONSE;
import static com.swagger.openapi.constants.OpenAPISwaggerAppConstants.FAILURE_RESPONSE;
import static com.swagger.openapi.constants.OpenAPISwaggerAppConstants.API_CONTEXT_ROOT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = API_CONTEXT_ROOT)
@RestController
public class OpenAPISwaggerResource {

	@Autowired
	PersonRegistrationService personRegistrationService;
	
	@Tag(name = "OpenAPI Greeting", description = "API Greeting")
	@Operation(method = "GET",
            summary = "General greeting",
            description = "REST method returns a general greeting",
            responses = @ApiResponse(responseCode = "200", description = "Success response") )
	@Parameter(description = "Request ID.",
			   name = REQUEST_ID,
	           in = ParameterIn.HEADER,
	           required = false,
	           schema = @Schema(type = "string", example = "requestID"))
	@GetMapping(value = REGISTER_PERSON_GREETING_ENDPOINT)
	public String getRegisterPersonGreeting() {
		final String methodName = "getGreeting";
		log.debug("[{}] Started", methodName);
		String greet = personRegistrationService.registerPersonGreetGeneral();
		
 		return greet;
	}
	
	@Tag(name = "OpenAPI Greeting", description = "API Greeting")
	@Operation(method = "GET",
			summary = "Register person greeting name through path variable",
			description = "REST method  returns personlized name greting provided by path variable")
    @ApiResponse(responseCode = HTTP_200, description = SUCCESS_RESPONSE)
	@Parameter(description = "Request ID.",
			   name = REQUEST_ID,
			   in = ParameterIn.HEADER,
			   required = false,
			   schema = @Schema(type = "string", example = "requestID"))
	@GetMapping(value = REGISTER_PERSON_GREETING_ENDPOINT + "/{name}")
	public String getRegisterPersonGreetingNamePathVariable(
			@Parameter(description = "Path Variable value", in=ParameterIn.PATH, required = true, example = "namePathParam")
			@PathVariable(value = "name") String name) {
		final String methodName = "getGreetinNamePathVariable";
		log.debug("[{}] Started", methodName);
		
		log.debug("name = {} ", name);
		String greet = personRegistrationService.registerPersonGreetName(name);
		
		return greet;
	}
	
	@Tag(name = "OpenAPI Greeting", description = "API Greeting")
	@Operation(method = "GET",
			summary = "Register person greeting name through request param",
			description = "REST method  returns personlized name greting provided by request param")
	@ApiResponse(responseCode = HTTP_200, description = SUCCESS_RESPONSE)
	@Parameter(description = "Request ID.",
			   name = REQUEST_ID,
			   in = ParameterIn.HEADER,
			   required = false,
			   schema = @Schema(type = "string", example = "requestID"))
	@GetMapping(value = REGISTER_PERSON_GREET_ENDPOINT)
	public String getRegisterPersonGreetingNameRequestParam(
			@Parameter(description = "Request Param value", in=ParameterIn.QUERY, required = true, example = "nameRequestParam")
			@RequestParam (value = "name", required = true) String name) {
		final String methodName = "getGreetinNameRequestParam";
		log.debug("[{}] Started", methodName);
		
		log.debug("name = {} ", name);
		String greet = personRegistrationService.registerPersonGreetName(name);
		
		return greet;
	}
	
	@Tag(name = "OpenAPI Register", description = "API to register")
	@Operation(method = "POST",
			summary = "Register person",
			description = "REST method  registers person")
	@ApiResponses(value = {
			@ApiResponse(responseCode = HTTP_200,
					     description = SUCCESS_RESPONSE,
					     content = { @Content(schema = @Schema(implementation = PersonPayloadOutput.class),
					                          mediaType = MediaType.APPLICATION_JSON_VALUE) }),
			@ApiResponse(responseCode = HTTP_400,
						 description = FAILURE_RESPONSE,
						 content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
	})
	@Parameter(description = "Request ID.",
			   name = REQUEST_ID,
			   in = ParameterIn.HEADER,
			   required = false,
			   schema = @Schema(type = "string", example = "requestID"))
	@PostMapping("/registerperson")
	public PersonPayloadOutput registerPerson(@RequestBody PersonPayloadInput payloadInput) throws ServiceInvocationException {
		final String methodName = "registerPerson";
		log.debug("[{}] Started", methodName);
		
		log.debug("payloadInput = {} ", payloadInput);
		PersonPayloadOutput output = personRegistrationService.registPerson(payloadInput);
		
		return output;
	}
}
