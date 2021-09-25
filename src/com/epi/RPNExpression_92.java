package com.epi;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Expression will be on type "3,4,+,2,X,1,+"
 */
public class RPNExpression_92 {

    public static int evaluateRPNExpression(String expression){
        Deque<Integer> intermediateResults = new LinkedList<>();
        String delimiter = ",";
        String[] symbols = expression.split(delimiter);
        for (String token:symbols){
            //Figure out if the token is an operant
            if (token.length() ==1 && "+-/*".contains(token)){
                //Pop out the last two integers from stack
                final int y = intermediateResults.removeFirst();
                final int x = intermediateResults.removeFirst();
                switch (token.charAt(0)) {
                    case '+':
                        intermediateResults.addFirst(x+y);
                        break;
                    case '-':
                        intermediateResults.addFirst(x-y);
                        break;
                    case '*':
                        intermediateResults.addFirst(x*y);
                        break;
                    case '/':
                        intermediateResults.addFirst(x/y);
                        break;
                    default :
                        throw new IllegalArgumentException(token);

                }
            }
            else{
                //This is a number which we will stack
                intermediateResults.addFirst(Integer.parseInt(token));
            }

        }
        return intermediateResults.removeFirst();
    }

    public static void main(String[] args) {
        System.out.println(evaluateRPNExpression("3,4,+,2,*,1,+"));

    }
}
