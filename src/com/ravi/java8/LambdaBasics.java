package com.ravi.java8;

import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaBasics {
	
	public static void main(String[] args) {
		
		//4 Interfaces which are functional 
		
		
		//Predicate Affirms is a value is true 
		//InputArg : T Output Arg : bool
		//Method : test
		Predicate<String> nullCheck = arg -> arg != null;
		Predicate<String> emptyCheck = arg -> arg.length() > 0;
		//Short Circuiting Operation on Predicate
		Predicate <String> bothNullAndEmptyCheck = nullCheck.and(emptyCheck);
		
		String testPositive = "Hello";
		System.out.println(bothNullAndEmptyCheck.test(testPositive));
		
				
	    String negativeTest = null ;
	    System.out.println(bothNullAndEmptyCheck.test(negativeTest));
	    
	    //Consumer : Consumes Something  
	    //Input Arg : T Output : void
	    //Method : accept
	    
	    Consumer<String> printToUpper = arg -> System.out.println(arg.toUpperCase());
	    printToUpper.accept("please make this upper");
	    
	    //Function : Operates on T and Return R
	    //Input : T Output R
	    //Method : apply
	    
	    Function<String, Integer> getMeTheLength = arg -> arg.length();
	    System.out.println(getMeTheLength.apply("The quick brown fox jumps over the lazy dog"));
	    
	    //Combining Functions
	    Function<String,Integer> parseInt = Integer::parseInt;
	    Function<Integer, Double> doubleInt = x -> Math.pow(x, 2)  ;
	    
	    Function<String,Double> parseAndDouble = parseInt.andThen(doubleInt);
	    System.out.println(parseAndDouble.apply("4"));
	    
	    //Supplier : Gives Something
	    //Input Arg : void  Output : T
	    //Method : get
	    
	    Supplier<String> currentDateTime = () -> LocalDateTime.now().toString();
	    System.out.println("CurrentTime : "+currentDateTime.get());
	    
	    
		
	}

}
