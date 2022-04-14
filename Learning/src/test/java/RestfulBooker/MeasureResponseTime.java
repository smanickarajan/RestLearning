package RestfulBooker;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MeasureResponseTime {

	public static void main(String[] args) {
		RestAssured.useRelaxedHTTPSValidation();
		// Build Request
		Response response = RestAssured
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
				.post();
		
		long responsetimeinmillisecs = response.time();
		
		System.out.println("responsetimeinmillisecs :"+responsetimeinmillisecs);
		
long responsetimeinsecs = response.timeIn(TimeUnit.SECONDS);
		
		System.out.println("responsetimeinsecs :"+responsetimeinsecs);
		
long responsetimeinmillisecs1 = response.getTime();
		
		System.out.println("responsetimeinmillisecs 1:"+responsetimeinmillisecs1);
		
long responsetimeinsecs1 = response.getTimeIn(TimeUnit.SECONDS);
		
		System.out.println("responsetimeinsecs1 :"+responsetimeinsecs1);
		response.then().time(Matchers.lessThan(5000L));
		response.then().time(Matchers.greaterThan(0L));
		response.then().time(Matchers.both(Matchers.lessThan(5000L)).and(Matchers.greaterThan(0L)));
		response.then().time(Matchers.lessThan(5L), TimeUnit.SECONDS);
		response.then().time(Matchers.greaterThan(0L), TimeUnit.SECONDS);

	}

}
