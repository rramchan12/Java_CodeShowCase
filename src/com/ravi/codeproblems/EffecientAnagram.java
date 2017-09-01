package com.ravi.codeproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EffecientAnagram {
	
	Map <String, List<String>> lookup = new HashMap<String, List<String>>();
	public static void main(String[] args) {
		
		EffecientAnagram effAna = new EffecientAnagram(Arrays.asList("abets", "baste", "betas", "abc", "bca"));
		System.out.println(effAna.getAnagrams("baste"));
		
		
		
	}
	
	public EffecientAnagram(List<String> words) {
		
		for (String word: words){
			String signature = alphabatize(word);
			if (lookup.containsKey(signature)){
				lookup.get(signature).add(word);
			}
			else{
				List<String> temp = new ArrayList<String>();
				temp.add(word);
				lookup.put(signature, temp);
			}
		}
		
	}
	
	
	
	public static String alphabatize(String input){
		final byte[] signature = input.getBytes();
		Arrays.sort(signature);
		return new String(signature);
	}
	
	public List<String> getAnagrams(String word){
		String signature = alphabatize(word);
		final List<String> anagrams = this.lookup.get(signature);
		return anagrams==null ? new ArrayList<String> () : anagrams;
		
		
	}

}
