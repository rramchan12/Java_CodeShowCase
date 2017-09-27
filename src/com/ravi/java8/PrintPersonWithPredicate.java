package com.ravi.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public  class PrintPersonWithPredicate {
	
	public  void printPersonConditionally(List<Person> personList, Predicate<Person> criteria){
		for (Person person: personList){
			if (criteria.test(person)){
				person.toString();
			}
		}
		
	}
	
	public static void main(String[] args) {
		List<Person> personArray= Arrays.asList(new Person("John",21), new Person("Sheeba",40), new Person("Michael",56),new Person("John",21));
		
		new PrintPersonWithPredicate().printPersonConditionally(personArray, p->p.getAge()>21);
	}
	

}
