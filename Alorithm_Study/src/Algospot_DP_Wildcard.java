/* 와일드 카드(문제ID: WILDCARD)
패턴에 대응되는 파일들의 이름을 한줄에 하나씩 알파펫 순서대로 출력
he?p
3
help
heap
helpp
*p*
3
help
papa
hello
 */
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Algospot_DP_Wildcard {	
	static int[][] M = new int[101][101];
	static String W;
	static String S;	
	static boolean bAnswer;
	static int nAnswer;
	static int cnt=0;
	
	static ArrayList<String> input = new ArrayList<String>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("Algospot_WildCard.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		long startTime = System.currentTimeMillis();

		for(int test_case=1; test_case<=T; test_case++){
			//와일드카드 문자열
			W = sc.next();
			//대상 문자열 개수
			int cntString = sc.nextInt();
			
			input.clear();
			for(int string_case=1; string_case <= cntString; string_case++){
				input.add(sc.next());
			}
			
			//1) 완전탐색
			for(int i=0; i<input.size(); i++){
				S = input.get(i);
				bAnswer = match(W, S);
				if(bAnswer == true){
					if(i == 0)
						System.out.println("#" + test_case + " 완전탐색\n" + S);
					else
						System.out.println(S);			
				}	
			}
			
			//2)동적계획
			for(int i=0; i<input.size(); i++){
				S = input.get(i);
				for(int m=0;m<=100;m++){
					for(int n=0; n<=100; n++){
						M[m][n] = -1;
					}
				}
				nAnswer = matchMemoized(0,0);
				if(nAnswer == 1) {
					if(i == 0)
						System.out.println("#" + test_case + " 동적계획\n" + S);
					else
						System.out.println(S);
				}
			}			
		}
		//소요시간 구하기
		System.out.println("Time: "+(System.currentTimeMillis()-startTime)/1000.0 );
		sc.close();
	}//end of main
	
	//동적계획법
	public static int matchMemoized(int w, int s){
		if(M[w][s] != -1) return M[w][s];
		while(w < W.length() && s < S.length() && 
				(W.charAt(w) == '?' || W.charAt(w) == S.charAt(s))){
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
		while(pos< w.length() && pos<s.length() &&
				(w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos))){
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
