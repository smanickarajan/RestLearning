package JsonPayLoad;

import java.util.Map;

import io.restassured.RestAssured;

public class ConvertJSonObjectResponseToMap {

	public static void main(String[] args) {
		RestAssured.useRelaxedHTTPSValidation();
		Map JsonResponse = RestAssured.given().log().all().get("https://run.mocky.io/v3/ab5dace0-5ad6-4e2f-bbf8-f046df7ea2d8").as(Map.class);
String firstname=JsonResponse.get("firstname").toString();
System.out.println(firstname);

Map<String, String> Address = (Map<String,String>)JsonResponse.get("address");
String street=Address.get("Street").toString();
System.out.println(street);
	}

}

