package com.ravi.codeproblems;

import java.util.Arrays;
import java.util.Stack;

public class Span_Problem {


     static void calculateSpan(int[] price, int n, int S[]) {
        //The first Element Span is always 1
        S[0] = 1;
        //Calculate the span of the remaining days by checking linearly when the price increases beyond the current point
        for (int i = 1;  i<n;i++){
            S[i] = 1;
            //Traverse the left while the element on the left is smaller than the price
            for (int j = i - 1; (j >= 0) && (price[i] >= price[j]); j--) {
                S[i]++;
            }

        }
    }

      static void printArray(int arr[]){
         System.out.println(Arrays.toString(arr));
      }


      static void calculateSpanStack(int price[], int n, int S[]){
            Stack<Integer> myStack  = new Stack<> () ;
            myStack.push(0);

            //Span of the first element is always 1
          S[0] = 1;

          for (int i=0; i<n; i++){
              //pop elements from stack
              //while stack is not empty and top of stack is smaller than price[i]
              while (!myStack.isEmpty() && price[myStack.peek()] <= price[i])
                  myStack.pop();

              S[i]= (myStack.empty()? (i+1): i- myStack.peek());

              //push this element to stack
              myStack.push(i);
          }
      }

    public static void main(String[] args) {
        int price[] = {10,4,5,90,120,80};
        int n = price.length;
        int S[]= new int[n];

       //calculateSpan(price,n, S);
        calculateSpanStack(price, n, S);
        printArray(S);

    }
}