
public class Math_ex {

	public static void main(String[] args) {
		
		double n = (double)2/3;
		System.out.println(n);
		
		n = 2.34476565;
		
		System.out.println(n);
		
		//소수 4번째 자리에서 반올림하여 3째자리까지 출력
		double m = Math.round(n*1000);
		m = m/1000;
		
		System.out.println(m);
		
		//prinf 속성이용
		System.out.printf("%.3f  \n", n);

		//정수형
		int n1 = Integer.MIN_VALUE;
		int n2 = Integer.MAX_VALUE;
		System.out.println("int 형(4byte) 표현범위 : " + n1 + " ~ " + n2);
		
		//long을 초기화 하기위해서는 숫자옆에 L을 붙여야 한다. 안붙이면, 컴파일러는 정수로 처리함
		long num = 987654321987654321L;
//		long num2 = 987654321987654321;
		System.out.println(num);
		
		long num3 = Long.MAX_VALUE;
		long num4 = Long.MIN_VALUE;
		System.out.println("long형(8byte) 표현범위 : " + num4 + " ~ " + num3);
		
	}
}
