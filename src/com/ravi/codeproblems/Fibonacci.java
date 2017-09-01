package com.ravi.codeproblems;

import java.util.Scanner;

public class Fibonacci {
	
	public int doFibonacci(int n){
		
		if (n==1) return 1;
		if (n==0) return 0;
		return this.doFibonacci(n-1)+this.doFibonacci(n-2);
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Fibonacci fib = new Fibonacci();
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
				validData=false;
			}
			
			
		}
		while(validData==false);
	}

}
