package com.swagger.openapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
	info = @Info(
			    title = "OpenApi specification - Swagger",
			    description = "API that provides general functionality for the purpose of demonstrating OpenApi Swagger.",
			    termsOfService = "Terms of Service",
				contact = @Contact(
							name = "Walter Vargas",
							email = "wvargas10@hotmail.com",
							url = "https://github.com/wvargas10?tab=repositories"),
				version = "1.0",
				license = @License(
							name = "License MIT Name",
							url = "https://some-url.com")
			),
	servers = {
			@Server(
					description = "LOCAL ENV",
					url = "http://localhost:8080/"
			)
	}
)
public class OpenAPIConfig {

}
