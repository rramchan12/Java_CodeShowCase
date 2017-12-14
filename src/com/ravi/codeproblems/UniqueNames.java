package com.ravi.codeproblems;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/* Given a list of names find the first unique name 
 * { "Abbi", "Adeline", "ravi", "Abbi", "Adalia", "Adeline",
                           "Raj", "Adeline", "Adalia", "Vijay", "ravi" } would give Raj 
	{ "Abbi", "Adeline","Rakesh", "ravi", "Abbi", "Adalia", "Adeline",
                           "Raj", "Adeline", "Adalia", "Vijay", "ravi" } would give Rakesh
 */

public class UniqueNames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(findUniqueNames(new String[] { "Abbi", "Adeline", "ravi", "Abbi", "Adalia", "Adeline",
                "Raj", "Adeline", "Adalia", "Vijay", "ravi" }));
        System.out.println(findUniqueNames(new String[] { "Abbi", "Adeline","Rakesh", "ravi", "Abbi", "Adalia", "Adeline",
                "Raj", "Adeline", "Adalia", "Vijay", "ravi" }));
        System.out.println(findUniqueNamesStreams(new String[] { "Abbi", "Adeline", "ravi", "Abbi", "Adalia", "Adeline",
                "Raj", "Adeline", "Adalia", "Vijay", "ravi" }));
        System.out.println(findUniqueNamesStreams(new String[] { "Abbi", "Adeline","Rakesh", "ravi", "Abbi", "Adalia", "Adeline",
                "Raj", "Adeline", "Adalia", "Vijay", "ravi" }));
}

	
	
	public  static String findUniqueNames(String[] names) {
		Map<String, Integer> nameMap = new LinkedHashMap<String, Integer>();
		//Add the occurences in a LinkedHashMap which preserves the order, and counts the number of occurences
		for (String name : names) {
			int count = nameMap.containsKey(name) ? nameMap.get(name)+1 : 1;
			nameMap.put(name, count);
		}
		
		//Find the first element in the LinkedHashMap which has a value of 1
		for (String key : nameMap.keySet()){
			if (nameMap.get(key).equals(1))
				return key;
				
		}
		
		
		return null;
	}
	
	/* 
	 * Using the same logic using Java 8 Streams
	 */
	public static String findUniqueNamesStreams(String[] names) {
		Map<String, Long> countMap = Arrays.stream(names).collect(Collectors.groupingBy(x-> x, LinkedHashMap::new, Collectors.counting())); 
		return countMap.keySet().stream().filter(x -> countMap.get(x).equals(1L)).limit(1).collect(Collectors.joining());
	}

}
