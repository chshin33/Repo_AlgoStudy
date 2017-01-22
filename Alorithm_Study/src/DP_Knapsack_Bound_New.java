/* 동적계획법 - KnapSack(0-1 knapsack, Bounded)
N개 물건의 수, 최대담을수 있는 용량 W, 0/1(선택한것 다시 선택못함)

pack(n, w) : 캐리어 용량이 w만큼 남았을때, n 이후의 물건들을 싸서 얻을수 있는 최대 가치(절박도)

pack(n, w)  = 0                                                                                  if n=N
                      pack(n+1,w)                                                                 if w < Wi[n]
                      Max( pack(n+1,w) , pack(n+1, w - Wi[n]) + Pi[n] )       if item=N

해당물건을 가져가는 경우 : pack(n+1, w - Wi[n]) + Pi[n]
해당물건을 안가져간 경우 : pack(n+1, w) 

 */

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class DP_Knapsack_Bound_New {

	static int N;
	static int W;
	static String[] Name;
	static int[] Wi;
	static int[] Pi;
	
	static int[][] M;

	static int Answer;
	static ArrayList<String> itemList = new ArrayList<String>();

	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("sample_dp_kanpsack_new.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++){
			N = sc.nextInt();
			W = sc.nextInt();
			
			Name = new String[N+1];
			Wi = new int[N+1];
			Pi = new int[N+1];
			
			for(int i=1; i<=N; i++){
				Name[i] = sc.next();
				Wi[i] = sc.nextInt();
				Pi[i] = sc.nextInt();
			}
			
			M = new int[N+1][W+1];
			for(int i=0; i<=N; i++){
				for(int j=0; j<=W; j++){
					M[i][j] = -1;
				}
			}
			
			Answer = pack(1, W);
			
			itemList.clear();
			reconstruct(1, W);
			
			System.out.printf("#%d %d %d\n", test_case, Answer, itemList.size());
//			System.out.println(itemList);
			for(String name : itemList){
				System.out.println(name);
			}
			
		}
		
		sc.close();

	}
	
	static int pack(int n, int w){
		if(n == N){
			return 0;
		}
		if(M[n][w] != -1){
			return M[n][w];
		}
		
		//용량이 안되어 못 담는 경우
		if(w < Wi[n]){
			M[n][w] = pack(n+1, w);
		}
		else{//담을수 있는 경우
			M[n][w] = Math.max(pack(n+1, w), 
					pack(n+1, w-Wi[n]) + Pi[n]);
		}
		
		return M[n][w];
	}
	
	static void reconstruct(int n, int w){
		if(n == N)
			return;
		
		//item을 선택하지 않았다(가방에 안넣었다)
		if(pack(n, w) == pack(n+1, w)){
			reconstruct(n+1, w);
		}
		else{//item을 선택했다
			itemList.add(Name[n]);
			reconstruct(n+1, w-Wi[n]);
		}
	}

}
