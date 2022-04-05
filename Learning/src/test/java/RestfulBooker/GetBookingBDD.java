package RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetBookingBDD {
	public static void main(String[] args) {
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.given()
		                   .log()
		                   .all()
		                   .baseUri("https://restful-booker.herokuapp.com/")
		                   .basePath("booking/{id}")
		                    .pathParam("id", "5")
		
		          .when()
		                   .get()
		
		         .then()
		                   .log()
		                   .all()
		                   .statusCode(200);
	
	
}
}
