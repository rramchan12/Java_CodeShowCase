package com.ravi.codeproblems;

import java.util.Arrays;
import java.util.List;

public class LargestSumContinguousSubarray {

    /**
     * Find the contiguous subarray within an array, A of length N which has the largest sum.
     * Input 1:
     *     A = [1, 2, 3, 4, -10]
     *
     * Output 1:
     *     10
     *
     * Explanation 1:
     *     The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
     *
     * Input 2:
     *     A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
     *
     * Output 2:
     *     6
     *
     * Explanation 2:
     *     The subarray [4,-1,2,1] has the maximum possible sum of 6.
     * Input 2:
     *     A = [-2, -1, -3, -5, -1, -2, -1, -5, -4]
     *
     * Output 2:
     *      -1
     *
     * Explanation 2:
     *     The subarray [4,-1,2,1] has the maximum possible sum of 6.
     * @param A
     * @return
     */
    public static int maxSubArray(final List<Integer> A){

        // Variable to store the total of digits one after another
        int max_ending_here =0;
        // Variable to store the max total got until now
        // When we find a max we will store it here
        int max_until_now=0;

        //We will iniitialize the max_until_flat to the initial flag using this flip
        boolean is_all_negative = true;
        boolean is_first_negative = true;
        int max_until_now_is_all_negative = 0;

        for(Integer element: A){
            max_ending_here = element+max_ending_here;

            if (is_all_negative) {
                if (element < 0 && is_first_negative) {
                    //For the first negative element initialize the variable
                    is_first_negative = false;
                    max_until_now_is_all_negative = element;

                } else if (element < 0 && !is_first_negative) {
                    //For all subsequent negative elements only if the current element is bigger store the same
                    if (max_until_now_is_all_negative < element)
                        max_until_now_is_all_negative = element;

                } else if (element > 0)
                    //The moment we find the first positive element we can quit this loop
                    is_all_negative = false;
            }


            if (max_ending_here <0)
                max_ending_here =0;

            if (max_until_now< max_ending_here)
                max_until_now = max_ending_here;


        }

        if (is_all_negative)
                return max_until_now_is_all_negative;
        return max_until_now ;

    }

    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(1,2,3,4,-10);
        System.out.println(maxSubArray(myList));


        List myList1 = Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4);
        System.out.println(maxSubArray(myList1));

        List myList2 = Arrays.asList(-2, -1, -3, -5, -1, -2, -1, -5, -4);
        System.out.println(maxSubArray(myList2));
    }
}
