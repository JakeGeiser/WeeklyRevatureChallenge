package weeklychallange.week1;

import java.util.ArrayList;
import java.util.HashSet;

public class Week1 {
	
	public static void main(String[] args) {
		
		// (1) magic index problem
		System.out.println("(1) Magic Index");
		int[] array1 = new int[] {0,1,2,3,4,5,6};
		int[] array2 = new int[] {0,1,1,1,2,3,6};	
		
		System.out.println(magicIndex(array1).toString()); // [0,1,2,3,4,5,6]
		System.out.println(magicIndex(array2).toString()); // [0,1,6]
		
		// (2) Power Sets
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("(2) Power Sets");
		int[] array3 = new int[] {1,4,8};
		ArrayList<HashSet<Integer>> powerSets = getPowerSets(array3);
		for(HashSet<Integer> set : powerSets) {
			System.out.println(set.toString());
		}
			
		// (3) Recursive Multiply
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("(3) Recursive Multiplication");
		System.out.println(multiply(6,5));
		
		
		
	}
	
	/**
	 * 1) Magic Index: A magic index in an array A [ 0 ... n -1] is defined to be an index such that A[i] = i. 
	 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
	 * 
	 * Follow up: What if the values are not distinct?
	 * 
	 * @param sortedArray - sorted int array
	 * @return Integer arrayList of all magic indexes
	 */
	public static ArrayList<Integer> magicIndex(int[] sortedArray) {
		
		ArrayList<Integer> magicIndecies = new ArrayList<>();
		
		for(int i=0; i < sortedArray.length; i++) {
			if(i == sortedArray[i]) {
				magicIndecies.add(i);
			}
		}
		
		return magicIndecies;
		
	}
	
	/**
	 * 2) Power Set: Write a method to return all subsets of a set.
	 * 
	 * @param array - int array to find subsets of
	 * @return each unique subsubset in an arrayList
	 * 
	 * Solution could use recursion, but I wanted to learn a new solution so I found this
	 * from geeksforgeeks.org/power-set/ but modified to store the solutions
	 */
	public static ArrayList<HashSet<Integer>> getPowerSets(int[] set){
		
		ArrayList<HashSet<Integer>> allSubsets = new ArrayList<HashSet<Integer>>();
		if(set.length == 0) {
			allSubsets.add(new HashSet<Integer>());
			return allSubsets;
		}
		
		HashSet<Integer> addSet;
		
		for(int i=0; i< Math.pow(2, set.length); i++) {
			addSet = new HashSet<Integer>();
			
			for(int j=0; j<set.length; j++) {
				if((i & (1<<j)) > 0) {
					addSet.add(set[j]);
				}
			}
			
			allSubsets.add(addSet);
		}
		
		return allSubsets;
		
	}
	
	/**
	 * 3) Recursive Multiply: Write a recursive function to multiply two positive integers without 
	 * using the *operator. You can use addition, subtraction, and bit shifting, but you should 
	 * minimize the number of those operations.
	 * 
	 * @param a - larger value being multipled
	 * @param b - smaller or same value to a to be multiplied (ensures faster runtime from recursion)
	 * @return product of a and b
	 */
	public static int multiply(int a, int b) {

		if(b==0) {return 0;}
		if(b==1) {return a;}
		
		return a + multiply(a,--b);
	}
}

/**
 * BELOW IS THE PRINT OUTPUTS FROM MAIN METHOD
 */
//(1) Magic Index
//[0, 1, 2, 3, 4, 5, 6]
//[0, 1, 6]
//
//
//
//(2) Power Sets
//[]
//[1]
//[4]
//[1, 4]
//[8]
//[1, 8]
//[4, 8]
//[1, 4, 8]
//
//
//
//(3) Recursive Multiplication
//30




