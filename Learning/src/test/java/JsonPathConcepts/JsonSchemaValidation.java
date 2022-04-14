package JsonPathConcepts;

import java.io.File;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidation {
@Test
public void JsonSchemaValidation1() {
	RestAssured.useRelaxedHTTPSValidation();
	// Build Request
	RestAssured
	.given()
			.log()
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.basePath("booking")
			.contentType(ContentType.JSON)
			.body("{\r\n" + 
					"    \"firstname\" : \"manick\",\r\n" + 
					"    \"lastname\" : \"test\",\r\n" + 
					"    \"totalprice\" : 111,\r\n" + 
					"    \"depositpaid\" : true,\r\n" + 
					"    \"bookingdates\" : {\r\n" + 
					"        \"checkin\" : \"2022-05-01\",\r\n" + 
					"        \"checkout\" : \"2022-05-02\"\r\n" + 
					"    },\r\n" + 
					"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
					"}")
			// Hit Request and Get Response
    .when()
			.post()

			// Validate Response
     .then()
            .log()
            .all()
            .statusCode(200)
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("CreateBookingResponseSchema.json"));
}

@Test
public void JsonSchemaValidation2() {
	RestAssured.useRelaxedHTTPSValidation();
	// Build Request
	RestAssured
	.given()
			.log()
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.basePath("booking")
			.contentType(ContentType.JSON)
			.body("{\r\n" + 
					"    \"firstname\" : \"manick\",\r\n" + 
					"    \"lastname\" : \"test\",\r\n" + 
					"    \"totalprice\" : 111,\r\n" + 
					"    \"depositpaid\" : true,\r\n" + 
					"    \"bookingdates\" : {\r\n" + 
					"        \"checkin\" : \"2022-05-01\",\r\n" + 
					"        \"checkout\" : \"2022-05-02\"\r\n" + 
					"    },\r\n" + 
					"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
					"}")
			// Hit Request and Get Response
    .when()
			.post()

			// Validate Response
     .then()
            .log()
            .all()
            .statusCode(200)
            .body(JsonSchemaValidator.matchesJsonSchema(new File("..\\Learning\\src\\test\\resources\\CreateBookingResponseSchema.json")));
}

@Test
public void JsonSchemaValidation3() {
	String response="{\r\n" + 
			"    \"bookingid\": 1,\r\n" + 
			"    \"booking\": {\r\n" + 
			"        \"firstname\": \"Jim\",\r\n" + 
			"        \"lastname\": \"Brown\",\r\n" + 
			"        \"totalprice\": 111,\r\n" + 
			"        \"depositpaid\": true,\r\n" + 
			"        \"bookingdates\": {\r\n" + 
			"            \"checkin\": \"2018-01-01\",\r\n" + 
			"            \"checkout\": \"2019-01-01\"\r\n" + 
			"        },\r\n" + 
			"        \"additionalneeds\": \"Breakfast\"\r\n" + 
			"    }\r\n" + 
			"}";
	
	MatcherAssert.assertThat(response, JsonSchemaValidator.matchesJsonSchemaInClasspath("CreateBookingResponseSchema.json"));
}
}
