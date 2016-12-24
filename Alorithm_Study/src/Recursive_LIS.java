/* Longest Increasing Subsequence, 최장 증가 부분 수열
 주어진 수열의 최장 증가 부분 수열의 길이를 구하기
 
 #1 4
 #2 100
 #3 105
*/
import java.io.FileInputStream;
import java.util.Scanner;

public class Recursive_LIS {

	static int N;
	static int Answer=0;
	static int[] input;
	static int[] LIS;
	static int MAX = 0;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("sample_recursive_LIS.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++){
			N = sc.nextInt();
			input = new int[N+1];
			LIS = new int[N+1];
			
			for(int i=1;i<=N;i++){
				input[i] = sc.nextInt();
			}
			
			LIS(1);
			
			System.out.println("#" + test_case + " " + Answer);
		}

		
		sc.close();
	}

	public static void LIS(int start){
		if(start == N)
			return;
		
		for(int i=start+1; i<=N; i++){
			clearLIS();
			int pos=1;
			LIS[pos] = start;
			for(int j=0; j <= N-i; j++){
				if(LIS[pos] < input[i+j]){
					pos++;
					LIS[pos] = input[i+j];
				}
			}//end of for
			if(Answer < pos){
				Answer = pos;
			}
		}//end of for
		
		LIS(start+1);
		
	}
	
	
	public static void clearLIS(){
		for(int i=1; i<=N; i++)
			LIS[i] = 0;
	}
}
