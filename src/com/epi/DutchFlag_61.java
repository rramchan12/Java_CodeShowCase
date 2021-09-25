package com.epi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.epi.DutchFlag_61.Color.*;

public class DutchFlag_61 {

    public static enum Color {RED,WHITE, BLUE}

    static List<Color> A = Arrays.asList( WHITE, RED,WHITE,WHITE, BLUE,WHITE,RED);


     //The space complexity of this is O(1) but the Time Complexity is O(n2)
    public static void dutchFlagPartition(int pivotIndex, List<Color> A){
        //System.out.println("Index"+ pivotIndex);

        Color pivot = A.get(pivotIndex);
        System.out.println("pivot color"+pivot);

        //First pass get elements less than the pivot
        for (int i=0; i<A.size(); ++i){
            for (int j =i; j<A.size(); ++j){
                if (A.get(j).ordinal()< pivot.ordinal()){
                    Collections.swap(A,i,j);
                    break;
                }
            }
        }
        System.out.println("first pass"+A);
        System.out.println(A.get(pivotIndex).ordinal() );


        //Second pass : group elements larger than the pivot
        //Stop when we reach an element less than the pivot as all the elements less than pivot have already moved to the lef
        for (int i = A.size()-1; i >= 0 && A.get(i).ordinal() >= pivot.ordinal(); --i){
            for (int j=i-1; j>=0 && A.get(j).ordinal() >= pivot.ordinal();--j){
                if (A.get(j).ordinal()>pivot.ordinal()) {
                    Collections.swap(A, i, j);
                    break;
                }
            }
        }
        System.out.println("Second Pass"+A);
    }


    /**
     * This is done using O(n) Time Complexity and O(1) Space Complexity (In Place)
     * @param pivotIndex
     * @param A
     */
    public static void dutchFlagPartition_1(int pivotIndex, List<Color> A){
        int smaller =0;
        int larger = A.size()-1;
        Color pivot = A.get(pivotIndex);
        System.out.println("pivot color"+pivot);
        for (int i = 0 ; i < A.size() ; ++i){
                if(A.get(i).ordinal() < pivot.ordinal()){
                    Collections.swap(A,smaller++,i);
                }
        }
        System.out.println("First Pass"+A);

        for (int i=A.size()-1; i>=0 && A.get(i).ordinal() >= pivot.ordinal();--i){
            if(A.get(i).ordinal()>pivot.ordinal()){
                Collections.swap(A,larger--,i);
            }
        }
        System.out.println("Second Pass"+A);

    }
    public static void main(String[] args) {
        //dutchFlagPartition(2, A);
        dutchFlagPartition_1(2,A);

    }

}
