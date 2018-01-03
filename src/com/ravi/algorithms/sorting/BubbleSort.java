package com.ravi.algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {1,5,10,2};
		bubbleSort(data);
		Arrays.stream(data).forEach(System.out::println);
	}
	
	public static int[]  bubbleSort(int[] inputArray){
		int len = inputArray.length;
		//Start the first iteration from 1st to len 
		for (int i =0; i < len ; i ++){
			System.out.println("Pass : "+i);
			//Starting the second Iteration from 0 to ith element
			for (int j=0 ; j<len-i-1; j++){
				if (inputArray[j] > inputArray[j+1]){
					//Swap the values
					int tempValue = inputArray[j+1];
					inputArray[j+1] = inputArray[j];
					inputArray[j] = tempValue;
				}
			}
		}
		return inputArray;
	}

}
