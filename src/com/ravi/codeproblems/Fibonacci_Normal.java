package com.ravi.codeproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Fibonacci_Normal {

	public List doFibonacci(int n) {

		List<Integer> fibo = new ArrayList<Integer>();
		if (n == 0)
			return Arrays.asList(0);
		if (n == 1)
			return Arrays.asList(0);
		if (n == 2)
			return Arrays.asList(0, 1);
		fibo.add(0);
		fibo.add(1);
		n = n - 2;

		while (n > 0) {
			int a = fibo.get(fibo.size() - 1);
			int b = fibo.get(fibo.size() - 2);
			fibo.add(a + b);
			n = n - 1;
		}
		return fibo;

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Fibonacci_Normal fib = new Fibonacci_Normal();
		boolean validData=true;
		do {
			try{
			int fact_end = scan.nextInt();
			System.out.println("Fibonacci :" +fib.doFibonacci(fact_end));
			validData = true;
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println("Only Int is possible");
				e.printStackTrace();
				validData=false;
			}
		}while (validData==true);
	}
}
