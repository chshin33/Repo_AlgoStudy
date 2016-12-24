/*동적계획법 : 교차하지 않는 원의 현들의 최대집합
B[i, j] =  0       단, i=j 일때
             Max     (B[i, k] + B[k+1, j] + Pij)    단, i<j 일때
             i<= k<= j-1
*/
import java.io.FileInputStream;
import java.util.Scanner;

public class DP_NonCrossLine {
	//원의 둘레에 100개의 점이 일정한 간격으로 시계방향 번호
	static int N = 100;
	static int K; //선분의 개수
	static int[][] B = new int[N+1][N+1]; //동적프로그래밍, Bottom-up 배열
	static int[][] Path; //선분들의 시작점, 끝점 저장 
	static int Answer = 0;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("sample_noncrossline.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		long startTime = System.currentTimeMillis();
		
		for(int test_case=1; test_case<=T; test_case++){
			K = sc.nextInt();
			Path = new int[N+1][N+1];
			int start=0;
			int end=0;
			for(int i=1; i<=K; i++){
				start = sc.nextInt();
				end =  sc.nextInt();
				Path[start][end] = 1;
				Path[end][start] = 1;
			}
			Answer = DP_Bottomup();
			System.out.println("#" + test_case + " " + Answer);
		}//end of for

		System.out.println("Elapsed Time:" + (System.currentTimeMillis()-startTime)/1000.0);
		sc.close();
	}
	
	public static int DP_Bottomup(){
		//i=j 일때는 0, 출발점과 끝점이 돌일하면 현이 안만들어짐
		for(int i=1; i<=N; i++){
			B[i][i] = 0;
		}
		//대각선 방향으로 진행하면서 계산,  i <= k <= j-1
		for(int r=1; r<=N-1; r++){
			for(int i=1; i<=N-r; i++){
				int j = i + r;
				B[i][j] = B[i+1][j] + Path[i][j];
				for(int k=i+1; k<= j-1; k++){
					if(B[i][j] < B[i][k] + B[k+1][j] + Path[i][j]){
						B[i][j] = B[i][k] + B[k+1][j] + Path[i][j];
					}
				}
			}
		}
		return B[1][100];//1에서 100까지 점중에 교차하지 않는 현들의 최대집합
	}
}
