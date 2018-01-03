package com.ravi.algorithms.datastructures;

public class CircularQueue {
	
	int[] internalArray;
	int front = -1;
	int rear = -1;
	int size;
	
	public CircularQueue(int size) {
		// TODO Auto-generated constructor stub
		internalArray = new int[size];
		this.size=size;
		front=rear =0;
	}
	
	public void enqueue(int value) throws Exception{
		
			if (isEmpty())
				internalArray[rear] = value;
			else{
				
				internalArray[rear] = value;
			}
			
			rear = (rear + 1) % size;
	}
	
	public int dequeue(){
		int temp = front;
		front = (front -1 + size) % size;
		return internalArray[temp];
		
	}
	
	public static void main(String[] args) throws Exception{
		CircularQueue queue = new CircularQueue(3);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		//System.out.println(queue.dequeue());
	}
	
	
	
	private boolean isEmpty(){
		if (front == 0 && rear == 0)
			return true;
					
		return false;
	}
	
	
	
}

