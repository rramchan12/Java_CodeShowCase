package com.epi;

import java.util.*;

/**
 * Heaps are called Priority Queues in the Java World
 * The creation complexity O(nlogn)
 * Very simple to do when you are interested in the top largest and top smallest
 */
public class TopKHeap_111 {


    /*
    Write a program which takes a sequence of strings in streaming fashion(cannot back up or read earlier value)
    Program finds the K Longest Strings (Order of the Strings is not important)
     */

    public static List<String> topK(int k, Iterator<String> iter){
        PriorityQueue<String> minHeap = new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        while (iter.hasNext()){
            minHeap.add(iter.next());
            if (minHeap.size()>k){
                //Remove the shortest string
                minHeap.poll();
            }
        }

        return new ArrayList<>(minHeap);
    }


    public static void main(String[] args) {
        List<String> nonOrdered = Arrays.asList("one", "twoo", "fiveee", "sixxxxxx", "threee");
        System.out.println(topK(3,nonOrdered.iterator()));
    }

}
