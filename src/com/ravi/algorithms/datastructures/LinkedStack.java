package com.ravi.algorithms.datastructures;


import java.util.List;

import static java.lang.System.exit;

public  class LinkedStack<T> {


    private class ListNode{
        int data;
        ListNode link;
    }
    private ListNode  top;
    private int length;


    public void push(int data){


        ListNode temp = new ListNode();

        if (temp==null)
            System.out.println("Stack Overflow\n");
        temp.data = data;
        temp.link = top;
        top = temp;

    }

    public void pop(){
        if (top==null) {
            System.out.println("\nStack Underflow");
            return;
        }
        top = top.link;


    }

    public void display() {
        //Check for underflow
        if (top == null) {
            System.out.println("\nStack Underflow");
            exit(1);
        }
        else{
            ListNode temp = top;
            while (temp!=null){
                System.out.println(temp.data);
                temp = temp.link;
            }
        }
    }

    public static void main (String[] args){

        LinkedStack stack = new LinkedStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.display();
        stack.pop();
        stack.display();

    }





}