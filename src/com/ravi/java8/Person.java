package com.ravi.java8;

public class Person {
	
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return System.out.printf("Name %s Age %d\n",this.name, this.age).toString();
	}

}
