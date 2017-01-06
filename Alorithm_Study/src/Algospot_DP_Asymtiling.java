/* 비대칭 타일링(문제ID : Asymtling)
 사각형의 너비 n이 주어졌을때(2*n 크기), 비대칭 타일링 방법의 수를 
 1,000,000,007로 나눈 나머지 출력

Asymmetric(n) = 2*n 크기의 사각형을 채우는 비대칭 방법의 수
- n이 홀수 : Asymmetric(n) = ( tiling(n) - tiling(n/2) + MOD ) % MOD
- n이 짝수 : Asymmetric(n) = ( tiling(n) - tiling(n/2) + MOD ) % MOD
                                           - ( tiling(n) - tiling(n/2 - 1) + MOD ) % MOD
 
Tiling(n) = 2*n 크기의 사각형을 타일로 덮는 방법
Tiling(n) = Tiling(n-1) + Tiling(n-2)
 */
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Algospot_DP_Asymtiling {
	static int N;
	static int Answer;
	static final int MOD = 1000000007;
	static int[] cache = new int[101];

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("Algospot_DP_Asymtiling.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case=1; test_case <=T; test_case++){
			N = sc.nextInt();
			Arrays.fill(cache, -1);
			Answer = asymmetric(N);
			System.out.println("#" + test_case + " " + Answer);
		}
		sc.close();
	}
	
	static int asymmetric(int width){
		if(width % 2 ==1){
//			int val = Math.abs(tiling(width) - tiling(width/2));
			int val = tiling(width) - tiling(width/2) + MOD;
			return val % MOD;
		}
		else{
			int val =  tiling(width);
			val = (val - tiling(width/2) + MOD) % MOD;
			val = (val - tiling(width/2 -1) + MOD) % MOD;
//			val = Math.abs(val - tiling(width/2)) % MOD;
//			val = Math.abs(val - tiling(width/2 -1)) % MOD;			
			return val;
		}
	}

	static int tiling(int width){
		if(width<=1) return 1;
		
		if(cache[width] != -1) return cache[width];
		
		int a = tiling(width-1);
		int b = tiling(width-2);
		
		cache[width] = (a+b) % MOD;
		
		return cache[width];
		
	}
}
