package com.ravi.codeproblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindPairInArrays {
	
	
	public static void main(String[] args) {
		prettyPrint(getRandom(15), 5);
	}
	
	public static void printPairs(int[] randomArray, int sum){
		int target;
		Set targetSet = new HashSet(randomArray.length);
		for (int value: randomArray){
			target = sum - value;
		
		
		if (!targetSet.contains(target)){
			targetSet.add(value);
		}
		else{
			System.out.printf("(%d %d) %n", value, target);
		}
		
		}
	}
	public static int[] getRandom(int length){
		int randomInput[] = new int[length];
		for (int i=0; i <length; i++){
			randomInput[i] = (int) (Math.random()*15);
			
		}
		return randomInput;
		
	}
	
	public static void prettyPrint(int[] randomArray, int target){
		System.out.println("Random Integer Array :"+Arrays.toString(randomArray));
		System.out.println("Target :"+target);
		System.out.println("Pairs : ");
		printPairs(randomArray, target);
	}

}



