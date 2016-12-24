import java.io.FileInputStream;
import java.util.Scanner;

public class Algospot_DP_Wildcard {
	
	static int[][] M = new int[101][101];
	static String W;
	static String S;	
	static boolean bAnswer;
	static int nAnswer;
	static int cnt=0;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("Algospot_WildCard.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		long startTime = System.currentTimeMillis();

		for(int test_case=1; test_case<=T; test_case++){
			W = sc.next();
			int cntString = sc.nextInt();
			for(int string_case=1; string_case <= cntString; string_case++){
				S = sc.next();
				
				for(int i=0;i<=100;i++){
					for(int j=0; j<=100; j++){
						M[i][j] = -1;
					}
				}

				//완전탐색
//				bAnswer = match(W, S);
//				if(bAnswer == true) System.out.println(S);
				
				//동적계획법
				nAnswer = matchMemoized(0,0);
				if(nAnswer == 1) System.out.println(S);
			}
		}

		//소요시간 구하기
		//System.out.println("Elapsed Time: " + (System.currentTimeMillis() - startTime)/1000.0 );
		sc.close();
	}//end of main
	
	//동적계획법
	public static int matchMemoized(int w, int s){
		if(M[w][s] != -1) return M[w][s];
		while(w < W.length() && s < S.length() && (W.charAt(w) == '?' || W.charAt(w) == S.charAt(s))){
			w++;
			s++;
		}
		if( w==W.length()){
			if(s==S.length()){
				return 1;
			}
			return 0;
		}
		if(W.charAt(w) == '*'){
			for(int skip=0; s + skip <= S.length(); skip++){
				if(matchMemoized(w+1, s + skip) == 1){
					return 1;
				}
			}
		}
		return 0;
	}
	
	//완전탐색
	public static boolean match(String w, String s){
		int pos = 0;
		cnt++;
		while(pos< w.length() && pos<s.length() && (w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos))){
			pos++;
		}
		
		if(pos == w.length()){
			if(pos==s.length())
				return true;
			else
				return false;
		}
		
		if(w.charAt(pos) =='*'){
			String wsub, filesub;
			for(int skip=0; pos+skip <= s.length(); skip++){
				wsub = w.substring(pos+1);
				filesub = s.substring(pos+skip);
				if(match(wsub, filesub)){
					return true;
				}
			}
		}
		return false;
	}
	

}
