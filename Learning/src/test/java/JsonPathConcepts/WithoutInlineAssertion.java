package JsonPathConcepts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class WithoutInlineAssertion {
@Test
public void CreateToken() {
	RestAssured.useRelaxedHTTPSValidation();
	// Build Request
	
	String jsonResponse="";
	jsonResponse=RestAssured
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
            .extract()
            .asString();
	
	
	JsonPath js=new JsonPath(jsonResponse);
	
	Assert.assertNotNull(js.get("token"));
}
}
