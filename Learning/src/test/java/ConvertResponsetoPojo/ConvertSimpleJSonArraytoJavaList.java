package ConvertResponsetoPojo;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class ConvertSimpleJSonArraytoJavaList {

	public static void main(String[] args) {
		 List<Address> add = RestAssured.get("https://run.mocky.io/v3/8aa8b82c-6f34-4fd4-8249-bed0f61eecc0")
				.as(new TypeRef<List<Address>>() {
				});
		
		
		 System.out.println(add.size());
		System.out.println(add.get(0).getCity());
		System.out.println(add.get(1).getCity());
		

	}

}
