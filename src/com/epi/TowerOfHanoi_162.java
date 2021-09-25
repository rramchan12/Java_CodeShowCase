package com.epi;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TowerOfHanoi_162 {

    private static final int NO_OF_PEGS =3;

    private static void computeTowerOfHanoi(int noOfRings){
        //Data Set for Storing the Tower
        List<Deque<Integer>> pegs  = new ArrayList<>();
        for (int i=0;i<NO_OF_PEGS;++i){
            pegs.add(new LinkedList<Integer>());
        }

        //Initialize the tower
        for (int i= noOfRings;i>=1;--i){
            pegs.get(0).addFirst(i);
        }
        int counter=1;
        for (Deque peg : pegs){
            System.out.println(counter++);
            System.out.println(peg);
        }

        computeTowerOfHanoiSteps(pegs, 0,1,2, noOfRings);
    }

    public static void computeTowerOfHanoiSteps(List<Deque<Integer>> pegs, int fromPeg, int toPeg,
                                                int usingPeg, int numberOfRingsToMove){

        if (numberOfRingsToMove>0) {
            computeTowerOfHanoiSteps(pegs, fromPeg, usingPeg,toPeg, numberOfRingsToMove - 1);
            pegs.get(toPeg).addFirst(pegs.get(fromPeg).removeFirst());
            System.out.println("Move from peg " + fromPeg + "to Peg" + toPeg);
            computeTowerOfHanoiSteps(pegs, usingPeg, toPeg, fromPeg,numberOfRingsToMove-1);
        }

       //print results
        int counter=1;
       for (Deque peg : pegs){
           System.out.println(counter++);
           System.out.println(peg);
       }
    }

    public static void main(String[] args) {
        computeTowerOfHanoi(5);
    }
}
