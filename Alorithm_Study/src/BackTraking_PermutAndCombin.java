/* 순열 및 조합 출력

 nPr = n! / (n-r)!
 
 nCr = n! / r!*(n-r)!
 
 */
import java.util.Arrays;

public class BackTraking_PermutAndCombin {

	static int N;
	static int R;
	static int[] sol;
	static int[] visited;
	static int idx;
	
	public static void main(String[] args) {
		N=4;
		R=3;
		sol = new int[R];
		
		//1)조합 : nCr, For문으로  구하기
		idx = 1;
		System.out.println("조합 : FOR문으로");
		for(int i =0; i <= N-R; i++){
			for(int j=i+1; j <= N-R+1; j++){
				for(int k=j+1; k <= N-R+2; k++){
					System.out.println(idx + " : [" + i + ", " + j + ", " + k + "]");
					idx++;
				}
			}
		}
		
		//2)조합 : nCr, 재귀호출
		idx = 1;
		System.out.println("조합 : 재귀호출");
		Combi(0, R);
		
		//3)순열 : nPr, n==r 일때
		visited = new int[N];
		sol = new int[N];
		System.out.println("순열 :  " + N + "P" + N + ", n==r ");
		idx = 1;
		perm(0);

		//4)순열 : nPr, n > r 일때
		sol = new int[R];
		System.out.println("순열 :  " + N + "P" + R + ", n > r ");
		idx = 1;
		perm(0,R);		
	}
	
	//조합 : nCr, 재귀호출
	public static void Combi(int start, int R){
	       if (R == 0){
	           process(); 
	            return;
	        }       
	        for (int i = start; i <= N - R; i++){
	        	int len = sol.length;
	        	sol[len - R] = i+1;
	            //재귀호출
	            Combi(i+1, R-1);
	        }
	}
	
	//순열 : nPr, n==r 일때
	public static void perm(int n){
		if(n==N){
			process();
			return;
		}
		else{
			for(int i=0; i < N ; i++){
				if(visited[i] ==0){
					sol[n] = i+1;
					visited[i]=1;
					perm(n+1);
					visited[i]=0;
				}
			}
		}
	}
	
	//순열 : nPr, n > r 일때
	public static void perm(int n, int R){
		if(R==0){
			process();
			return;
		}
		else{
			for(int i = 0 ; i < N ; i++){
				if(visited[i] == 0 ){
					sol[n] = i+1;
					visited[i] = 1;
					perm(n+1,R-1);
					visited[i] = 0;
				}
			}
		}
	}	
	
	public static void process(){
		System.out.printf("%d : ", idx++);
		System.out.println(Arrays.toString(sol));
	}
}



