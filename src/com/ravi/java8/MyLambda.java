package com.ravi.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;

/*
 * Lambdas can only be run on Functional Interfaces
 * In Java, a functional interface is basically an interface with a single abstract method. 
 * This kind of interfaces are also known as SAM (Single Abstract Method) types.
 */
public class MyLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sayable myImpl = (name)->{ return "Hello " + name;
		};
		Sayable myImplFrench = (name) -> {return "Bonjour " + name;};
		System.out.println(myImpl.sayNicely("ravi"));
		System.out.println(myImplFrench.sayNicely("ravi"));
		
		//On Threads
		
		Runnable r = () -> { System.out.println(Thread.currentThread().getName());};
		Executors.newFixedThreadPool(10).execute(r);
		
		//On comparators 
		
		List<Integer> myList = Arrays.asList(100,3,45);
		System.out.println(myList);
		Collections.sort(myList, (p1,p2)->{ 
			return p2-p1; 
		});
		System.out.println(myList);
		

		
	}
	
	
}
