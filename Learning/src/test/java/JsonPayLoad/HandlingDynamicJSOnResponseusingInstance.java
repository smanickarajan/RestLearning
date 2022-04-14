package JsonPayLoad;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HandlingDynamicJSOnResponseusingInstance {

	public static void main(String[] args) {
		RestAssured.useRelaxedHTTPSValidation();
	Response JsonResponse = RestAssured.given().log().all()
				.get("https://run.mocky.io/v3/d7a147bd-ff77-4deb-b8a8-fce4e8fdf924");
	Object responseobject = JsonResponse.as(Object.class);
	if(responseobject instanceof List) {
		List responseasList = (List)responseobject;
		System.out.println(responseasList.size());
	}
	else if(responseobject instanceof Map) {
		Map responseasMap = (Map)responseobject;
		System.out.println(responseasMap.entrySet());
	}
	}

}
