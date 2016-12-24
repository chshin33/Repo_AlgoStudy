
public class Math_ex {

	public static void main(String[] args) {

		double n = 2.34456565;
		
		System.out.println(n);
		
		//소수 4번째 자리에서 반올림하여 출력
		n = Math.round(n*1000);
		n = n/1000;
		
		System.out.println(n);
		
		/*double k;
		k = n/1000;
		//System.out.println(n);
		//System.out.println(n/1000);
		System.out.println(k);	
	*/}

}
