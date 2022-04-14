package JsonPathConcepts;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class WithInlineAssertions {
	@Test
	public void CreateToken() {
		RestAssured.useRelaxedHTTPSValidation();
		// Build Request
		RestAssured
		.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/auth")			
				.contentType(ContentType.JSON)
				.body("{\r\n" + 
						"    \"username\" : \"admin\",\r\n" + 
						"    \"password\" : \"password123\"\r\n" + 
						"}")
				// Hit Request and Get Response
	    .when()
				.post()

				// Validate Response
	     .then()
	            .log()
	            .all()
	            .body("token", Matchers.notNullValue())
		.body("token.length()", Matchers.is(15))
		.body("token.length()", Matchers.equalTo(15))
		.body("token", Matchers.matchesRegex("^[a-z0-9]+$"));
}
	
	@Test
	public void GetBookingIds() {
		RestAssured.useRelaxedHTTPSValidation();
		// Build Request
		RestAssured
		.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/booking")			
				
				// Hit Request and Get Response
	    .when()
				.get()

				// Validate Response
	     .then()
	            .log()
	            .all()
	            .body("bookingid", Matchers.hasItem(5))
	            .body("bookingid", Matchers.hasItems(1,2));
		
}
}
