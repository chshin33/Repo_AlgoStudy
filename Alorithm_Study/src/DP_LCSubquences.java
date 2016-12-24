/* Longest Common Subsequences

*/
public class DP_LCSubquences {

	static char[] X = {'A','B','C','B','D','A','B'};
	static char[] Y = {'B','D','C','A','B','A'};
	static int[][] M;
	static char[][] Path;
	static char[] strLCS;
	static int Answer;
	
	public static void main(String[] args) {
		int lenX = X.length;
		int lenY = Y.length;
		
		M = new int[lenX+1][lenY+1];
		Path = new char[lenX+1][lenY+1];
		
		Answer = LCS_Bottomup(lenX, lenY);
		System.out.println("Answer : " + Answer);
		
		//PrintPath(lenX, lenY);
		strLCS = new char[Answer];
		
		//반복문 while 로 출력
		PrintLCS(lenX, lenY);
		System.out.println();
		
		//재귀호출로 출력
		PrintLCS_Recursive(lenX, lenY);
	}
	
	static void PrintLCS_Recursive(int i, int j){
		if(i<1 || j<1){
			return;
		}
		else{
			if(Path[i][j] == '↑'){
				PrintLCS_Recursive(i-1,j);
			}
			else if(Path[i][j] == '←'){
				PrintLCS_Recursive(i,j-1);
			}
			else{
				PrintLCS_Recursive(i-1,j-1);
			}
			char a = X[i-1];
			char b = Y[j-1];
			if(a == b){
				System.out.print(a+ " ");
			}
		}
	}
	
	static void PrintLCS(int i,  int j){
		int pos = 0;
		
		while(i>=1 && j>=1){
			char a = X[i-1];
			char b = Y[j-1];
			if(a == b){
				strLCS[pos] = a;
				pos++;
			}
			if(Path[i][j] == '↑'){
				i = i-1;
			}
			else if(Path[i][j] == '←'){
				j = j-1;
			}
			else{
				i = i-1;
				j = j-1;
			}
		}
		//역순으로 입력되었으니, 역순으로 출력
		//System.out.println(Arrays.toString(strLCS));
		for(int n=strLCS.length-1;n>=0;n--){
			System.out.print(strLCS[n] + " ");
		}
	}
	
	static int LCS_Bottomup(int lenX,  int lenY){
		for(int i=1; i<=lenX; i++){
			for(int j=1; j<=lenY; j++){
				if(X[i-1]==Y[j-1]){
					M[i][j] = M[i-1][j-1] + 1;
					Path[i][j] = '↖';
				}
				else{
					if(M[i-1][j] >= M[i][j-1]){
						M[i][j] =  M[i-1][j];
						Path[i][j] = '↑'; 
					}
					else{
						M[i][j] =  M[i][j-1];
						Path[i][j] = '←'; 
					}
				}
			}
		}
		return M[lenX][lenY];
	}
	
	static void PrintPath(int lenX,  int lenY){
		for(int i=1; i<=lenX; i++){
			for(int j=1; j<=lenY; j++){
				System.out.printf("%5s", Path[i][j]);
			}
				System.out.println();
		}		
	}
	
}
