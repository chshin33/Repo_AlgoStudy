import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SolutionTemplateNew {
	
	static int N;
	static int K;
	static int Answer;
	static int[][] B;
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("sample_input.txt"));
		
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		//int T = sc.nextInt();
		int T = Integer.parseInt(br.readLine());
		
		long startTime = System.currentTimeMillis();
		
		//케이스별 처리
		for(int test_case=1; test_case<=T; test_case++){

			//N = sc.nextInt();
			tk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tk.nextToken());
			K = Integer.parseInt(tk.nextToken());
			
			B = new int[N+1][K+1];
			Answer = process(N, K);
			
			//정답출력
			System.out.println("#" + test_case + " " + N + "C" + K + " " + Answer);
		}
		
		//소요시간 구하기
		System.out.println("Time: " + (System.currentTimeMillis() - startTime)/1000.0 );
		//sc.close();
	}//end of main
	
	public static int process(int n, int k){
		// nCk = n-1Ck-1 + n-1Ck
		for(int i=0; i<=n; i++){
			for(int j=0; j<=k && j<=i; j++){
				if(i==j || j==0){
					B[i][j] = 1;
				}
				else{
					B[i][j] = B[i-1][j-1] + B[i-1][j];
				}
			}
		}
		return B[n][k];
	}
}
