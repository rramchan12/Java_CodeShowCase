package com.ravi.mathproblems;

/**
 *
 * Given an integer A, return the number of trailing zeroes in A!.
 *
 * Note: Your solution should be in logarithmic time complexity.
 *
 *
 *
 * **Problem Constraints**
 * 1 <= A <= 10000
 *
 *
 *
 * **Input Format**
 * First and only argumment is integer A.
 *
 *
 *
 * **Output Format**
 * Return an integer, the answer to the problem.
 *
 *
 *
 * **Example Input**
 * Input 1:
 *
 *  A = 4
 * Input 2:
 *
 *  A = 5
 *
 *
 * **Example Output**
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  1
 *
 *
 * **Example Explanation**
 * Explanation 1:
 *
 *  4! = 24
 * Explanation 2:
 *
 *  5! = 120
 */
public class TrailingZeroInFactorial {


        public int trailingZeroes(int A) {

            return 1;

        }

        private int tailRecursiveFactorial(int number){
            if (number==0)
                    return 1;
            else {
                    return number * tailRecursiveFactorial(number - 1);
            }


        }


    public static void main(String[] args) {
        System.out.printf("Factorial for %d is %d",3,new TrailingZeroInFactorial().tailRecursiveFactorial(3));
    }
}
