/* 부분합(Partial Sum)
 1) 구간합(Range Sum)
 2) 분산
      V = (1/b-a+1) * { ∑( A[i] - Ma,b)^2 }   단,  a <= i <= b
         = (1/b-a+1) * { ∑(A[i])^2 - 2*Ma,b*∑A[i] - (b-a+1)*(Ma,b)^2 }
  엑셀 함수명은 : VARP 임(VAR아니고 전체모수인 VARP임!!)
 */
import java.util.Arrays;

public class PartialSum {
	static int Answer;
	static double dAnswer;
	static int[] psum;
	static int[] sqinput;
	static int[] sqsum;
	public static void main(String[] args) {
		
		int[] input = {100, 97, 86, 79, 66, 52, 49, 42, 31};
//		int[] input = {1,2,3,4,5};
		System.out.println("array:" + Arrays.toString(input));
		
		int N = input.length;
		psum = new int[N];
		
		psum[0] = input[0];
		for(int i=1; i<N; i++){
			psum[i] = psum[i-1] + input[i];
		}
		System.out.println("psum:" + Arrays.toString(psum));

		//1) 구간합(Range)
		int start=2, end=6;
//		int start=0, end=8;
		Answer = rangeSum(start, end);
		System.out.println("rangeSum(" + start+"~" + end + "): " + Answer);
		
		//2) 분산
		sqinput = new int[N];
		sqsum = new int[N];
		for(int i=0; i<N; i++){
			sqinput[i] = input[i]*input[i];
		}
		System.out.println("sqinput:" + Arrays.toString(sqinput));
		
		sqsum[0] = sqinput[0];
		for(int i=1; i<N; i++){
			sqsum[i] = sqsum[i-1] + sqinput[i];
		}
		System.out.println("sqsum:" + Arrays.toString(sqsum));
		
		dAnswer = variance(start, end);
		System.out.printf("varience(%d~%d): %.2f", start, end, dAnswer);
	}
	
	static int rangeSum(int a, int b){
		if(a==0) 
			return psum[b];
		else
			return psum[b] - psum[a-1];
	}
	
		
	
	
	static int rangeSquareSum(int a, int b){
		if(a==0) 
			return sqsum[b];
		else
			return sqsum[b] - sqsum[a-1];
	}	
	
	static double variance(int a, int b){
		// V = (1/b-a+1) * { ∑(A[i])^2 - 2*Ma,b*∑A[i] - (b-a+1)*(Ma,b)^2 }
		// Ma,b = ∑ A[i] / (b-a+1)
		//System.out.println("rangeSum(a, b):" + rangeSum(a, b));
		//System.out.println("(b -a+1):" + (b-a+1));
		double mean = (double) rangeSum(a, b) / (b -a+1); //double에 괄호 유의!!!
		System.out.printf("mean:%.2f\n", mean);
		double ret = rangeSquareSum(a,b) -2*mean*rangeSum(a,b) 
							+ (b-a+1)*mean*mean;
		
		return (double) ret / (b-a+1);
	}

}
