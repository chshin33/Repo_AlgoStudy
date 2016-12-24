import java.io.FileInputStream;
import java.util.Scanner;

/*
가끔 TV 에 보면 원주율을 몇만 자리까지 줄줄 외우는 신동들이 등장하곤 합니다. 
이들이 이 수를 외우기 위해 사용하는 방법 중 하나로, 숫자를 몇 자리 이상 끊어 외우는 것이 있습니다. 
이들은 숫자를 세 자리에서 다섯 자리까지로 끊어서 외우는데, 가능하면 55555 나 123 같이 외우기 
쉬운 조각들이 많이 등장하는 방법을 택하곤 합니다.
이 때, 각 조각들의 난이도는 다음과 같이 정해집니다:
1.모든 숫자가 같을 때 (예: 333, 5555) 난이도: 1
2.숫자가 1씩 단조 증가하거나 단조 감소할 때 (예: 23456, 3210) 난이도: 2
3.두 개의 숫자가 번갈아 가며 출현할 때 (예: 323, 54545) 난이도: 4
4.숫자가 등차 수열을 이룰 때 (예: 147, 8642) 난이도: 5
5.그 외의 경우 난이도: 10
원주율의 일부가 입력으로 주어질 때, 난이도의 합을 최소화하도록 숫자들을 3자리에서 5자리까지 
끊어 읽고 싶습니다. 최소의 난이도를 계산하는 프로그램을 작성하세요.
입력
입력의 첫 줄에는 테스트 케이스의 수 C (<= 50) 가 주어집니다. 각 테스트 케이스는 
8글자 이상 10000글자 이하의 숫자로 주어집니다.
출력
각 테스트 케이스마다 한 줄에 최소의 난이도를 출력합니다.
5 
12341234 
11111222 
12122222 
22222222 
12673939
4
2
5
2
14
 */
public class Algospot_DP_PI {

	static String N;
	static int Answer;
	static int[] cache;
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("Algospot_PI.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case=1; test_case <= T ; test_case++){
			N = sc.next();
			cache = new int[N.length()];
			for(int i=0; i<cache.length; i++){
				cache[i] = -1;
			}
			
			Answer = memorize(0);
		}
		sc.close();
	}
	
	static int memorize(int begin){
		if(begin == N.length()) return 0;
		if(cache[begin] != -1) return cache[begin];
		
		cache[begin] = INF;
		for(int L=3; L<=5; L++){
			if(begin + L <=N.length()){
				cache[begin] = Math.min(cache[begin], memorize(begin+L) + classify(begin, begin+L-1) );
			}
		}
		return cache[begin];
	}
	
	static int  classify(int a, int b){
		String M = N.substring(a, b-a+1);//substring함수는 start부터 끝점 -1 까지 문자열 생성
		
		//모든 숫자가 같을때 : 1
		boolean same = true;
		for(int i=0; i < M.length()-2;i++){
			if(M.charAt(i) != M.charAt(i+1)) same = false;
		}
		if (same==true) return 1;
		
		//등차수열
		boolean progressive = true;
		for(int i=0; i < M.length() - 1; i++){
			if(M.charAt(i+1) - M.charAt(i) != M.charAt(1) - M.charAt(0)) progressive = false; 
		}
		//등차수열이고, 공차가 1또는 -1 이면 난이도 2
		if(progressive == true && Math.abs(M.charAt(1) - M.charAt(0))==1){
			return 2;
		}
		//두수가 번갈아 나오면 4
		boolean alternating = true;
		for(int i = 0; i < M.length(); i++){
			if(M.charAt(i) != M.charAt(i%2)){
				alternating = false;
			}
		}
		if(alternating) return 4;
		if(progressive) return 5;
		return 10;
	}
}
