package week2;

import java.util.Arrays;
import java.util.LinkedList;

public class WordBucket {

	public static void main(String[] args) {
		// main method with example cases
		bucketize("she sells sea shells by the sea", 10);
		
		bucketize("the mouse jumped over the cheese", 7);
		
		bucketize("fairy dust coated the air", 20);
		
		bucketize("a b c d e", 2);
		
		bucketize("Should return empty array", 2);
		
	}
	
	public static String[] bucketize(String phrase, int charCount) {
		String[] words = phrase.split(" ");
		LinkedList<StringBuilder> bucket = new LinkedList<>();
		
		// process if and only if first word passes check
		if(words[0].length() <= charCount) {
			bucket.add(new StringBuilder(words[0]));
			
			for(int i=1 ; i<words.length ; i++) {
				// update phrase if size is acceptable
				if(bucket.getLast().length()+words[i].length()+1 <= charCount) {
					bucket.set(bucket.size()-1, bucket.getLast().append(" " + words[i]));
				}
				// check if individual word is acceptable
				else if(words[i].length()>charCount) {
					bucket = new LinkedList<>();
					break;
				}
				// add word to start new 'phrase'
				else {
					bucket.add(new StringBuilder(words[i]));
	
				}
			}
		}
		// convert to string array
		String[] bucketStrings = Arrays.copyOf(bucket.stream().map((sb) -> sb.toString()).toArray(), bucket.size(), String[].class);
		
		// print and return
		System.out.print(phrase);
		System.out.println(" ("+charCount+")");
		System.out.println(Arrays.toString(bucketStrings));
		System.out.println("");
		return bucketStrings;
	}

}
