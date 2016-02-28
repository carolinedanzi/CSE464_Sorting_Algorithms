import java.util.Random;


public class MergeSort {
	protected static int[] newLst;  

	public static void merge(int[] lst, int lo, int mid, int hi){
		int left = lo;
		int right = mid + 1;
		// loop left while left < mid
		// loop right while right < hi;
		
		
		for(int i = lo; i <= hi; i++){
			if (left > mid){
				newLst[i] = lst[right];
				right++;
			}else if(right > hi){
				newLst[i] = lst[left];
				left++;
			} else if(left <= mid &&
				lst[left] <= lst[right]){
				newLst[i] = lst[left];
				left++;
			} else if(right <= hi) {
				newLst[i] = lst[right];
				right++;
			}						// else loop and don't swap
		}
		for(int i = lo; i <= hi; i++){  // copy sorted values into original list
			lst[i] = newLst[i];
		}
	}
	
	
	
	public static void mergeSort(int[] lst, int lo, int hi){
		int mid = ((hi - lo) / 2) + lo;
		if(hi - lo <= 1){		// less than or equal to 1 because of index math
			merge(lst, lo, mid, hi);
		} else {
			mergeSort(lst, lo, mid);
			mergeSort(lst, mid + 1, hi);
			
			merge(lst, lo, mid, hi);
		}
	}
	
	public static void main(String[] args) {
		int size = 20;
		if(args.length > 0){
			try{
			size = Integer.parseInt(args[0]);
			} catch (Exception e){
				System.out.println("Input was not a number. Using default size 20.");
			}
		}
		int[] lst = new int[size];
		newLst = new int[size];
		Random rand = new Random();
		for(int i = 0; i < size; i++){
			lst[i] = rand.nextInt(1000);
		}
		
		for(int c = 0; c < lst.length; c++){
			System.out.println(lst[c]);
		}
		System.out.println("\nsort here\n");
		mergeSort(lst, 0, lst.length - 1); // give the index of the last element to sort
		
		for(int c = 0; c < lst.length; c++){
			System.out.println(lst[c]);
		}

		System.out.println("Done.");
		
	}
}
