package com.ravi.codeproblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.
 *
 * Sample Input:
 *
 * [3 4 1 4 1]
 * Sample Output:
 *
 * 1
 * If there are multiple possible answers ( like in the sample case above ), output any one.
 *
 * If there is no duplicate, output -1
 */
public class RepeatedValueArray {

    /**
     *
     * We will utilize the return value of HashMap for this. If the value is already present in the HashMap then
     * it will return the previous value else it will retun null
     * If we create a HashMap <ArrayValue, ArrayPosition>  then if the Value is already present the position will
     * not be null
     * @param A
     * @return
     */
    public int repeatedNumber(final List<Integer> A) {
        //We will copy everything to a HashMap
        HashMap<Integer, Integer> integerMap = new HashMap();
        Integer duplicate_int = null;
        Integer counter = 0;
        for (Integer element : A) {
            Integer int_return = integerMap.put(element, ++counter);
            if (int_return != null)
                duplicate_int= element.intValue();


        }
        return duplicate_int;
    }

    public static void main(String[] args) {
        List duplicateIntegerList = Arrays.asList(3, 4, 1, 4, 1);
        System.out.println(new RepeatedValueArray().repeatedNumber(duplicateIntegerList));
    }
}
