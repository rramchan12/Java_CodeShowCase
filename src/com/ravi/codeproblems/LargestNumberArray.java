package com.ravi.codeproblems;

import java.util.Arrays;
import java.util.List;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * For example:
 *
 * Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 *Given [0, 0, 0, 0, 0], the largest formed number is 0.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumberArray {

    //Create a Container Class to hold the Numbers so that we can utilize the mergeSort Method of Collections using Arrays.sort
    private class Container implements Comparable<Container>{

        String element;

        Container(Integer element){
            this.element = String.valueOf(element);
        }


        @Override
        public int compareTo(Container second) {
           String first_cat = this.element + second.element;
           String second_cat = second.element + this.element;

           return  second_cat.compareTo(first_cat);
        }
    }
    public  String largestNumber(final List<Integer> A) {

        StringBuffer returnString = new StringBuffer();
        //Box the Integer Arrays in a container so that we can use Array Sorting
        Container[] listContainer =new Container[A.size()];
        //Add each element to the Container Array
        int i=0;
        for (Integer element : A){
            listContainer[i++] = new Container(element);
        }
         //Sort the Arrays
        Arrays.sort(listContainer);


        //if the first element of the array is 0, the all the ones post that will also be 0
        //so return 0
        if (listContainer[0].element.equals("0"))
            return "0";
        else {

            //Convert the Arrays to a string which can be returned

            for (Container n : listContainer) {
                returnString.append(n.element);
            }
            return returnString.toString();
        }
    }

    public static void main(String[] args) {
        List intList = Arrays.asList(3, 30, 34, 5, 9);
        System.out.println( new LargestNumberArray().largestNumber(intList));

        List intList1 = Arrays.asList(0, 0, 0, 0, 0);
        System.out.println( new LargestNumberArray().largestNumber(intList1));

        List intList2 = Arrays.asList(191, 608, 79, 111, 688, 930, 504, 878, 883, 684, 157, 670, 447, 720, 147, 728, 540, 160, 668, 897, 746, 367, 194, 425, 625, 17, 876, 625, 785, 278, 699, 141, 219, 857, 51, 611, 299, 279, 562, 64, 577);
        System.out.println( new LargestNumberArray().largestNumber(intList2));
    }



}
