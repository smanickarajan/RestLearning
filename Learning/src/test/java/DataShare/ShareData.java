package DataShare;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ShareData {
	
	@Test(priority=1)
	public void CreateBooking() {
		RestAssured.useRelaxedHTTPSValidation();
		// Build Request
		 int id = RestAssured
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
	            .extract()
	            .jsonPath()
	            .getInt("bookingid");
		 DataStoreasMap.setValue(Constants.BOOKINGID, id);
	}
	
	@Test(priority=2)
	public void retriveBooking() {
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.given()
		                   .log()
		                   .all()
		                   .baseUri("https://restful-booker.herokuapp.com/")
		                   .basePath("booking/{id}")
		                    .pathParam("id", DataStoreasMap.getValue(Constants.BOOKINGID))
		
		          .when()
		                   .get()
		
		         .then()
		                   .log()
		                   .all()
		                   .statusCode(200);
	}

}
