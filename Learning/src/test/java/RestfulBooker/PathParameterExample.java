package RestfulBooker;

import io.restassured.RestAssured;

public class PathParameterExample {

	public static void main(String[] args) {
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.given()
		                   .log()
		                   .all()
		                   .baseUri("https://restful-booker.herokuapp.com/")
		                   .basePath("{basepath}/{id}")
		                   .pathParam("basepath", "booking")
		                    .pathParam("id", "5")
		
		          .when()
		                   .get()
		
		         .then()
		                   .log()
		                   .all()
		                   .statusCode(200);

	}

}
