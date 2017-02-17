/* 합병 정렬 : O(nLogn)  */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sort_Merge {
	static int N;
	static int[] input;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("sample_MergeSort.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		long startTime;
		for(int test_case=1; test_case<=T; test_case++){
			N = Integer.parseInt(br.readLine());
			input = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<N; i++){
				input[i] = Integer.parseInt(st.nextToken());
			}
			//합병 정렬
			startTime = System.currentTimeMillis();
			mergeSort(input, 0, N-1);
			
			System.out.print("#" + test_case + " ");
			System.out.println(Arrays.toString(input));
			System.out.println("Time:" + (System.currentTimeMillis()-startTime)/1000.0);
		}
	}
	
	static void mergeSort(int[] data, int p, int r){
		if(p < r){
			int q = (p + r) / 2;
			mergeSort(data, p, q);
			mergeSort(data, q+1, r);
			merge(data, p, q, r);
		}
	}
	
	static void merge(int[] data, int p, int q, int r){
		int i = p,  j = q+1,  k=p;
		int[] temp = new int[N];
		while(i<=q && j<=r){
			if(data[i] <= data[j])
				temp[k++] = data[i++];
			else
				temp[k++] = data[j++];
		}
		while(i<=q){
			temp[k++] = data[i++];
		}
		while(j<=r){
			temp[k++] = data[j++];
		}
		for(int n=p; n<= r; n++){ //주의!! n은 p~r 사이
			data[n] = temp[n];
		}
	}
}
