package com.ravi.codeproblems;

import java.util.Arrays;

public class Maxima {


    public static void main (String[] args){

        findMaxima(new Integer[]{1,1,2,2,2,3,3,4,6,7});

    }

    static void findMaxima(Integer[] priceArr){

        int size = priceArr.length;
        int curr = 0;
        int maxima=0;
        int maxima_value= 0;
        int next = 1;
        for (int i=0; i<size ; i++){
            int temp_maxima=0;
            if (priceArr[curr]==priceArr[next]) {
                temp_maxima++;

            }
            else{
                continue;
            }

        }
    }
}
