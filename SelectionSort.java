import java.util.Random;
public class SelectionSort {
	
	private static int minimum(int[] lst, int start){
		int min = start;
		for(int i = start; i < lst.length; i++){
			if(lst[i] < lst[min]){
				min = i;
			}
		}
		return min;
	}
	
	private static void swap(int[] lst, int i, int j){
		int temp = lst[j];
		lst[j] = lst[i];
		lst[i] = temp;
	}
	
	public static int[] ssort(int[] lst){
		if(lst.length < 2){
			return lst;
		}
		for(int i = 0; i < lst.length; i++){
			int min = minimum(lst, i);
			swap(lst, min, i);
		}
		return lst;
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
		Random rand = new Random();
		for(int i = 0; i < size; i++){
			lst[i] = rand.nextInt(1000);
		}
		lst = ssort(lst);
		System.out.println("Done.");
	}

}
