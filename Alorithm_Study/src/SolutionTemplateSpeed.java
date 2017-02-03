import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SolutionTemplateSpeed {
	
	static int N;
	static int K;
	static int[][] B;
	static int Answer;
	
	ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws Exception {
		
		//1) Scanner
		Scanner();
		
		//2) BufferedReader
		BufferedReader();

	}//end of main
	
	public static void BufferedReader() throws Exception{
		System.setIn(new FileInputStream("sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		long startTime = System.currentTimeMillis();
		
		StringTokenizer st;
		
		for(int test_case=1; test_case<=T; test_case++){
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			B = new int[N+1][K+1];
			
			for(int i=1; i<=N; i++){
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=K; j++){
					B[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=1; i<=N; i++){
				for(int j=1; j<=K; j++){
					System.out.printf("%d ", B[i][j]);
				}
				System.out.println();
			}			
		}
		
		System.out.println("BufferedReader Time: " + (System.currentTimeMillis() - startTime)/1000.0 );
	}
	
	public static void Scanner() throws Exception{
		System.setIn(new FileInputStream("sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long startTime = System.currentTimeMillis();
		
		//케이스별 처리
		for(int test_case=1; test_case<=T; test_case++){
			//문제처리
			N = sc.nextInt();
			K = sc.nextInt();
			B = new int[N+1][K+1];
			
			for(int i=1; i<=N; i++){
				for(int j=1; j<=K; j++){
					B[i][j] = sc.nextInt();
				}
			}
			
			for(int i=1; i<=N; i++){
				for(int j=1; j<=K; j++){
					System.out.printf("%d ", B[i][j]);
				}
				System.out.println();
			}			
		}
		
		//소요시간 구하기
		System.out.println("Scanner Time: " + (System.currentTimeMillis() - startTime)/1000.0 );
		sc.close();		
	}
}
