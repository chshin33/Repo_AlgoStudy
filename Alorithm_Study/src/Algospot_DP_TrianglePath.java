/* 삼각형 위의 최대 경로(문제ID : TRIANGLEPATH, P226)
 1) 완전탐색
pathSum(y,x,sum)=(y,x) 지점에 있고,지점에 오기까지 합이 sum일때 목적지까지 얻을수 있는 최대합
pathSum(y,x,sum)= max { pathSum(y+1, x, sum + input[y][x]),
                                          pathSum(y+1, x+1, sum + input[y][x]) } 
 2) 동적계획
 pathSumDP(y,x) = max { pathSumDP(y+1,x), pathSumDP(y+1, x+1) } + input[y][x]

 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algospot_DP_TrianglePath {
	static int N;
	static int[][] input;
	static int[][] M;
	static int Answer;
	
	public static void main(String agrs[]) throws Exception{
		System.setIn(new FileInputStream("Algospot_DP_TrianglePath.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		long startTime = System.currentTimeMillis();
		for(int test_case=1; test_case<=T; test_case++){
			N = Integer.parseInt(br.readLine());
			input = new int[N+1][N+1];
			for(int i=1; i<=N; i++){
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=N && j<=i; j++){
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			printInput();
			
			Answer = 0;
			
			//1) 완전탐색
			Answer = pathSum(1,1, 0);
			System.out.println("#"+test_case + ":완전탐색 " + Answer);
			
			//2) 동적계획
			M = new int[N+1][N+1];
			for(int i=0; i<=N; i++){
				for(int j=0; j<=N; j++){
					M[i][j] = -1;
				}
			}
			
			Answer = pathSumDP(1,1);
			System.out.println("#"+test_case + ":동적계획 " + Answer);
		}
		
		System.out.println("Time:"+(System.currentTimeMillis()-startTime)/1000.0);
		
	}
	
	
	
	
	//완전탐색
	static int pathSum(int y, int x, int sum){
		if(y==N){
			return sum + input[y][x];
		}
		
		int ret = 0;
		ret = pathSum(y+1, x, sum + input[y][x]);
		ret = Math.max(ret,pathSum(y+1, x+1, sum + input[y][x]));
		return ret;
	}	
	//동적계획
	static int pathSumDP(int y, int x){
		if(y==N)
			return input[y][x];
		if(M[y][x] !=-1)
			return M[y][x];
		M[y][x] = Math.max(pathSumDP(y+1,x), pathSumDP(y+1,x+1)) + input[y][x];
		return M[y][x];
	}
	
	static void printInput(){
		for(int i=1; i<=N; i++){
			for(int j=1; j<=N && j<=i; j++){
				System.out.printf("%d\t", input[i][j]);
			}
			System.out.println();
		}
	}
}
