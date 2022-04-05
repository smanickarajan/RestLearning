package ReqRes;

import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateUser {

	public static void main(String[] args) {
		RestAssured.useRelaxedHTTPSValidation();
		// Build Request
		RestAssured.given()

				.log().all().baseUri("https://reqres.in/").basePath("api/users").contentType(ContentType.JSON)
				.body("{\r\n" + "    \"name\": \"manick\",\r\n" + "    \"job\": \"leader\"\r\n" + "}")
				// Hit Request and Get Response
				.post()

				// Validate Response
				.then().log().all().statusCode(201);

	}

}
