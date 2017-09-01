package com.ravi.codeproblems;

public class StringReversal {
	
	public static void main(String[] args) {
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder builder = new StringBuilder();
		for (int i=alphabet.length()-1; i>=0; i--){
			builder.append(alphabet.charAt(i));

		}
		System.out.println(builder.toString());
		System.out.println(builder.reverse());
	}

}
