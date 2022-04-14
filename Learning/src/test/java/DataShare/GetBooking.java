package DataShare;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetBooking {

	@Test
	public void getBooking(ITestContext context) {
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.given()
		                   .log()
		                   .all()
		                   .baseUri("https://restful-booker.herokuapp.com/")
		                   .basePath("booking/{id}")
		                    .pathParam("id", context.getAttribute("bookingid"))
		
		          .when()
		                   .get()
		
		         .then()
		                   .log()
		                   .all()
		                   .statusCode(200);
	}
}
