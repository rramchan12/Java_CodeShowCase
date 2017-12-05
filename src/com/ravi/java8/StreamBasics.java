package com.ravi.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamBasics {
	
	public static void main(String[] args){
		
		//Foundation for Functional Programming
		//Three Distinct Stages : (1) StreamSource : IntStream.range() or Arrays.stream()
		//(2) Intermediate Operation : map(), filter(), distinct(), sorted() etc
		//(3) Terminal Operation : sum(), collect(), forEach(), reduce()
		
		//1. Create a Stream using "OF" Keyword
		Stream.of("Good", "Morning", "Great", "Lord")
		//.filter takes a Predicate Interface
		.filter(s -> s.startsWith("G")||s.startsWith("L"))
		//.forEach takes a Consumer Interface
		//Also using the syntactic sugar Class.method instead of s-> System.out.println(s)
		.forEach(System.out::println);
		
		//2. Creating Stream from Arrays
		int[] intArray = {1,2,3,4,5};
		//A reduction Operation - https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
		int sum = Arrays.stream(intArray).peek(System.out::println).reduce(0,(x,y) -> x+y);
		System.out.println("Sum : "+sum);
	   
		
		//3. Creating Stream from Functions 
		//3.1 Iterate
		Stream.iterate(0, n-> n+2).limit(5).forEach(System.out::println);
		//3.2 Generate
		Stream.generate(Math::random).limit(5).forEach(System.out::println);
		
		
		//4. Stream from a Collection 
		List<String> libraryBooks = new ArrayList<String>();
		libraryBooks.addAll(Arrays.asList("Book1","Book2","Book3"));
		
		Stream<String> bookStream = libraryBooks.stream();
		System.out.println("Count of Books :"+bookStream.count());
		
		//5. From File 
		//Stream<String> lines = Files.lines(Paths.get("/tmp/data"), Charset.defaultCharset());
	}

}
