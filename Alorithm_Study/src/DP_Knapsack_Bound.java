/* 동적계획법 - KnapSack(0-1 knapsack, Bounded)
보석의 종류 N, 총무게 W
보석의 무게(Wi)와 값어치(Pi)가 주어질 때 총 무게가 W를 넘지 않으면서, 
보석의 총 값어치가 최대가 되는 최대값을 출력한다.
(중요!!!) 보석 선택시 최대 1개까지인 경우(0/1)와, 무제한인 경우에 따라 결과값은 다르다.
 OPT(i,w) = 0                                     i=0
                  OPT(i-1, w)                     Wi > w
                  Max (OPT(i-1,w), OPT(i-1, w-Wi) + Pi)   otherwise
 */

import java.io.FileInputStream;
import java.util.Scanner;


public class DP_Knapsack_Bound {
	
	static int N;
	static int W;
	static int[] Wi;
	static int[] Pi;
	
	static int[][] M;
	static int[][] B;
	static int Answer;

	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("sample_dp_kanpsack.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		W = sc.nextInt();
		
		Wi = new int[N+1];
		Pi = new int[N+1];
		
		for(int n=1; n<=N ; n++){
			Wi[n] = sc.nextInt();
			Pi[n] = sc.nextInt();
		}

		B =new int[N+1][W+1];
		Answer = KS_Bottomup();
		System.out.println("Bottom-Up: " + Answer);

		//메모이제이션용		
		M =new int[N+1][W+1];
		for(int i = 0; i <= N; i++){
			for(int j = 0 ; j <= W; j++){
				M[i][j] = -1;
			}
		}
		Answer = KS_memoization(N, W);
		System.out.println("Memoization(Top-Down): " + Answer);

		sc.close();
	}
	
	public static int KS_Bottomup(){
		for(int i=0; i<=N; i++){
			for(int j=0; j<=W; j++){
				if(i==0 || j==0){
					B[i][j] = 0;
				}
				else{
					if(Wi[i] > j){
						B[i][j] = B[i-1][j];
					}
					else{
						B[i][j] = Math.max(B[i-1][j], B[i-1][j-Wi[i]] + Pi[i]);
					}
				}
			}
		}
		
		/*for(int i=0; i<=N; i++){
			for(int j=0; j<=W; j++)
				System.out.printf("%6d", B[i][j]);
			System.out.println();
		}*/
		return B[N][W];
	}
	
	public static int KS_memoization(int n, int w){
		if(n==0){
			return 0;
		}
		
		if(M[n][w] != -1){
			return M[n][w];
		}

		if( Wi[n] > w){
			//Wi[n] > w, i번째 물건을 담지 않는 경우
			M[n][w] = KS_memoization(n-1,w);
			return M[n][w];
		}
		else{
			M[n][w] = Math.max(KS_memoization(n-1,w), KS_memoization(n-1,w-Wi[n]) + Pi[n]);
			return M[n][w];
		}
	}
}
