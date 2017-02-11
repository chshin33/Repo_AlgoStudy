/* 최대 증가 부분 수열(문제ID : LIS, p230)
1) 완전탐색

2) 동적계획
LIS(i) = input[i] 에서 시작하는 부분 증가수열중 최대길이
 
Answer  =   Max (LIS(i))
                0≤i<N
LIS(i)     =  Max (1 + LIS(j))   if input[i]  < input[j]
               i+1≤j<N
*/
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algospot_DP_LIS {
	static int N;
	static int[] M;
	static ArrayList<Integer> input;
	static int Answer;
	
	public static void main(String agrs[]) throws Exception{
		System.setIn(new FileInputStream("Algospot_DP_LIS.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		long startTime;
		for(int test_case=1; test_case<=T; test_case++){
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			input = new ArrayList<>();
			for(int i=1; i<=N; i++){
				input.add(Integer.parseInt(st.nextToken()));
			}
			
			printInput(test_case);
			
			//1) 완전탐색
			startTime = System.currentTimeMillis();
			Answer = 0;
			Answer = LIS(input);
			System.out.println("#" + test_case + ":완전탐색 " + Answer);
			
			System.out.println("time:"+(System.currentTimeMillis()-startTime)/1000.0);
			
			//2)동적계획
			startTime = System.currentTimeMillis();
			M = new int[N+1];
			Arrays.fill(M, -1);
			Answer = 0;
			
			Answer=0;
			for(int i=0; i<N; i++){
				Answer = Math.max(Answer, LIS_DP(i));
			}
			
			System.out.println("#" + test_case + ":동적계획 " + Answer);
			System.out.println("time:"+(System.currentTimeMillis()-startTime)/1000.0);
	
		}
//		System.out.println("Time:"+(System.currentTimeMillis()-startTime)/1000.0);
	}
	
	//1)완전탐색
	static int LIS(ArrayList<Integer> A){
		if(A.isEmpty()==true)
			return 0;
		
		int ret=0;
		for(int i=0;  i < A.size(); i++){
			ArrayList<Integer> B = new ArrayList<>();
			for(int j=i+1; j < A.size(); j++){
				if(A.get(i) < A.get(j)){
					B.add(A.get(j));
				}
			}
			ret = Math.max(ret, 1+ LIS(B));
		}
		
		return ret;
	}
	
	//2) 동적계획
	static int LIS_DP(int i){
		if(M[i]!=-1)
			return M[i];
		int ret =1;
		for(int j=i+1; j<=N-1; j++){
			if(input.get(i) < input.get(j)){
				ret = Math.max(ret, 1+ LIS_DP(j));
			}
		}
		M[i] = ret;
		return ret;
	}
	
	static void printInput(int num){
		System.out.print("case "+ num + ": ");
		for(int i=0; i<N; i++){
			System.out.printf("%d ", input.get(i));
		}
		System.out.println();
	}
}
