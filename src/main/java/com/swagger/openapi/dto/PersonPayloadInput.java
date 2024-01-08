package com.swagger.openapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonPayloadInput {
	private String firstName;
	private String lastName;
	private int age;
	private String address;
	private String city;
	private String state;
	private String country;
	private String date;
}
