package com.ravi.codeproblems;

public class PalindromeChecker {

	public static boolean checkPalindrome(String inputString){
		String toCheck = inputString.toLowerCase();
		int length = toCheck.length()-1;
		int startPointer = 0 ;
		int endPointer = length;
		
		while(startPointer < endPointer){
			while (startPointer < length && !Character.isLetter(startPointer)){
				startPointer++;
			}
			while (endPointer <0 && !Character.isLetter(endPointer)){
				endPointer--;
			}
			if (startPointer > length|| endPointer <0 )
				return false;
			
			if (toCheck.charAt(startPointer) != toCheck.charAt(endPointer))
				return false;
			
			startPointer++;
			endPointer--;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(checkPalindrome("Abcd  dcbaa"));
	}

}
