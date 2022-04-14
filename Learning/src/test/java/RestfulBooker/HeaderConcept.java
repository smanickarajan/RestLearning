package RestfulBooker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class HeaderConcept {

	@Test
	public void headerconcept1() {
		RestAssured.useRelaxedHTTPSValidation();

		RestAssured.given()
		.log()
		.all()
		.header("Header1", "value1")
	     .when()
	     .get();
	}
	
	@Test
	public void headerconcept2() {
		RestAssured.useRelaxedHTTPSValidation();

		RestAssured.given()
		.log()
		.all()
		.header("Header1", "value1")
		.header("Header2", "value1","value2","value3")
	     .when()
	     .get();
	}
	
	@Test
	public void headerconcept3() {
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
	public void headerconcept4() {
		RestAssured.useRelaxedHTTPSValidation();
		
		Header head=new Header("Header5", "Value5");

		RestAssured.given()
		.log()
		.all()
		.header(head)
		
	     .when()
	     .get();
	}
	
	@Test
	public void headerconcept5() {
		RestAssured.useRelaxedHTTPSValidation();
		
		

		RestAssured.given()
		.log()
		.all()
		.headers("Header1", "value1","Header2", "value2","Header3", "value3")
		
	     .when()
	     .get();
	}
	
	@Test
	public void headerconcept6() {
		RestAssured.useRelaxedHTTPSValidation();
		
		

		RestAssured.given()
		.log()
		.all()
		.headers("Header1", "value1","Header2", "value2","Header2", "value3")
		
	     .when()
	     .get();
	}
	
	
	//Preferable
	@Test
	public void headerconcept7() {
		RestAssured.useRelaxedHTTPSValidation();
		
		Map<String,String> headermap=new HashMap<>();
		headermap.put("Header1", "Value1");
		headermap.put("Header2", "Value2");
		headermap.put("Header3", "Value3");
		headermap.put("Header4", "Value4");
		

		RestAssured.given()
		.log()
		.all()
		.headers(headermap)
		
	     .when()
	     .get();
	}
	
	@Test
	public void headerconcept8() {
		RestAssured.useRelaxedHTTPSValidation();
		
		Header header=new Header("Header5", "Value5");
		Headers headres=new Headers(header);
		

		RestAssured.given()
		.log()
		.all()
		.headers(headres)
		
	     .when()
	     .get();
	}
	
	
	@Test
	public void headerconcept9() {
		RestAssured.useRelaxedHTTPSValidation();
		List<Header> headerList=new ArrayList<>();
		
		Header header=new Header("Header5", "Value5");
		Header header1=new Header("Header6", "Value6");
		headerList.add(header);
		headerList.add(header1);
		Headers headres=new Headers(headerList);
		

		RestAssured.given()
		.log()
		.all()
		.headers(headres)
		
	     .when()
	     .get();
	}
}
