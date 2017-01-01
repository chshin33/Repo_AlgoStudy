/* 두니발 박사의 탈옥 : 정올ID, NUMBERS
 감옥에서 출발하여, D일 후에 지정된 마을에 있을 확률을 계산

search(i, days) : i번 마을에 days 일째 숨어있을때, 마지막 날에 q 번 마을에 있을 확률
 
search(i, days) = ∑   search(j, days+1) / | adj(i) |
                       j ∈ adj(i)
 */

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Algospot_DP_Numbers {

	static int N, D, P, Q;
	static ArrayList<Integer> targetList;
	static int[][] connected;
	static int[] deg;
	static double Answer;
	
	static double[][] M;
	
	static LinkedList<Integer> path = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("Algospot_DP_Numb3rs.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			N = sc.nextInt();
			D = sc.nextInt();
			P = sc.nextInt();
			
			connected = new int[N][N];
			deg = new int[N];
			
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					connected[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<N; i++){
				int sum=0;
				for(int j=0; j<N; j++){
					if(connected[i][j] == 1){
						sum++;
					}
				}
				deg[i] = sum;
			}
			
			int cntAnswer = sc.nextInt();
			
			targetList = new ArrayList<Integer>();
			for(int j=1; j<=cntAnswer; j++){
				int node = sc.nextInt();
				targetList.add(node);
			}
			
			//1) 완전탐색
			Answer = 0;
			for(int q=0; q<targetList.size(); q++){
				Q = targetList.get(q);
				path.clear();
				path.add(P); //출발점:교도소 마을
				Answer = search(path);
				if(q==0)
					System.out.printf("#%d 완전탐색 : %.8f ", test_case, Answer);
				else
					System.out.printf("%.8f ", Answer);
			}
			System.out.println();
			
			//2) 동적계획법
			Answer = 0;
			for(int q=0; q<targetList.size(); q++){
				Q = targetList.get(q);
				M = new double[N+1][D+1];
				for(int m=0; m<=N; m++){
					for(int n=0; n<=D; n++){
						M[m][n] = -1;
					}
				}				
				Answer = search2(P, 0);
				if(q==0)
					System.out.printf("#%d 동적계획 : %.8f ", test_case, Answer);
				else
					System.out.printf("%.8f ", Answer);		
			}
			System.out.println();
		}
		sc.close();
		
	}
	
	static double search2(int here, int days){
		if(days==D) return (here == Q ? 1.0 : 0.0);
		
		if(	M[here][days] != -1) return M[here][days];
		
		M[here][days] = 0.0;
		for( int there=0; there < N; there++){
			if(connected[here][there] == 1)
				M[here][days] += search2(there, days+1) / deg[here];
		}
		
		return M[here][days];
	}
	
	static double search(LinkedList<Integer> path){
		if(path.size() == D+1){
			if(path.peekLast() != Q) return 0.0;
			double ret = 1.0;
			for(int i=0; i < path.size() - 1; i++){
				ret = ret * ( (double) 1 / deg[path.get(i)] );
			}
			return ret;
		}
		
		double ret = 0;
		int i = path.peekLast();
		
		for( int j=0; j < N ; j++){
			if(connected[i][j] == 1){
				path.add(j);
				ret += search(path);
				path.pollLast();
			}
		}
		return ret;
	}
}
