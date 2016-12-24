/* 동적계획법 - KnapSack(Unbounded) -- 정올 1077
보석의 종류 N, 총무게 W
보석의 무게(Wi)와 값어치(Pi)가 주어질 때 총 무게가 W를 넘지 않으면서, 
보석의 총 값어치가 최대가 되는 최대값을 출력한다.
보석 선택시 무제한이다.
-->점화식이 안 세워진다. Bottom-Up으로 풀어야 함.
 */

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class DP_Knapsack_Unbound {

	static int N;
	static int W;
	static int[] Wi;
	static int[] Pi;

	static int[] B;
	static int[] M;
	static int Answer;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("sample_dp_kanpsack.txt"));
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		W = sc.nextInt();

		Wi = new int[N + 1];
		Pi = new int[N + 1];

		Wi = new int[N + 1];
		Pi = new int[N + 1];

		for (int n = 1; n <= N; n++) {
			Wi[n] = sc.nextInt();
			Pi[n] = sc.nextInt();
		}

		//Bottom-up방식
		B = new int[W + 1];
		Answer = KS_Bottomup();
		System.out.println("Bottom-Up: " + Arrays.toString(B));
		System.out.println(Answer);
		
		//Top-Down방식
/*		M = new int[W + 1];
		for(int i=0; i<=W; i++){
			M[i] = -1;
		}
		Answer = KS_Memoization(N, W);
		System.out.println("Top-Down: " + Arrays.toString(M));
		System.out.println(Answer);*/

		sc.close();
	}

	public static int KS_Bottomup() {
		//i=0일때 
		B[0] = 0;
		for (int j = 1; j <= W; j++) {
			B[j] = B[j - 1];
			for (int i = 1; i <= N; i++) {
				if (Wi[i] <= j) {
					B[j] = Math.max(B[j], B[j - Wi[i]] + Pi[i]);
				}
			}
		}
		return B[W];
	}
	
	public static int KS_Memoization(int n, int w) {
		//점화식이 안 세워진다. Bottom-Up으로 풀어야 함.
		return -1;
	}
}
