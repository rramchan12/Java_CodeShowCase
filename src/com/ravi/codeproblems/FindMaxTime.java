package com.ravi.codeproblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
 * 
 * 
 */
public class FindMaxTime {

	public static void main(String args[]) {
		// findMaxTime(Arrays.asList(1,2,3,4));

		/*
		 * Arrays.asList(1,2,3,2,15,7,8,32).stream().reduce((x,y) -> x>y ? x :
		 * y).ifPresent(x -> System.out.println(x));
		 * Arrays.asList(1,2,3,2,15,7,8,32).stream().map(x ->
		 * x+10).sorted().forEach(System.out::println);
		 * 
		 * List<Integer> list1 = Arrays.asList(1,2,3,4,8); int max_number = 0;
		 * for (int number : list1){
		 * 
		 * if ( number > max_number) max_number = number ; }
		 */
		System.out.println(findMaxTime(1, 5, 2, 3));
		/*List<Integer> numberList = new LinkedList(Arrays.asList(1, 5, 2, 3));
		numberList.stream().filter(x -> x < 3).max((x, y) -> x - y).ifPresent( System.out::println);;*/
	}

	public static String findMaxTime(int a, int b, int c, int d) {
		// To be used to find the exclusions
		List<Integer> numberList = new LinkedList(Arrays.asList(a, b, c, d));
		StringBuffer maxTime = new StringBuffer() ;
		// Pseudocode
		// 1st digit should either be <3
		Integer firstDigit = numberList.stream().filter(x -> x < 3).max((x, y) -> x -y).get();
		// Remove the selected Digit for the list
		numberList.remove(firstDigit);
		maxTime.append(firstDigit.toString());

		// 2nd Digit
		// If 1st = 2 2nd = max(2,3) else 2nd = max (1-9)
		Integer secondDigit;
		if (firstDigit == 2) {
			secondDigit = numberList.stream().filter(x -> (x > 2 && x <= 3)).max((x, y) -> x -y).get();
		} else {
			secondDigit = numberList.stream().max((x, y) -> x - y).get();
		}
		numberList.remove(secondDigit);
		maxTime.append(secondDigit.toString());

		// Append Colon
		maxTime.append(':');

		// 3rd Digit
		// max(0-6)
		Integer thirdDigit;
		thirdDigit = numberList.stream().filter(x -> x < 6).max((x, y) -> x - y).get();
		numberList.remove(thirdDigit);
		maxTime.append(thirdDigit.toString());

		// 4rth Digit is the last remaining element of the array
		Integer fourthDigit = numberList.stream().findAny().get();
		maxTime.append(fourthDigit.toString());

		return maxTime.toString();
	}

}
