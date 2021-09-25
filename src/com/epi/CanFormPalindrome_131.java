package com.epi;

import java.util.HashMap;
import java.util.Map;

public class CanFormPalindrome_131 {

    /**
     * A Palindrome is a string that reads both forwards and backwards
     * Write a program to test whether the letters of a string can be permuted to form a palindrome
     * @param testString
     * @return
     */
    public static boolean canFormPalindrome(String testString){

        Map<Character,Integer> charFrequencies = new HashMap<>();

        //First store all the elements of the String in a HashMap
        for (int i=0 ; i < testString.length(); ++i){
            Character c = testString.charAt(i);
            if (charFrequencies.containsKey(c)){
                charFrequencies.put(c,charFrequencies.get(c)+1);

            }
            else{
                charFrequencies.put(c,1);
            }
        }

        //If the total length = odd, max one odd character is tolerated
        //If the total length = even, no odd characters are tolerated
        int oddCount =0;
        for (Map.Entry<Character,Integer> p: charFrequencies.entrySet()){
                if(p.getValue() % 2 !=0 && ++oddCount>1){
                    return false;
                }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canFormPalindrome("ramram"));
        System.out.println(canFormPalindrome("ramrama"));
        System.out.println(canFormPalindrome("ramramab"));

        int i=0;
        System.out.println(i++);

    }


}
