package com.ravi.codeproblems;

import java.util.Scanner;

public class Factorial {
	
	public int doFactorial(int n){
		
		if (n==0)
			return 1;
		else
			return n* this.doFactorial(n-1);
		
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Factorial fact = new Factorial();
		boolean validData=true;
		do {
			try{
			int fact_end = scan.nextInt();
			System.out.println("Factorial :" +fact.doFactorial(fact_end));
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
