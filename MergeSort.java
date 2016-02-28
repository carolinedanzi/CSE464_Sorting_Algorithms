/* Marian Willard and Caroline Danzi
*  Gregory Gelfond
*  CSE 464 Algorithms
*  4 March 2016
*/

import java.util.Random;

public class MergeSort {
	// holds sorted values before they are copied into the original list
	protected static int[] newLst;

	public static void merge(int[] lst, int lo, int mid, int hi){
		// left is the current index in the left half
		int left = lo;
		// right is the current index in the right half
		// right is mid + 1 because left increments until left <= mid
		int right = mid + 1;
		// iterate through the given range
		for(int i = lo; i <= hi; i++){
			// if left is out-of-bounds and the end of the range has
			// not been reached
			if (left > mid){
				// then add the next value in the right side
				// to the sorted list and increment right
				newLst[i] = lst[right];
				right++;
			}else if(right > hi){
				// else if left is out-of-bounds and the end of the range
				// has not been reached, then add the next value from the
				// left to the sorted list and increment left
				newLst[i] = lst[left];
				left++;
			} else if(left <= mid &&
				lst[left] <= lst[right]){
				// if left is not greater than mid, and the current left 
				// value is less than the current right value
				// add the left value to the sorted list
				newLst[i] = lst[left];
				left++;
			} else if(right <= hi) {
				// else if right is not greater than hi,
				// add the right value to the sorted list
				newLst[i] = lst[right];
				right++;
			}	// else loop and don't swap
		}
		// copy the sorted values into the original list
		for(int i = lo; i <= hi; i++){
			lst[i] = newLst[i];
		}
	}
	
	public static void mergeSort(int[] lst, int lo, int hi){
		// find the midpoint index
		int mid = ((hi - lo) / 2) + lo;
		// if the current range is 1 or 2 elements
		if(hi - lo <= 1){
			// then sort those elements
			merge(lst, lo, mid, hi);
		} else {
			// otherwise sort the elements to the left of mid
			mergeSort(lst, lo, mid);
			// and sort the elements to the right of mid
			mergeSort(lst, mid + 1, hi);
			// then merge the left and right
			merge(lst, lo, mid, hi);
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
		for(int i = 0; i < size; i++){
			lst[i] = rand.nextInt(1000);
		}
		// print the original list
		for(int c = 0; c < lst.length; c++){
			System.out.println(lst[c]);
		}
		
		System.out.println("\n-Sort Here-\n");
		// call mergesort on the list with start index of 0, 
		// and end index of the last element in the array.
		mergeSort(lst, 0, lst.length - 1);
		// print the sorted list
		for(int c = 0; c < lst.length; c++){
			System.out.println(lst[c]);
		}
	}
}
