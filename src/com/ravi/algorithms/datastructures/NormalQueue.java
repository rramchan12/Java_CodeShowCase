package com.ravi.algorithms.datastructures;

public class NormalQueue {
	
	int[] internalArray;
	int front = -1;
	int rear = -1;
	
	public NormalQueue(int size) {
		// TODO Auto-generated constructor stub
		internalArray = new int[size];
		front=rear =0;
	}
	
	public void enqueue(int value) throws Exception{
		if (!isFull()){
			internalArray[rear] = value;
			rear = rear+1;
		}
		else{
			throw new Exception("Queue is Full");
		}
	}
	
	public int dequeue(){
		int temp = front;
		front= front +1;
		return internalArray[temp];
		
	}
	
	public static void main(String[] args) throws Exception{
		NormalQueue queue = new NormalQueue(3);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		//queue.enqueue(4);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		//System.out.println(queue.dequeue());
	}
	
	private boolean isFull(){
		if (rear == (internalArray.length))
			return true;
		
		return false;
	}
	
	private boolean isInitialized(){
		if (front == -1 && rear == -1)
			return false;
					
		return true;
	}
	
	
	
}
