package com.ravi.algorithms.datastructures;


import java.util.Stack;

/**
 * Reverse a stack using only push and pop operations
 * This is recursive and difficult
 */

public class ReverseStack {

    public static void reverseStack(Stack<Integer> stackToBeReversed){
        //If stack is empty exit
        if (stackToBeReversed.isEmpty())
            return;
        int temp = stackToBeReversed.pop();
        reverseStack(stackToBeReversed);
        pushAtBottom(temp, stackToBeReversed);

    }

    public static void  pushAtBottom(int element,Stack<Integer> stackToBeReversed){
        if (stackToBeReversed.isEmpty()) {
            stackToBeReversed.push(element);
            return;
        }
        int temp= stackToBeReversed.pop();
        pushAtBottom(element, stackToBeReversed);
        stackToBeReversed.push(temp);
    }


    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<Integer>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        reverseStack(myStack);
        System.out.println(myStack);
    }
}
