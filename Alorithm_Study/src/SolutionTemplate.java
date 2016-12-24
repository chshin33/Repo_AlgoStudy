import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class SolutionTemplate {
	
	static int N;
	static int K;
	static int Answer;
	
	ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		long startTime = System.currentTimeMillis();
		
		//케이스별 처리
		for(int test_case=1; test_case<=T; test_case++){
			//문제처리
			N = sc.nextInt();
			Answer = process(N);
			
			//정답출력
			System.out.println("#" + test_case + " " + N + " " + Answer);
		}
		
		//소요시간 구하기
		System.out.println("Time: " + (System.currentTimeMillis() - startTime)/1000.0 );
		sc.close();
	}//end of main
	
	public static int process(int n){
		int sum = 0;
		for(int i=1; i<=n; i++){
			sum = sum + i;
		}
		return sum;
	}
}
