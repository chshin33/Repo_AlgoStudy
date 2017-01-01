import java.util.Arrays;

public class Algospot_DP_Tiling2 {

	static final int MOD = 1000000007;
	static int[] cache = new int[101];
	
	public static void main(String[] args) {
		
		int N = 2;
		int Answer;
		
		Arrays.fill(cache, -1);

		Answer = tiling(N);
		
		System.out.println(Answer);

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
