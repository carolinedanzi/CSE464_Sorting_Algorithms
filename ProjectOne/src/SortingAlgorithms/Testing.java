package SortingAlgorithms;
/* Marian Willard and Caroline Danzi
*  Gregory Gelfond
*  CSE 464 Algorithms
*  4 March 2016
*/
import org.math.plot.*;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

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
		
		// size = 10, run until size = 1 mill.
		System.out.println("Run Times: ");
		int outterSize = 10;
		double[] times = new double[outterSize];
		double[] sizes = new double[outterSize];
		int counter = 0;
		// size starts at 10

		for(int i = 0; i < outterSize; i++){
			lst = createArr(size);
			
			long t1 = System.currentTimeMillis();
			SelectionSort.ssort(lst);
			long t2 = System.currentTimeMillis();
			System.out.println(size + " elements: " + ((t2 - t1) / 1000.0) + " seconds");
			times[counter] = ((t2 - t1) / 1000.0);
			sizes[counter] = size;
			counter++;
			size += 25000;
		}
		// create your PlotPanel (you can use it as a JPanel)
		Plot2DPanel plot = new Plot2DPanel();
		// add a line plot to the PlotPanel
		//plot.addLinePlot("Times", sizes, times);
		plot.setSize(800, 600);
		plot.addLinePlot("SelectionSort",new Color(255, 0, 0), sizes, times);
		plot.getAxis(0).setLabelText("Number of Elements");
		plot.getAxis(0).setLabelPosition(0.5, -0.15);
		plot.getAxis(1).setLabelText("Times");
		plot.addLegend(Plot2DPanel.SOUTH);
		// put the PlotPanel in a JFrame, as a JPanel
		JFrame frame = new JFrame("SelectionSort vs. MergeSort");
		frame.setContentPane(plot);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		System.out.println("Merge Sort:");
		
		int[] lst2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] lst3 = {9, 5, 6, 3, 7, 2, 1, 8, 0, 4};
		
		MergeSort.mergeSort(lst3);
		System.out.print("Sorts correctly: ");
		if(isEquivalent(lst2, lst3)){
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		// size = 10
		System.out.println("Run Times: ");
		times = new double[outterSize];
		sizes = new double[outterSize];
		counter = 0;
		size = 10;
		
		for(int i = 0; i < outterSize; i++){
			lst = createArr(size);
			
			long t1 = System.currentTimeMillis();
			MergeSort.mergeSort(lst);
			long t2 = System.currentTimeMillis();
			System.out.println(size + " elements: " + ((t2 - t1) / 1000.0) + " seconds");
			times[counter] = ((t2 - t1) / 1000.0);
			sizes[counter] = size;
			counter++;
			size += 25000;
		}
		  
		plot.addLinePlot("MergeSort",new Color(0,0,255), sizes, times);
		
		System.out.println("Done Testing");
	}
}
