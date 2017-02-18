/* 부분합(Partial Sum) 배열
psum[y,x] =  ∑             ∑        A[i,j]
               0<=i<=y  0<=j<=x                                      */
public class PartialSum_Matrix {
	static int N;
	static int Answer;
	static double dAnswer;
	static int[][] psum;
	static int[] sqinput;
	static int[] sqsum;
	public static void main(String[] args) {
		int[][] input = {{1,2,1,2}, {2,1,3,1}, {1,1,1,1}, {2,1,4,2}};
		N = input.length;
		System.out.println("==input==");
		printInput(input);

		//2차원 부분합
		psum = new int[N][N];
		psum[0][0] = input[0][0];

		for(int y=1; y<N; y++)//0열
			psum[y][0] = psum[y-1][0] + input[y][0];
		
		for(int x=1; x<N; x++)//0행
			psum[0][x] = psum[0][x-1] + input[0][x];
		
		for(int y=1; y<N; y++){//나머지
			for(int x=1; x<N; x++){
				psum[y][x] = input[y][x]+psum[y][x-1]+psum[y-1][x]-psum[y-1][x-1];
			}
		}
		System.out.println("==psum==");
		printInput(psum);
		
		//구간합
		int y1=1, x1=1, y2=3, x2=2;
		Answer = gridSum(y1,x1, y2, x2);
		System.out.printf("Grid Sum of (%d, %d) ~,(%d, %d) : %d\n", y1, x1, y2, x2, Answer);
	}
	
	static int gridSum(int y1, int x1, int y2, int x2){
		int ret = psum[y2][x2];
		
		if(y1>0) ret -= psum[y1-1][x2];
		if(x1>0) ret -= psum[y2][x1-1];
		if(y1>0 && x1>0) ret += psum[y1-1][x1-1];
		return ret; 
	}
	
	static void printInput(int[][] data){
		//출력확인		
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(j==N-1)
					System.out.printf("%d", data[i][j]);
				else
					System.out.printf("%d\t", data[i][j]);
			}
			System.out.println();
		}
	}
}
