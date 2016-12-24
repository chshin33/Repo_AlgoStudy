/* 피보나치 수열 : 재귀호출, 메모이제이션, Bottom UP 방식으로 풀기
*/
public class DP_Fibonacci {

	static int N = 9;
	static int Answer;
	
	static int[] M = new int[N+1];
	static int[] B = new int[N+1];
	
	public static void main(String[] args) {
		

		
		//1) Recursive함수
		Answer = fibo_Recursive(N);
		System.out.println("Recursive함수 : " + Answer);
		
		//2) Memoization
		for(int i=0; i< M.length; i++){
			M[i] = -1;
		}
		
		Answer = fibo_Memoization(N);
		System.out.println("Memoization : " + Answer);
		
		//3) Bottopup
		Answer = fibo_Bottomup(N);
		System.out.println("Bottomup : " + Answer);

	}
	
	public static int fibo_Recursive(int n){
		if(n==1 || n==2){
			return 1;
		}
		else{
			return fibo_Recursive(n-1) + fibo_Recursive(n-2);
		}
		
	}
	
	public static int fibo_Memoization(int n){
		if(n==1||n==2){
			return 1;
		}
		else if(M[n] > -1){
			return M[n];
		}
		else{
			M[n] =  fibo_Memoization(n-1) + fibo_Memoization(n-2);
			return M[n];
		}
	}
	
	public static int fibo_Bottomup(int n){
		B[1]=B[2]=1;
		for(int i=3;i<=n;i++){
			B[i] = B[i-1] + B[i-2];
		}
		return B[n];
	}

}
