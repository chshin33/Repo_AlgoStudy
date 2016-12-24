/* 동적프로그래밍 : Matrix 행렬의  (1,1)에서 (i,j) 까지 이르는 최소합

 L[i,j] = Mij                                      i=1,j=1일때
            L[i,j-1] + Mij                        i=1일때
            L[i-1,j] + Mij                        j=1일때
            min(L[i-1,j], L[i,j-1]) + Mij   otherwise

 출처 : 권오흠, https://www.youtube.com/watch?v=j_sdjivoPs8
*/

public class DP_MatrixShort {

	public static int N=4;
	public static int[][] input = {
												{0, 0, 0,   0, 0},
												{0, 6, 7, 12, 5},
												{0, 5, 3, 11,18},
												{0, 7, 17,3,   3},
												{0, 8, 10,14, 9},
											};
	public static int Answer;

	public static int[][] M = new int[N+1][N+1]; //메모이제이션용
	public static int[][] B = new int[N+1][N+1]; //BottomUP용
	public static char[][] P = new char[N+1][N+1]; //Path용

	public static void main(String[] args) {

		//1) Recursive 방식
		Answer = MatrixShort_Recursive(N,N);
		System.out.println("1) Recursive 방식 : " + Answer);

		//2) Memoization 방식
		//메모 테이블 초기화 : -1
		for(int i=0; i<=N; i++)
			for(int j=0; j<=N; j++)
				M[i][j] = -1;

		Answer = MatrixShort_Memo(N,N);
		System.out.println("1) Memoization 방식 : " + Answer);

		//3) BottomUP 방식
		Answer = MatrixShort_BottomUP();
		System.out.println("3) BottomUP : " + Answer);

		//3-1) BottomUP 방식 및 코드 간소화
		B = new int[N+1][N+1];

		for(int j=0;j<=N;j++)
			B[0][j] = 100000;

		for(int i=0;i<=N;i++)
			B[i][0] = 100000;

		Answer = MatrixShort_BottomUP1();
		System.out.println("3-1) BottomUP1, Simple Code : " + Answer);

		//3-2) BottomUP 방식, 코드 간소화 및 경로 출력준비
		B = new int[N+1][N+1];

		for(int j=0;j<=N;j++)
			B[0][j] = 100000;

		for(int i=0;i<=N;i++)
			B[i][0] = 100000;

		Answer = MatrixShort_BottomUP2();
		System.out.println("3-2) BottomUP2, Simple Code, Path: " + Answer);

		for(int i=1; i<=N; i++){
			for(int j=1; j<=N; j++){
				System.out.printf("%5s", P[i][j]);
			}
			System.out.println();
		}

		//경로 출력(끝에서 처음까지)
		PrintPath();

		System.out.println();

		//경로 출력(처음부터 끝까지)
		PrintPathRecursive(N,N);

	}

	//1) Recursive 방식
	static int MatrixShort_Recursive(int i, int j){
		if (i==1 && j==1){
			return input[i][j];
		}
		else if(i==1){
			return MatrixShort_Recursive(1,j-1) + input[i][j];
		}
		else if(j==1){
			return MatrixShort_Recursive(i-1,j) + input[i][j];
		}
		else{
			return Math.min(MatrixShort_Recursive(i-1,j),
									MatrixShort_Recursive(i,j-1)) + input[i][j];
		}
	}

	//2) Memoization 방식
	static int MatrixShort_Memo(int i, int j){
		if(M[i][j] > -1){
			return M[i][j];
		}
		else if(i==1 && j==1){
			M[i][j] = input[i][j];
		}
		else if(i==1){
			M[i][j] = MatrixShort_Memo(1,j-1) + input[i][j];
		}
		else if(j==1){
			M[i][j] = MatrixShort_Memo(i-1,1) + input[i][j];
		}
		else{
			M[i][j] = Math.min(MatrixShort_Memo(i-1,j),
									  MatrixShort_Memo(i,j-1)) + input[i][j];
		}
		return M[i][j];
	}

	//3) BottomUP 방식
	static int MatrixShort_BottomUP(){
		//행우선 방식으로 처리, 재귀호출 없음(매개변수도 없음)
		for(int i=1; i<=N; i++){
			for(int j=1; j<=N; j++){
				if(i==1 && j==1){
					B[i][j] = input[i][j];
				}
				else if(i==1){
					B[i][j] = B[i][j-1] + input[i][j];
				}
				else if(j==1){
					B[i][j] = B[i-1][j] + input[i][j];
				}
				else{
					B[i][j] = Math.min(B[i-1][j], B[i][j-1]) + input[i][j];
				}
			}
		}
		return B[N][N];
	}

	//3-1) BottomUP 방식 및 코드 간소화
	static int MatrixShort_BottomUP1(){
		//행우선 방식으로 처리, 재귀호출 없음(매개변수도 없음)
		for(int i=1; i<=N; i++){
			for(int j=1; j<=N; j++){
				if(i==1 && j==1){
					B[i][j] = input[i][j];
				}
				else{
					B[i][j] = Math.min(B[i-1][j], B[i][j-1]) + input[i][j];
				}
			}
		}
		return B[N][N];
	}

	//3-2) BottomUP 방식, 코드 간소화 및 경로 출력준비
	static int MatrixShort_BottomUP2(){
		for(int i=1; i<=N; i++){
			for(int j=1; j<=N; j++){
				if(i==1 && j==1){
					B[i][j] = input[i][j];
					P[i][j] = '-';
				}
				else if(B[i-1][j] < B[i][j-1]){
					B[i][j] = B[i-1][j] + input[i][j];
					P[i][j] = '↑';
				}
				else{
					B[i][j] = B[i][j-1] + input[i][j];
					P[i][j] = '←';
				}
			}
		}
		return B[N][N];
	}

	//경로출력하기(끝에서 처음까지)
	static void PrintPath(){
		int i=N;
		int j=N;

		while(P[i][j]!='-'){
			System.out.print("(" + i + ", " + j + ") ");
			if(P[i][j] == '↑'){
				i = i-1;
			}
			else{
				j = j-1;
			}
		}
		System.out.print("(" + i + ", " + j + ")");

	}

	//경로 출력(처음부터 끝까지)
	static void PrintPathRecursive(int i, int j){
		if(i==1 && j==1){
			System.out.print("(" + i + ", " + j + ") ");
		}
		else{
			if(P[i][j]=='↑'){
				PrintPathRecursive(i-1,j);
			}
			else{
				PrintPathRecursive(i,j-1);
			}
			System.out.print("(" + i + ", " + j + ") ");
		}

	}

}
