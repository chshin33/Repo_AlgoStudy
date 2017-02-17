/* 조립라인 스케쥴링
 두개의 조립라인, N개의 공정. 하나의 제품이 완성되려면 두 생산라인 중 한 생산라인을 정해 그 생산라인에
 미완성 제품이 들어가고 N개의 공정을 지나 완성됨. 중간에 생산라인 바꿀수 있음
공장에서 하나의 제품을 만드는데 걸리는 최소시간 구하기
  첫번째 생산라인 진입시간은 e1, 마무리 하는 시간은 x1
 첫번째 생산라인 진입시간은 e2, 마무리 하는 시간은 x2
 첫번째 생산라인의 i 번째 공정에서 소요되는 시간 S[1,i]
 첫번째 생산라인의 i 번째 공정을 마치고 두번째 생산라인 바꾸는데 걸리는 시간은 t[1,i]
 두번째 생산라인의 i 번째 공정을 마치고 첫번째 생산라인 바꾸는데 걸리는 시간은 t[2,i]
 D(i,j) = 물건이 i번 생산라인의 j번째 공정까지 오늘데 걸리는 최소시간 이라 가정
 D(i,j) =  e1 + S[1][1]    if i=1, j=1
              e2 + S[2][1]    if i=2, j=1
              min ( D(i, j-1) , D(3-i, j-1) + T[3-i][j-1]) + S[i][j]        otherwise
Answer = min ( D(1,j) + x1, D(2,j) + x2 )

1
6 2 4 3 2   <-- 공정수 6, e1, e2, x1, x2
7 9 3 4 8 4 <-- S[1][1], S[1][2] ....S[1][N]
8 5 6 4 5 7 <-- S[2][1], S[2][2] ....S[2][N]
2 1 1 3 4    <-- T[1][1], T[1][2] ....T[1][N]
2 1 2 2 1    <-- T[2][1], T[2][2] ....T[2][N]
==> #1 38
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_AssemblyLine {
	static int N;
	static int E1, E2, X1, X2;
	static int[][] S, T;
	static int Answer;
	static int[][] M;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("sample_DP_Assembly.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int Test = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=Test; test_case++){
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			E1 = Integer.parseInt(st.nextToken());
			E2 = Integer.parseInt(st.nextToken());
			X1 = Integer.parseInt(st.nextToken());
			X2 = Integer.parseInt(st.nextToken());
			
			S = new int[3][N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++){
				S[1][i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++){
				S[2][i] = Integer.parseInt(st.nextToken());
			}		
			
			T = new int[3][N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N-1; i++){
				T[1][i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N-1; i++){
				T[2][i] = Integer.parseInt(st.nextToken());
			}			
			
			//1) 완전탐색
			Answer = 0;
			M = new int[3][N+1];
			for(int i=0; i<=2; i++){
				for(int j=0; j<=N; j++){
					M[i][j] = -1;
				}
			}
			Answer = Assembly();
			
			System.out.println("#"+ test_case + " " + Answer);
		}

	}
	
	static int Assembly(){
		
		int ret, ret1, ret2;
		ret1 = DP(1,N);
		ret2 = DP(2,N);
		ret = Math.min(ret1 + X1, ret2 + X2);
		return ret;
	}
	
	static int DP(int i, int j){
		if(i==1&&j==1){
			return E1 + S[1][1];
		}
		if(i==2&&j==1){
			return E2 + S[2][1];
		}
		if(M[i][j]!=-1){
			return M[i][j];
		}
		M[i][j] = Math.min(DP(1, j-1), DP(2, j-1) + T[2][j-1]) + S[i][j];
		return M[i][j];
	}

}
