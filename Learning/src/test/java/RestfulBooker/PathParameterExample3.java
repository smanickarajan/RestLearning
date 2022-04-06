package RestfulBooker;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class PathParameterExample3 {

	public static void main(String[] args) {
		
		Map<String,Object> pathaparmeters=new HashMap<>();
		pathaparmeters.put("basepath", "booking");
		pathaparmeters.put("id", "5");
		
		
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.given()
		                   .log()
		                   .all()
		                   .baseUri("https://restful-booker.herokuapp.com/")
		                   .basePath("{basepath}/{id}")
		                   .pathParams(pathaparmeters)
		
		          .when()
		                   .get()
		
		         .then()
		                   .log()
		                   .all()
		                   .statusCode(200);

	}

}
