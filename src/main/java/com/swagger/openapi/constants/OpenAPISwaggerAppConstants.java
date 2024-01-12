/**
 * 
 */
package com.swagger.openapi.constants;

public class OpenAPISwaggerAppConstants {
	private OpenAPISwaggerAppConstants () {}

	public static final String API_CONTEXT_ROOT = "/banking/bankone/v1";
	public static final String REGISTER_PERSON_GREETING_ENDPOINT = "/registerpersongreeting";
	public static final String REGISTER_PERSON_GREET_ENDPOINT = "/registerpersongreet";
	public static final String REGISTER_PERSON_ENDPOINT = "/registerperson";

	public static final String HTTP_200 = "200"; // Success
	public static final String HTTP_400 = "400"; // Client Error
	public static final String HTTP_500 = "500"; // Server Error

	public static final String SUCCESS_RESPONSE = "Success Response";
	public static final String FAILURE_RESPONSE = "Failure Response";

	public static final String START_MSG = "[{}] started [{}]";
	public static final String END_MSG = "[{}] completed [{}]";

	public static final String HTTP_AUTH_TOKEN = "HTTP_AUTH_TOKEN";
	public static final String REQUEST_ID = "REQUEST_ID";
}
