package weeklychallange.week2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Week2 {

	public static void main(String[] args) {
		
		// (1) LinkedList Sum
		LinkedList<Integer> l1 = new LinkedList<>();
		LinkedList<Integer> l2 = new LinkedList<>();
		LinkedList<Integer> l3 = new LinkedList<>();
		LinkedList<Integer> l4 = new LinkedList<>();
		
		l1.add(7); l1.add(1); l1.add(6);
		l2.add(5); l2.add(9); l2.add(2);
		l3.add(6); l3.add(1); l3.add(7);
		l4.add(2); l4.add(9); l4.add(5);
		
		Iterator<Integer> reverseResult = linkedListSumReverse(l1,l2).iterator();
		Iterator<Integer> normalResult = linkedListSum(l3,l4).iterator();
		
		System.out.println("Reverse Sum");
		while(reverseResult.hasNext()) {
			System.out.print(reverseResult.next()); // 219
		}
		System.out.println(); 
		
		System.out.println("Normal Sum");
		while(normalResult.hasNext()) {
			System.out.print(normalResult.next()); // 912
		}
		
		
		// (2) Stack Min
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Stack Min");
		MyStack stack = new MyStack();
		stack.push(10);
		stack.push(3);
		stack.push(8);
		
		System.out.println(stack.min() + " is the min"); // 3 is the min
		System.out.println(stack.pop() + " is removed"); // 8 is removed
		System.out.println(stack.pop() + " is removed"); // 3 is removed
		System.out.println(stack.min() + " is the min"); // 10 is the min

	}
	
	/**
	 * 1) Sum Lists: You have two numbers represented by a linked list, where each node contains a single
	 * digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
	 * function that adds the two numbers and returns the sum as a linked list.

	 * EXAMPLE
	 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
	 * Output: 2 -> 1 -> 9. That is, 912.
	 * 
	 * @param l1 - LinkedList to be added
	 * @param l2 - LinkedList to be added
	 * @return LinkedList to represent reverse of sum of L1, L2
	 */
	public static LinkedList<Integer> linkedListSumReverse(LinkedList<Integer> l1, LinkedList<Integer> l2){
		
		int sum = 0;
		Iterator<Integer> it1 = l1.iterator();
		Iterator<Integer> it2 = l2.iterator();
		
		int count = -1;
		
		while(it1.hasNext() && it2.hasNext()) {
			count++;
			sum += it1.next()*Math.pow(10, count); // add based off proper magnitude
			sum += it2.next()*Math.pow(10, count);
		}
		
		String stringSum = String.valueOf(sum);
		LinkedList<Integer> result = new LinkedList<>();
		
		for(int i=0; i<stringSum.length(); i++) {
			result.addFirst(Integer.parseInt(String.valueOf(stringSum.charAt(i))));
		}
		
		return result;
	}
	
	/**
	 * FOLLOW UP
	 * Suppose the digits are stored in forward order. Repeat the above problem.
	 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
	 * Output: 9 -> 1 -> 2. That is, 912.
	 * 
	 * @param l1 - LinkedList to be added
	 * @param l2 - LinkedList to be added
	 * @return LinkedList representation of sum
	 */
	public static LinkedList<Integer> linkedListSum(LinkedList<Integer> l1, LinkedList<Integer> l2){
		
		int sum = 0;
		Iterator<Integer> it1 = l1.iterator();
		Iterator<Integer> it2 = l2.iterator();
		
		int count = l1.size();
		
		while(it1.hasNext() && it2.hasNext()) {
			count--;
			sum += it1.next()*Math.pow(10, count);
			sum += it2.next()*Math.pow(10, count);
			System.out.println(sum);
		}
		
		String stringSum = String.valueOf(sum);
		LinkedList<Integer> result = new LinkedList<>();
		
		for(int i=0; i<stringSum.length(); i++) {
			result.add(Integer.parseInt(String.valueOf(stringSum.charAt(i))));
		}
		
		return result;
	}

}



// 2) Stack Min: How would you design a stack which, in addition to push and pop, has a function min 
// which returns the minimum element? Push, pop and min should all operate in 0(1) time.
class MyStack {
	
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(Integer value) {
		stack.push(value);
		if(minStack.isEmpty() || value<=minStack.peek()) {
			minStack.push(value);
		}
	}
	
	public Integer pop() {
		Integer popValue = stack.pop();
		if(popValue.equals(minStack.peek())){
			minStack.pop();
		}
		return popValue;
	}
	
	public Integer min() {
		return minStack.peek();
	}
	
}