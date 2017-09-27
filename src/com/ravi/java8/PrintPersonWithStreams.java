package com.ravi.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Used on collection in conjuction with Lambdas
public class PrintPersonWithStreams {
	
	public static void main(String[] args) {
		List<Person> personArray= Arrays.asList(new Person("John",21), new Person("Sheeba",40), new Person("Michael",56),new Person("John",21));
		
		//Find Any only 
		//Filter filters a List
		
				Person person = personArray.stream()
						.filter(x -> "John".equals(x.getName()))
						.findAny()
						.orElse(null);
						
				System.out.println("Find Any " + person);
			
				
		//Map converts a Stream to a String
		String name = personArray.stream()
				.filter(x -> "John".equals(x.getName()))
				.map(Person::getName)
				.findAny()
				.orElse("");
		System.out.printf("result is %s\n",name);
				
		//Collect converts a Stream to a List again
		List<String> collection = personArray.stream()
				.filter(x -> "John".equals(x.getName()))
				.map(Person::getName)
				.collect(Collectors.toList());
				
		collection.forEach(s -> System.out.println(s));
		
		
		//Example of another stream IntStream
	int result =  IntStream.range(1, 4).map(i -> i*2).sum();
	System.out.print(result);
	
	
	
	 
		
		
	
				
	}
	

}
