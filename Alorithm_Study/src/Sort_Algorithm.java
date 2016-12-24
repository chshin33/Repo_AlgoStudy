/*========= Simple, Slow =========
Buble sort
Insertion sort
Selection sort
========= Fast =========
Quick sort
Merge sort
Heap sort
=========O(N)=========
Radix sort
*/
import java.util.Arrays;

public class Sort_Algorithm {
	static int N = 6;
	static int[] input = {0, 10000, 29, 10, 14, 37, 13};
	static int[] copyinput = new int[N+1];
	static int max=0;
	
	public static void main(String[] args) {
		
		System.arraycopy(input, 0, copyinput, 0, input.length);
		
		int key=1;
		
		switch (key) {
		case 1:
			selection_Sort(copyinput);
			break;
		case 2:
			bubble_Sort(copyinput);	
			break;
		}
	}
	
	public static void selection_Sort(int[] list){
		int N = list.length-1;
		int maxpos;
		int max;
		for(int i=N; i >=2; i--)	{
			maxpos=1;
			max=0;
			for(int j=1; j<= i; j++){
				if(max < list[j]){
					maxpos = j;
					max = list[j];
				}
			}
			int tmp = list[i];
			list[i] = list[maxpos];
			list[maxpos] = tmp;
		}
		System.out.println("selection_Sort: " + Arrays.toString(list));
		
	}

	public static void bubble_Sort(int[] list){
		int N = list.length-1;
		for(int i=N; i >=2; i--)	{
			for(int j=1; j<= N-1; j++){
				if(list[j] > list[j+1]){
					int tmp = list[j+1];
					list[j+1] = list[j];
					list[j] = tmp;		
				}
			}
		}
		System.out.println("bubble_Sort: " + Arrays.toString(list));
	}

	
}
