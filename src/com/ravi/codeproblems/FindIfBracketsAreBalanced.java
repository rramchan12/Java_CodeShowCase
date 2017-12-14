package com.ravi.codeproblems;

import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * 
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].
 */
public class FindIfBracketsAreBalanced {

	public static void main(String[] args ) {
		  /*Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for (int a0 = 0; a0 < t; a0++) {
	            String expression = in.next();
	            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
	        }*/
		  /*isBalancedStream("{({()})}");*/
		System.out.println(isBalancedStream("{({()})}"));

	}
	
	 public static boolean isBalanced(String expression) {
	        Stack<Character> balancerStack = new Stack<>(); 
	        char[] expression_array =  expression.toCharArray(); 
	        for (char bracket: expression_array){
	        	switch (bracket){
	        	case '{':
	        		balancerStack.push('}'); break;
	        	case '(':
	        		balancerStack.push(')'); break;
	        	case '[':
	        		balancerStack.push(']'); break;
	        	default:
	        		if  (balancerStack.isEmpty() || bracket != balancerStack.peek())
	        			return false;
	        		balancerStack.pop();
	      
	        	
	        	}
	        	
	        }
	        return true;	  
	    }
	// 123 -> 125 , 91 -> 93 , 40 -> 41
	 public static boolean isBalancedStream(String expression) {
			if (expression.length() % 2 != 0)
				return false;
			int middlePoint = expression.length() / 2;
			Stack<Integer> balancerStack = expression.chars().map(n -> {
				if (n % 2 == 1)
					n = n + 1;
				return n + 1;
			}).boxed().limit(middlePoint).collect(Collectors.toCollection(Stack::new));
			return expression.chars().skip(middlePoint).allMatch(n -> (balancerStack.pop().equals(n)));
			
		} 
}
