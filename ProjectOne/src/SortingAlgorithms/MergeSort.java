package SortingAlgorithms;

/* Marian Willard and Caroline Danzi
*  Gregory Gelfond
*  CSE 464 Algorithms
*  4 March 2016
*/

import java.util.Random;

public class MergeSort {
	// holds sorted values before they are copied into the original list
	protected static int[] newLst;

	public static void merge(int[] nums, int[] left, int[] right) {
		// pointers to where we are in each array
		int lp = 0;
		int rp = 0;
		int i = 0;
		
		// Look at the elements at the left and right pointers and
		// add the smaller one to nums
		while(lp < left.length && rp < right.length) {
			if(left[lp] < right[rp]) {
				nums[i] = left[lp];
				lp++;
			} else {
				nums[i] = right[rp];
				rp++;
			}
			i++;
		}
		
		// If all the elements in right were moved over to nums,
		// add the rest of left to nums.
		while(lp < left.length) {
			nums[i] = left[lp];
			lp++;
			i++;
		}
		
		// If all the elements in left were moved to nums,
		// add the rest of right to nums.
		while(rp < right.length) {
			nums[i] = right[rp];
			rp++;
			i++;
		}
		
	}
	
	public static void mergeSort(int[] nums) {
		// If the array is of length 0 or 1, it is trivially sorted
		if(nums.length > 1) {
			// Split the array into two arrays
			int mid = nums.length / 2;
			int[] left = new int[mid];
			int[] right = new int[nums.length - mid];
			
			// The left array gets the left half of nums
			for(int i = 0; i < left.length; i++) {
				left[i] = nums[i];
			}
			// The right array gets the right half of nums
			for(int i = 0; i < right.length; i++) {
				right[i] = nums[mid + i];
			}
			
			// Sort the left and right halves recursively
			mergeSort(left);
			mergeSort(right);
			
			// Merge the two halves
			merge(nums, left, right);
		}
	}
	
	public static void main(String[] args) {
		// default list size is 20
		int size = 20;
		// look for command line arguments to use as list size
		if(args.length > 0){
			try{
			size = Integer.parseInt(args[0]);
			} catch (Exception e){
				System.out.println("Input was not a number. Using default size 20.");
			}
		}
		// create the list with random integers within [1, 1000)
		int[] lst = new int[size];
		newLst = new int[size];
		Random rand = new Random();
		System.out.println("before sorting: ");
		for(int i = 0; i < size; i++){
			lst[i] = rand.nextInt(1000);
			System.out.print(lst[i] + " ");
		}
		// call mergesort on the list with start index of 0, 
		// and end index of the last element in the array.
		mergeSort(lst);
		
		System.out.println("\nafter sorting:");
		for(int i = 0; i < size; i++) {
			System.out.print(lst[i] + " ");
		}
	}
}