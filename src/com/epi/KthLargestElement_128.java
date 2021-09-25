package com.epi;


/**
 * Incomplete
 */

import java.util.*;

public class KthLargestElement_128 {

    //The comparator
    private static class GreaterThan implements Comparator<Integer>{
        public int compare(Integer o1, Integer o2){
            return Integer.compare(o1,o2);
        }


    }

    public static final GreaterThan cmp = new GreaterThan();

    public static int findKthLargest(List<Integer> A, int k){


        int newPivotIdx=0;
        //Initialize the end
        int left =0;
        int right =A.size() -1;

        //A Random Pivot Initializer
        Random r = new Random(0);

        //Iteratively move from left to right
        while (left<= right) {
            int pivotIdx = r.nextInt(right - left + 1) + left;
            newPivotIdx = partitionAroundPivot(left, right, pivotIdx, A, cmp);
            if (newPivotIdx == k - 1) {
                return A.get(newPivotIdx);
            } else if (newPivotIdx > k - 1) {
                right = newPivotIdx - 1;
            } else {
                left = newPivotIdx + 1;
            }
        }
        return 1;
    }


    public static int partitionAroundPivot(int left, int right, int pivotIdx, List<Integer> A, KthLargestElement_128.GreaterThan cmp){

        int pivotValue = A.get(pivotIdx);

        //Reset the pivot to the left
        int newPivotIdx = left;

        //Swap the pivot with the right so that it can be compared
        Collections.swap(A,pivotIdx,right);
        for (int i= left; i< right ; ++i){
            if (cmp.compare(A.get(i),pivotValue)<0){
                Collections.swap(A,right, newPivotIdx++);
            }

        }
        Collections.swap(A,right, newPivotIdx);
        return newPivotIdx;
    }

    public static void main(String[] args) {
        System.out.println( 4>3?1 :-1);
    }
}
