package RestfulBooker;

import io.restassured.RestAssured;

public class PathParameterExample2 {

	public static void main(String[] args) {
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.given()
		                   .log()
		                   .all()		                   
		                
		                   
		
		          .when()
		                   .get("https://restful-booker.herokuapp.com/{basepath}/{id}","booking",3)
		
		         .then()
		                   .log()
		                   .all()
		                   .statusCode(200);

	}

}
