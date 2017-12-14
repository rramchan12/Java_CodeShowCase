package com.ravi.codeproblems;

/*Given a string of brackets, the task is to find an index k which decides the number of opening brackets is equal to the number of closing brackets.
String must be consists of only opening and closing brackets i.e. ‘(‘ and ‘)’.
The 
*/
public class FindEqualPointInBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Match Found : " +FindEqualPointInBrackets.findIndex("()()()"));
		

	}

	public static int findIndex(String testString) {
		// The result initialized
		int balancePoint = -1;
		int len = testString.length();
		// Initialize an array equal to the length of the testString
		int[] openingBracket = new int[len];
		int[] closingBracket = new int[len];

		// Count the no of Opening Brackets at each index
		for (int i = 0; i < len; i++) {

			if (testString.charAt(i) == '(') {
				if (i==0)
					openingBracket[i]=1;
				else
					openingBracket[i] = openingBracket[i-1] + 1;
			} else {
				openingBracket[i] = openingBracket[i-1];
			}
		}

		// Count the no of Closing Bracket at each Point
		for (int i = len-1; i >=0 ; i--) {

			if (testString.charAt(i) == ')') {
				if(i==len-1)
					closingBracket[i] = 1;
				else
					closingBracket[i] = closingBracket[i+1] + 1;
			} else {
				closingBracket[i] = closingBracket[i+1];
			}
		}
		
		//Find if there is a Balance Point for the same
		//Iterate and find the first match
		for (int i = 0; i < len; i ++){
			System.out.println( " Open : Close "+openingBracket[i]+":"+closingBracket[i]);
			if (openingBracket[i] == closingBracket[i]){
				balancePoint = i;
				return balancePoint;
			}
		}
		return balancePoint;
	}

}
