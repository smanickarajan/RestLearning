package RestfulBooker;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class MultipleBookingswithReqspec {
	RequestSpecification reqspec;
	
	@BeforeClass
	public void setupReqSpec() {
		RestAssured.useRelaxedHTTPSValidation();
	 reqspec=RestAssured
			.given()
			.log()
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")			
			.contentType(ContentType.JSON);
	}
	 
	@Test
	public void createBooking() {
		RestAssured
		.given()
				.spec(reqspec)
				.basePath("booking")				
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
	            .statusCode(200);

	}
	
	@Test
	public void updateBooking() {
		RestAssured
		.given()
				.spec(reqspec)
				.basePath("booking/2")				
				.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
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
				.put()

				// Validate Response
	     .then()
	            .log()
	            .all()
	            .statusCode(200);

	}
}
