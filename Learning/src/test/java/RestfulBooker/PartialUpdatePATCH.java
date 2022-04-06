package RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PartialUpdatePATCH {

	public static void main(String[] args) {
		RestAssured.useRelaxedHTTPSValidation();
		// Build Request
		RestAssured
		.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking/2")
				.contentType(ContentType.JSON)
				.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
				.body("{\r\n" + 
						"    \"firstname\" : \"DDD\",\r\n" + 
						"    \"lastname\" : \"SSS\"\r\n" + 
						"}")
				// Hit Request and Get Response
	    .when()
				.patch()

				// Validate Response
	     .then()
	            .log()
	            .all()
	            .statusCode(200);

	}

}
