package com.ravi.codeproblems;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
 *
 * The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
 *
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
 *
 * Find and return the required subarray.
 *
 *      1. If there is a tie, then compare with segment's length and return segment which has maximum length.
 *     2. If there is still a tie, then return the segment with minimum starting index.
 *
 *     Input 1:
 *     A = [1, 2, 5, -7, 2, 3]
 *
 * Output 1:
 *     [1, 2, 5]
 *
 * Explanation 1:
 *     The two sub-arrays are [1, 2, 5] [2, 3].
 *     The answer is [1, 2, 5] as its sum is larger than [2, 3].
 *
 * Input 2:
 *     A = [10, -1, 2, 3, -4, 100]
 *
 * Output 2:
 *     [100]
 *
 *  Input 3:
 *      A = [0,0, -1, 0]
 *
 *  Output 3:
 *      [0,0]
 *
 *  Input 3:
 *  *      A = [1,2, -1, 2,1]
 *  *
 *  *  Output 3:
 *  *      [1,2]
 *
 * Explanation 2:
 *     The three sub-arrays are [10], [2, 3], [100].
 *     The answer is [100] as its sum is larger than the other two.
 */
public class MaxNonNegativeSubArray {
    /**
     * @param A
     * @return maxSub Arrray
     */
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        //This will be used to total the values till now
        Long max_until_now = 0L;
        //This will store the max of the total found until now
        Long max_total_found = 0L;
        //This list will temporarilty store the max continuous array
        List<Integer> subsetList = new ArrayList();
        //This list will store the max Subset List
        ArrayList<Integer> maxSubsetList = new ArrayList();
        //For handling ties we will also store the starting index
        int index=0;
        int listStartingIndex=0;
        int maxListStartingIndex=0;

        for (Integer element : A) {
            index++;
            max_until_now += element;
            subsetList.add(element);

            if (element < 0) {
                subsetList.clear();
                max_until_now = 0L;
                listStartingIndex = index;
            } else if (max_total_found < max_until_now) {

                max_total_found = max_until_now;
                maxSubsetList.clear();
                maxSubsetList.addAll(subsetList);
                maxListStartingIndex = listStartingIndex;

            } else if (max_total_found == max_until_now){
               // If there is a tie, then compare with segment's length and return segment which has maximum length.if
                if (subsetList.size() > maxSubsetList.size()) {
                    maxSubsetList.clear();
                    maxSubsetList.addAll(subsetList);
                }
                else if (subsetList.size() == maxSubsetList.size()){
                   // If there is still a tie, then return the segment with minimum starting index.
                    if (listStartingIndex < maxListStartingIndex){
                        maxSubsetList.clear();
                        maxSubsetList.addAll(subsetList);
                    }
                }
            }


        }
        return maxSubsetList;
    }

    public static void main(String[] args){
        ArrayList<Integer> inputList = new ArrayList<Integer>();
        inputList.addAll(Arrays.asList(0,0, -1, 0));
        System.out.println(new MaxNonNegativeSubArray().maxset(inputList));

        inputList.clear();
        inputList.addAll(Arrays.asList(1967513926, 1540383426, -1303455736, -521595368));
        System.out.println(new MaxNonNegativeSubArray().maxset(inputList));


    }
}
