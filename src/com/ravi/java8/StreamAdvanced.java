package com.ravi.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class StreamAdvanced {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  // filterFirstTwoMeatDishes(Dish.menu).forEach(System.out::println);
	   //returnSquare(Arrays.asList(1,2,3,4,5)).forEach(System.out::println);
	   returnPairs(Arrays.asList(1,2,3,4,5),Arrays.asList(1,2,3,4,5)).forEach(x -> System.out.println("{" + x[0]+","+x[1]+"}"));
	   System.out.println("IsCalories>1000 : " +isCaloriesGt1000(Dish.menu));
	   System.out.println("Foods with Calories>1000 : " +findCaloriesGt1000(Dish.menu).get().getName());
	   System.out.println("Number of Dishes : " +  findNumberofDishes(Dish.menu));
	   System.out.println("Dish with max calories : " +  findMaxCalorieDishe(Dish.menu).get().getName());
	   generatePythogoranTriples().limit(5)
			   .forEach(t -> System.out.println("{" + t[0]+ "," + t[1] +","+ t[2]+"}"));
	}
	
	/*Filter only First 2 meat Dishes */
	public static List<Dish> filterFirstTwoMeatDishes(List<Dish> dishes){
		return dishes.stream().filter(x-> !x.isVegetarian()).limit(2).collect(Collectors.toList());
	}
		
	/*Mapping - Given a list of numbers return a List of Square of each number */
	
	public  static List<Double>  returnSquare(List<Integer> inputNumbers){
		
		return inputNumbers.stream().map(x -> Math.pow(x,2)).collect(Collectors.toList());
	
	/*
	 * . Given two lists of numbers, how would you return all pairs of numbers? For example, given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. 
	 * For simplicity, you can represent a pair as an array with two elements.
	 */
	}
    public static List<int[]> returnPairs(List<Integer> firstList, List<Integer> secondList){
    	
    	return firstList.stream().flatMap(i -> secondList.stream().map(j -> new int[]{i,j})).collect(Collectors.toList());
    	
    }
		
    /*Matching
     * 
     * anyMatch
     * noneMatch
     * allMatch
     * These are Predicate Functions which only returns boolean
     * These are also shortciruiting operators - They dont process the whole stream
     */
    public static boolean isCaloriesGt1000(List<Dish> dishes ){
    	return dishes.stream().allMatch(x -> x.getCalories() >100);
    }
    
    
	/*Finding 
	 * findOne
	 * findAny
	 * Find any dish >1000 calories
	 */
    public static Optional<Dish> findCaloriesGt1000(List<Dish> dishes ){
    	return dishes.stream().filter(x -> x.getCalories() >100).findAny();
    }

    
    /*
     * Reduction is like folding
     * Find number of dishes in the menu
     */
    
    public static Integer findNumberofDishes(List<Dish> dishes){
    	//return dishes.stream().map(x -> 1).reduce(0,(x,y) -> x+y);
    	//Parallelism
    	return dishes.parallelStream().map(x -> 1).reduce(0,(x,y) -> x+y);
    }
    
    /*Find the max value*/
    public static Optional<Dish> findMaxCalorieDishe(List<Dish> dishes){
    	//return dishes.stream().map(x -> 1).reduce(0,(x,y) -> x+y);
    	//Parallelism
    	return dishes.stream().reduce((d1,d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2);
    }
    
    
    /*IntStream (rangeClosed, boxed, mapToObject, flatMap etc)
     * Generate a set of Pythagoram Triples for the numbers 0-100 in an IntArray Format 
     * eg : 3, 4, 5
		5, 12, 13
		6, 8, 10
		7, 24, 25
		8, 15, 17
     */
    
    public static Stream<int[]> generatePythogoranTriples(){
    	return IntStream.rangeClosed(1,100).boxed().flatMap(a -> IntStream.rangeClosed(a, 100)
    			.filter(b -> Math.sqrt(a*a + b*b)% 1 ==0)
    			.mapToObj(b-> new int[]{a,b, (int)Math.sqrt(a*a + b*b)})
    			);
    }
    }
