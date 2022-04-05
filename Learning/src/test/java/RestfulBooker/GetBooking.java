package RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetBooking {

	public static void main(String[] args) {
		RestAssured.useRelaxedHTTPSValidation();
		RequestSpecification requestspecification = RestAssured.given().log().all();
		requestspecification.baseUri("https://restful-booker.herokuapp.com/");
		requestspecification.basePath("booking/{id}");
		requestspecification.pathParam("id", "5");
		
		Response response = requestspecification.get();
		
		ValidatableResponse validatableresponse = response.then().log().all();
		validatableresponse.statusCode(200);
		

	}

}
