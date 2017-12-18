package com.ravi.codeproblems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RansomNote {
	
	public static void main(String[] args){
		String calendar = "two times three is not four";
		String ransomNote = "Two times two is four not ";
		System.out.println(isNotePossible(calendar.split("\\s+"), ransomNote.split("\\s+")));
		
		
	}
	
	public static boolean isNotePossible(String[] calendar, String[] ransomNote){
		List<String> calendarList = Arrays.asList(calendar).stream().map(x -> x.toLowerCase()).collect(Collectors.toList());
		
		
		Long matchCount = Arrays.stream(ransomNote).filter(word -> calendarList.contains(word.toLowerCase())).collect(Collectors.counting());
		if (matchCount == ransomNote.length ) 
			return true;
		return false;
	}

}
