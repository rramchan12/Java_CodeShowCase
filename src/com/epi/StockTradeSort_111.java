package com.epi;

import java.util.*;

/**
 *
 * We can think about the stock trade like an array
 * ArrayID is the key and Array Value is the index
 */
public class StockTradeSort_111 {

    private static class ArrayEntry{
        public Integer value;
        public Integer arrayID;

        public ArrayEntry(Integer value, Integer arrayID){
            this.value = value;
            this.arrayID = arrayID;
        }

        @Override
        public String toString() {
            return "Value : "+value+":ID : "+arrayID;
        }

    }

    public static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays){
        List<Iterator<Integer>> iters = new ArrayList<>(sortedArrays.size());

        for (List<Integer> array : sortedArrays){
            iters.add(array.iterator());
        }

        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(
                sortedArrays.size(),new Comparator<ArrayEntry>() {


            @Override
            public int compare(ArrayEntry o1, ArrayEntry o2) {
                return Integer.compare(o1.value, o2.value);
            }


        });

        //This is a min heap of size = no of sequences
        for (int i=0; i< iters.size(); ++i){
            if (iters.get(i).hasNext()){
                minHeap.add(new ArrayEntry(iters.get(i).next(),i));
            }



        }
        System.out.println("Size"+minHeap.size());
        System.out.println("Size"+minHeap.toString());

        //Creating the output list
        List<Integer> resultList = new ArrayList<>();
        while (!minHeap.isEmpty()){
            ArrayEntry headEntry = minHeap.poll();
            resultList.add(headEntry.value);
            if (iters.get(headEntry.arrayID).hasNext()){
                minHeap.add(new ArrayEntry(iters.get(headEntry.arrayID).next(),headEntry.arrayID));
            }
        }
        return resultList;
    }

    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(3,5,7);
        List<Integer> list2 = Arrays.asList(0,6);
        List<Integer> list3 = Arrays.asList(0,6,28);
        List<List<Integer>> sortedArrays = new ArrayList();
        sortedArrays.add(list1);
        sortedArrays.add(list2);

        System.out.println(mergeSortedArrays(sortedArrays));
    }

}
