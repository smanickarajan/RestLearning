package ConvertResponsetoPojo;

import io.restassured.RestAssured;

public class ConvertSimpleJSonArraytoJavaArray {

	public static void main(String[] args) {
		 Address[] add = RestAssured.get("https://run.mocky.io/v3/8aa8b82c-6f34-4fd4-8249-bed0f61eecc0")
				.as(Address[].class);
		
		
		 System.out.println(add.length);
		System.out.println(add[0].getCity());
		System.out.println(add[1].getCity());
		

	}

}
