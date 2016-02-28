/* Marian Willard and Caroline Danzi
*  Gregory Gelfond
*  CSE 464 Algorithms
*  4 March 2016
*/

import java.util.Random;
public class SelectionSort {
	
	private static int minimum(int[] lst, int start){
		// min initially is set to start
		int min = start;
		// for each value in lst from start to the end
		for(int i = start; i < lst.length; i++){
			// if the value at i is smaller than the value at min
			if(lst[i] < lst[min]){
				// then set min to i
				min = i;
			}
		}
		return min;
	}
	
	private static void swap(int[] lst, int i, int j){
		// swap the values at i and j in lst
		int temp = lst[j];
		lst[j] = lst[i];
		lst[i] = temp;
	}
	
	public static int[] ssort(int[] lst){
		// if the list length is less than 2
		// then the list is trivially sorted
		if(lst.length < 2){
			return lst;
		}
		// for all elements in the list
		for(int i = 0; i < lst.length; i++){
			// find the smallest value to the left of the current index
			int min = minimum(lst, i);
			// then swap the current index value with the minimum
			swap(lst, min, i);
		}
		// return the list
		return lst;
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
		// create the list with rndom integers within [1, 1000)
		int[] lst = new int[size];
		Random rand = new Random();
		for(int i = 0; i < size; i++){
			lst[i] = rand.nextInt(1000);
		}
		// call ssort to sort the list
		lst = ssort(lst);
	}
}
