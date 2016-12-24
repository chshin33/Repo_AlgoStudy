import java.util.Arrays;

public class Array {
	
	//static int[][] sol;
	
	static long[][] sol;
	
	//static int N;
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		N=4;
		
		long val = factorial(500);
		//int val = 50000;
		
		System.out.println(val);
		
		sol = new long[3628800][N];
		
		int len = sol.length;
		
		System.out.println(len);
		
		
		/*int[] arr2 = {1,2,3};
		
		int[] arr3 = new int[3];
		
		System.arraycopy(arr2, 0, arr3, 0, arr2.length);
		
		System.out.println("arr3 : " + Arrays.toString(arr3));
		
		int[] arr1 = {5,3,6,3,1};
		
		//오름차순 정렬
		Arrays.sort(arr1);
		
		System.out.println(Arrays.toString(arr1));
		
		
		
		int[] test = {1,2,3,4,5};
		
		
		//1) for 문을 이용한 출력
		for(int n : test){
			System.out.printf("%d ", n);
		}
		
		
		//2) Arrays.toString() 이용한 출력
		System.out.println(Arrays.toString(test));
		
		
		int[][] arr = {{1,1,1},{2,2,2}};
		
		for(int i=0; i<2;i++){
			for(int j=0; j<3;j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		*/

	}
	
	static long factorial(int n){
		
		if(n==0){
			return 1;
		}
		else{
			return n*factorial(n-1);
		}
	
		
	}

}
