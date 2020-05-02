package com.ravi.codeproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralArray {


    static public Integer[][] convertLoLToArray(List<List<Integer>> matrix){
        Integer inputArray[][] = new Integer[matrix.size()][matrix.get(0).size()];
        int row=0;
        for (List<Integer> rowElement : matrix){

            int column=0;
            for (Integer element : rowElement){
                inputArray[row][column] = element;
                column++;
            }
            row++;

        }

        System.out.println(inputArray);
        return inputArray;
    }

    /**
     * The main method that takes a Matrix
     * @param matrix 2 dimensional Array
     *
     */
    static void printSpiralArray(List<List<Integer>> matrix){
        Integer[][] twoDArray = convertLoLToArray(matrix);
        /**
         * Define four variables
         * top
         * bottom
         * left
         * right
         *
         */
        int top= 0;
        int bottom = twoDArray.length-1;
        int left = 0 ;
        int right = twoDArray[0].length-1;

        while (top<= bottom &&  left <=right){
            for (int column = left; column <= right; ++column){
                System.out.println(twoDArray[top][column]);
            }
            top++;
            for (int row=top; row<=bottom; ++row){
                System.out.println(twoDArray[row][right]);
            }
            right--;
            for (int column = right; column>=left; --column){
                System.out.println(twoDArray[bottom][ column]);
            }
            bottom--;
            for (int row = bottom; row>=top; --row){
                System.out.println(twoDArray[row][left]);
            }
            left++;
        }
    }

    public static void main(String[] args) {
        List<Integer> firstRow = Arrays.asList(1,2);
        List<Integer> secondRow = Arrays.asList(3,4);
        List <Integer> thirdRow = Arrays.asList(5,6);

        List<List<Integer>> matrix= new ArrayList();
        matrix.add(firstRow);
        matrix.add(secondRow);
        matrix.add(thirdRow);

        printArray(convertLoLToArray(matrix));
        printSpiralArray(matrix);

    }


    public static void printArray (Integer matrix[][]){
        int num_of_rows = matrix.length;
        int num_of_columns = matrix[0].length;

        for (int i =0 ; i<num_of_rows; i ++){
            for (int j=0; j< num_of_columns; j++){
                System.out.printf( "[ %d %d] : %d \n", i, j, matrix[i][j]);
            }

        }

    }
}
