import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Algospot_DP_Quantization {
	
	static int[] input;
	static int[][] M;
	static int N;
	static int S;	
	static int Answer;
	static int INF = 987654321;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("Algospot_DP_Quantization.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		long startTime = System.currentTimeMillis();
		
		/*minVal2(1,3);
		minVal2(5,7);
		minVal2(1,7);*/
		

		for(int test_case=1; test_case<=T; test_case++){
			N = sc.nextInt();
			input = new int[N+1];
			S = sc.nextInt();
			
			for(int i=1; i<=N; i++){
				input[i] = sc.nextInt();
			}
			
			//배열 정렬
			Arrays.sort(input);
			
			M = new int[N+1][S+1];
			for(int i=0; i<=N; i++){
				for(int j=0; j<=S; j++){
					M[i][j] = -1;	
				}
			}
			
//			Answer = minVal(1,4);
			
			Answer = quantize(1, S);
			
			System.out.println(Answer);
		}

		//소요시간 구하기
		//System.out.println("Elapsed Time: " + (System.currentTimeMillis() - startTime)/1000.0 );
		sc.close();
	}//end of main
	
	public static int quantize(int i, int s){
		if(i==N) return 0;
		if(s==0) return INF;
		if(M[i][s] != -1) return M[i][s];
		
		M[i][s] = INF;
		for(int j=1; j<= N-i; j++){
			int a = quantize(i+j, s-1);
			int b =  minVal(i,i+j-1);
			//System.out.println("a:" + a + ", b:" + b);
			M[i][s] = Math.min(M[i][s], a+b );			
//			M[i][s] = Math.min(M[i][s], quantize(i+j, s-1) + minVal(i,i+j) );
		}
		return M[i][s];
	}
	
	public static int minVal(int a, int b){
//		System.out.print(a+":" + b + " ");
		if(a==b){
//			System.out.println("=>" + 0);
			return 0;
		}
		int start = input[a];
		int end = input[b];

		int sum;
		int Minsum = INF;			

		for(int i=start; i<=end; i++){
			sum=0;
			for(int j=a; j<=b; j++){
//				sum = sum + (i-input[j])*(i-input[j]);
				sum = (int) (sum + Math.pow(i-input[j], 2));
			}
			Minsum = Math.min(Minsum, sum);
//			System.out.println(i + ":" + Minsum);
		}
//		System.out.println("=>" + Minsum);
		return Minsum;
	}

	public static int minVal2(int a, int b){
		System.out.print(a+":" + b + " ");		
		int start = a;
		int end = b;

		int sum;
		int Minsum = INF;			

		for(int i=start; i<=end; i++){
			sum = (i-a)*(i-a) + (i-b)*(i-b);
			Minsum = Math.min(Minsum, sum);
		}
		
		System.out.println("=>" + Minsum);		
		return Minsum;
	}	
}
