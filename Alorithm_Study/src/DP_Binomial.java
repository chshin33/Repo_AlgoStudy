/*  이항계수: 재귀호출, 메모이제이션, BottomUP 방식으로 풀기
n개중 k개를 뽑을 확율은, n-1개에서 k개를 뽑을 확율 더하기, n-1개에서 k-1개를 뽑을 확율

Memoization vs. DP
- 순확식의 값을 계산하는 기법
- 둘다 동적계획법의 일종으로 봄
- Memoization은 top-down방식이며, 실제로 필요한 subproblem만을 푼다
- 동적계획법은 Bottom-up방식이며, recursion에 수반되는 오버헤드가 없다

 nCk = n-1Ck + n-1Ck-1
 (n  = 1                    if n=k or k=0;
  k     (n-1) + (n-1)  otherwise
          k           k-1
 출처: 권오흠, https://youtu.be/K15qLnKKrow
 */

 
public class DP_Binomial {

	static int N;
	static int K;
	
	static long[][] M;
	static long[][] B;
	static int MOD = 100000123;
	
	public static void main(String[] args) {
		
		long Answer;
		long startTime;
		
		N = 5;
		K = 3;
		M = new long[N+1][K+1];
		B = new long[N+1][K+1];		
		
		//1) 완전탐색
		startTime = System.currentTimeMillis();
		Answer = binomial_Recursive(N,K);
		System.out.println("1) 완전탐색 : " + Answer 
				+ ", Time:" + (System.currentTimeMillis()-startTime)/1000.0);
		
		//2) Memoization(메모이제이션)
		startTime = System.currentTimeMillis();
		for(int i=0;i<=N;i++)
			for(int j=0;j<=K;j++)
				M[i][j] = -1;
		
		Answer = binomial_Memoization(N,K);
		System.out.println("2) Memoization : " + Answer 
				+ ", Time:" + (System.currentTimeMillis()-startTime)/1000.0);		
		
		//3) BottomUP
		startTime = System.currentTimeMillis();
		Answer = binomial_BottomUP(N,K);
		System.out.println("3) BottomUP : " + Answer 
				+ ", Time:" + (System.currentTimeMillis()-startTime)/1000.0);
	}
	
	static int binomial_Recursive(int n, int k){
		if(n==k || k==0){
			return 1;
		}
		else{
			return binomial_Recursive(n-1,k) + binomial_Recursive(n-1,k-1); 
		}
	}
	
	static long binomial_Memoization(int n, int k){
		if(n==k||k==0){
			return 1;
		}
		else if(M[n][k]>-1){
			return M[n][k];
		}
		else{
			M[n][k] = binomial_Memoization(n-1,k) + binomial_Memoization(n-1,k-1);
			return M[n][k];
		}
	}
	
	static long binomial_BottomUP(int n, int k){
		for(int i=0 ; i<=n ; i++){
			//가지치기!! B[n][k]를 구하는 것이므로, j<=k(왼쪽) && j<=i(대각선 하단) 만 유효
			for(int j=0 ; j<=k &&  j<=i ; j++){
				if(i==j || j==0)
					B[i][j] = 1;
				else{
					B[i][j] = B[i-1][j] + B[i-1][j-1];
				}
			}
		}
		return B[n][k];
	}
}
