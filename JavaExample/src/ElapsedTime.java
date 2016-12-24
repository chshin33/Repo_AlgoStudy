
public class ElapsedTime {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		//2,000,000,000
		for(int i =0; i < 2100000000 ; i++){
			;
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("Elapsed Time : " + (end-start)/1000.0);
		
		System.out.println("Elapsed Time : " + (double)(end-start)/1000);

	}

}
