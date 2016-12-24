/* 동적계획법 : 행렬들의 곱셈의 최소 회수
 M[i,j] : AiAi+1....Aj 를 곱하는 최소 곱셈회수
 
 M[i,j] = ┌  0                                                                if i=j
             │  Min            (M[i,k] + M[k+1,j] + Pi-1PkPj)   if i<j
             └  i<=k<=j-1
출처 : 권오흠, https://www.youtube.com/watch?v=n_3E2-UhLeU
 */
public class DP_MatrixChainMulti {
	
	static int N=6;
	static int[][] M = new int[N+1][N+1]; //메모이제이션 배열
	static int[] P = {6,3,4,5,3,4,5}; //각 배열의 크기 Ak = Pk-1Pk, A1=PoP1, A2=P1P2
	static int Answer;

	public static void main(String[] args) {
		Answer = MatrixChain();
		
		System.out.println(Answer);//A1부터 An까지의 곱셈의 최소 회수
	}
	
	public static int MatrixChain(){
		for(int i=1; i<=N; i++){
			M[i][i] = 0;
		}
		for(int r=1; r<=N-1; r++){
			for(int i=1; i<=N-r; i++){
				int j = r+i;
				M[i][j] = M[i+1][j] + P[i-1]*P[i]*P[j];
				for(int k=i+1; k<=j-1; k++){
					if(M[i][j] > M[i][k] + M[k+1][j] + P[i-1]*P[k]*P[j]){
						M[i][j] = M[i][k] + M[k+1][j] + P[i-1]*P[k]*P[j];
					}
				}
			}
		}
		return M[1][N];
	}
}
