package DataShare;

import java.util.LinkedHashMap;

public class DataStoreasMapwithThreadLocal {

	
	private DataStoreasMapwithThreadLocal() {
		
	}
	
	private static ThreadLocal<LinkedHashMap<String,Object>> datamap= ThreadLocal.withInitial(()->new LinkedHashMap<String,Object>());
	
	public static void setValue(String Key, Object Value) {
		datamap.get().put(Key,Value);
	}
	
	public static  Object getValue(String Key) {
		return datamap.get().get(Key);
		
	}
}
