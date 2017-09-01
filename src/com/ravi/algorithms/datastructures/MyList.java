package com.ravi.algorithms.datastructures;

import java.util.Arrays;

public class MyList<E> {
	
	private Object[] elements;
	private int size =0;
	private static final int DEFAULT_SIZE = 10;
	
	
	public MyList() {
		// TODO Auto-generated constructor stub
		elements = new Object[DEFAULT_SIZE];
	}
	
	public boolean add(E e){
		if (size == elements.length){
			this.increaseCapacity();
		}
		elements[size++] = e;
		return true;
	}
	
	private void increaseCapacity(){
		int new_size = elements.length *2;
		elements = Arrays.copyOf(elements, new_size);
		
	}
	
	public E get(int i){
		if (i>size || i <0 ){
			throw new ArrayIndexOutOfBoundsException();
		}
		return (E) elements[i];
	}
	
	public static void main(String[] args) {
		MyList<String> myList = new MyList<String>();
		myList.add("1");
		myList.add("2");
		
		System.out.println(myList.get(1));
	}

}
