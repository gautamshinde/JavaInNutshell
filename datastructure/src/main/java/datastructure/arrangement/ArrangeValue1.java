package datastructure.arrangement;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrangeValue1 {
	private static Map<String,String> bookMap=new HashMap<>();
	
	static {
		bookMap.put("C#", "John");
		bookMap.put("Java", "Rob");	
		bookMap.put("Ruby", "John");
		bookMap.put("JScript", "Rob");
	}
	
	public static void main(String[] args) {
		Set<String> ValueSet = bookMap.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toSet());
		System.out.println(ValueSet);
		Map<String, String> transformMap = new HashMap<>();
		for (Entry<String, String> entry : bookMap.entrySet()) {
			findValueByKey(entry, transformMap);
		}
		//bookMap.entrySet().stream().map(e -> findValueByKey(e, transformMap)).collect(Collectors.toList());
		System.out.println(transformMap);
	}

	public static Entry<String, String> findValueByKey(Entry<String, String> entry, Map<String, String> transformMap) {
		String value  = transformMap.get(entry.getValue());
		if(transformMap.containsKey(entry.getValue())) {
			String valueList = transformMap.get(entry.getValue());
			valueList = valueList+","+entry.getKey();
			transformMap.put(entry.getValue(), valueList);
			
		} else {
			transformMap.put(entry.getValue(), entry.getKey());
		}		
		return entry;
	}
	
	
}
