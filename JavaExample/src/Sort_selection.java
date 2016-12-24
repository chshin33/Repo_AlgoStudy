
public class Sort_selection {

	public static void main(String[] args) {

		int[] list = {9,4,5};
		
		int C = 3;
		
		//선택정렬
		for(int i=0; i<C-1;i++){
			for(int j=i+1; j<C;j++){
				if(list[i] > list[j]){
					int tmp = list[j];
					list[j] = list[i];
					list[i] = tmp;
				}
			}
		}
		
		//출력
		for(int n : list){
			System.out.print(n);
		}
		
	}

}
