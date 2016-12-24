import java.io.FileInputStream;
import java.util.Scanner;

public class Bjo_DP_1004_Fibonacci {

	static int N;
	static int Answer0 = 0;
	static int Answer1 = 0;
	
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("Bjo_1004_Fibonacci.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++){
			N = sc.nextInt();
			
			Answer0 = 0;
			Answer1 = 0;
			int val = fibonacci(N);
			System.out.println(Answer0 + " " + Answer1);
		}
	}
	
	public static int fibonacci(int n) {
	    if (n==0) {
	    	Answer0++;
	        return 0;
	    } else if (n==1) {
	    	Answer1++;
	        return 1;
	    } else {
	        return fibonacci(n-1) + fibonacci(n-2);
	    }
	}	
}
