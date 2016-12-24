import java.io.FileInputStream;
import java.util.Scanner;

public class Algospot_DP_JumpGame {
	
	static int N;
	static int K;
	static boolean bAnswer;
	static int nAnswer;
	static int[][] input;
	static int[][] M;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("Algospot_JumpGame.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		long startTime = System.currentTimeMillis();
		
		//케이스별 처리
		for(int test_case=1; test_case<=T; test_case++){
			//문제처리
			N = sc.nextInt();
			input = new int[N+1][N+1];
			
			for(int i=1; i<=N; i++){
				for(int j=1; j<=N; j++){
					input[i][j] = sc.nextInt();
				}
			}
			
			M = new int[N+1][N+1];
			for(int i=1; i<=N; i++){
				for(int j=1; j<=N; j++){
					M[i][j] = -1;
				}
			}
			
//			bAnswer = false;
//			bAnswer = jump(1,1);
//			
//			if(bAnswer == true)
//				System.out.println("YES");
//			else
//				System.out.println("NO");
			
			nAnswer = 0;
			nAnswer = jump2(1,1);
			
			if(nAnswer == 1)
				System.out.println("YES");
			else
				System.out.println("NO");
			
		}
		
		//소요시간 구하기
		//System.out.println("Elapsed Time: " + (System.currentTimeMillis() - startTime)/1000.0 );
		sc.close();
	}//end of main
	
	//동적계획법
	public static int jump2(int y, int x){
		if(y>N || x>N) return 0;
		if(y==N && x==N) return 1;
		
		if(M[y][x] != -1) return M[y][x];
		
		int jumpSize = input[y][x];
		M[y][x] = (jump2(y+jumpSize, x) | jump2(y, x+jumpSize));
		
		return M[y][x];
	}
	
	//완전탐색
	public static boolean jump(int y, int x){
		if(y>N || x>N) return false;
		if(y==N && x==N) return true;
		int jumpsize = input[y][x];
		return jump(y + jumpsize, x) || jump(y, x + jumpsize);
	}
}
