package SortingAlgorithms;
import org.math.plot.*;
import java.util.Random;
import javax.swing.JFrame;

import SortingAlgorithms.SelectionSort;


public class Testing {
	protected static final int RUNS = 10;
	protected static int size = 10;
	// create arrays of ints of different sizes
	
	protected static boolean isEquivalent(int[] lst1, int[] lst2){
		boolean equal = true;
		if(lst1.length != lst2.length){
			return false;
		}
		
		for(int i = 0; i < lst1.length; i++){
			if(lst1[i] != lst2[i]){
				equal = false;
			}
		}
		return equal;
	}
	
	protected static int[] createArr(int n){
		int[] arr = new int[n];
		Random rand = new Random();
		for(int i = 0; i < n; i++){
			arr[i] = rand.nextInt(n*10);
		}
		return arr;
	}
	
	
	public static void main(String[] args){
		// Test SelectionSort
		// test correctness
		
		System.out.println("Selection Sort:");
		
		int[] lst1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] lst = {9, 5, 6, 3, 7, 2, 1, 8, 0, 4};
		
		SelectionSort.ssort(lst);
		System.out.print("Sorts correctly: ");
		if(isEquivalent(lst1, lst)){
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		// size = 10, run til size = 1 mill.
		System.out.println("Run Times: ");
		double[] times = new double[5*3];
		double[] sizes = new double[5*3];
		int counter = 0;
		for(int i = 0; i < 5; i++){
			lst = createArr(size);
			for(int x = 0; x < 3; x++){
				long t1 = System.currentTimeMillis();
				SelectionSort.ssort(lst);
				long t2 = System.currentTimeMillis();
				System.out.println(size + " elements: " + ((t2 - t1) * 1000) + " seconds");
				times[0] = ((t2 - t1) * 1000);
				sizes[0] = size;
				counter++;
			}
			size *= 10;
		}
		
		System.out.println("Merge Sort:");
		
		int[] lst2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] lst3 = {9, 5, 6, 3, 7, 2, 1, 8, 0, 4};
		
		MergeSort.sort(lst3, 0, lst3.length -1 );
		System.out.print("Sorts correctly: ");
		if(isEquivalent(lst2, lst3)){
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		// size = 10, run til size = 1 mill.
		System.out.println("Run Times: ");
		times = new double[5*3];
		sizes = new double[5*3];
		counter = 0;
		size = 10;
		for(int i = 0; i < 5; i++){
			lst3 = createArr(size);
			for(int x = 0; x < 3; x++){
				long t1 = System.currentTimeMillis();
				MergeSort.sort(lst3, 0, lst.length - 1);
				long t2 = System.currentTimeMillis();
				System.out.println(size + " elements: " + ((t2 - t1) * 1000) + " seconds");
				times[0] = ((t2 - t1) * 1000);
				sizes[0] = size;
				counter++;
			}
			size *= 10;
		}
		
		
		
		/*
		// create your PlotPanel (you can use it as a JPanel)
		Plot2DPanel plot = new Plot2DPanel();

		// add a line plot to the PlotPanel
		  
		plot.addLinePlot("Times", sizes, times);
		
		// put the PlotPanel in a JFrame, as a JPanel
		  JFrame frame = new JFrame("a plot panel");
		  frame.setContentPane(plot);
		  frame.setVisible(true);
		 */
		// run list of 100;
		// run list of 1000;
		// run list of 10000;
		// run list of 100000;
		
		
		
		
		
		System.out.println("Done Testing");
	}
}
