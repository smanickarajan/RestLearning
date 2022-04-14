package DataShare;

import java.util.LinkedHashMap;

public class DataStoreasMap {

	
	private DataStoreasMap() {
		
	}
	
	private static LinkedHashMap<String,Object> datamap= new LinkedHashMap<>();
	
	public static void setValue(String Key, Object Value) {
		datamap.put(Key,Value);
	}
	
	public static  Object getValue(String Key) {
		return datamap.get(Key);
		
	}
}
