package com.swagger.openapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonPayloadInput {
	@Schema(name = "firstName", type = "String", defaultValue = "FirstName", description = "First Name")
	private String firstName;

	@Schema(name = "lastName", type = "String", defaultValue =  "LastName", description = "Last Name")
	private String lastName;

	@Schema(name = "age", type = "integer", defaultValue =  "19", description = "age")
	private int age;

	@Schema(name = "address", type = "String", description = "Adress", example = "123 Somewhere St")
	private String address;

	@Schema(name = "city", type = "String", description = "City", example = "Chicago")
	private String city;

	@Schema(name = "state", type = "String", description = "State", example = "IL")
	private String state;

	@Schema(name = "country", type = "String", description = "Country", example = "USA")
	private String country;

	@Schema(name = "date", type = "String", description = "Date", example = "2023-12-01")
	private String date;
}
