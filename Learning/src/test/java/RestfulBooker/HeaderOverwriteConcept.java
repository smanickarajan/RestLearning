package RestfulBooker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;

public class HeaderOverwriteConcept {

	
	@Test
	public void DefaultBehavior() {
		RestAssured.useRelaxedHTTPSValidation();

		RestAssured.given()
		.log()
		.all()
		.header("Header1", "value1")
		.header("Header1", "value2")
	     .when()
	     .get();
	}
	
	@Test
	public void headerOverwrite1() {
		RestAssured.useRelaxedHTTPSValidation();

		RestAssured.given()
		.log()
		.all()
		.config(RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().overwriteHeadersWithName("Header1")))
		.header("Header1", "value1")
		.header("Header1", "value2")
	     .when()
	     .get();
	}
	
	@Test
	public void headerOverwrite2() {
		RestAssured.useRelaxedHTTPSValidation();
//Latest config willoverwrite the previuos..so it will be merged
		RestAssured.given()
		.log()
		.all()
		.config(RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().overwriteHeadersWithName("Header1")))
		.config(RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().mergeHeadersWithName("Header1")))
		.header("Header1", "value1")
		.header("Header1", "value2")
	     .when()
	     .get();
	}
	
	
	@Test
	public void headerOverwrite3() {
		RestAssured.useRelaxedHTTPSValidation();

		RestAssured.given()
		.log()
		.all()
		.config(RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().overwriteHeadersWithName("Header1")))
		.header("Header1", "value1")
		.header("Header1", "value2")
		.header("Header2", "value1")
		.header("Header2", "value2")
	     .when()
	     .get();
	}
	
	
	@Test
	public void RealtimeOverwrite() {
		RestAssured.useRelaxedHTTPSValidation();
RequestSpecification res1=RestAssured.given().header("Header1", "value1");
RequestSpecification res2=RestAssured.given().header("Header1", "value2").header("Header2", "value2");
		RestAssured.given()
		.log()
		.all()
		.config(RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().overwriteHeadersWithName("Header1")))
		.spec(res1)
		.spec(res2)
	     .when()
	     .get();
	}
}
