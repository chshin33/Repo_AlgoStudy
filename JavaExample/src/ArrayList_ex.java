import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayList_ex {
	
	public static void main(String[] args) {
		/*
		int[] arr = {1,2,3,4,5};
		int[] arr2 = new int[5];
		
		//오름차순 정렬
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
		
		ArrayList<Integer> list= new ArrayList<Integer>();
		
		//배열을 리스트에 넣기
		for(int n : arr){
			list.add(n);
		}

		//역순으로 출력
		Collections.reverse(list);
		System.out.println(list);
		
		//배열을 일괄로 복사
		//System.arraycopy(Object src, int srcPos, Object dest, int destPos)
		System.arraycopy(arr, 0, arr2, 0, arr.length);
		
		System.out.println(Arrays.toString(arr2));*/
		
/*		int number = 10;
		List<Integer> [] outer = new List[number];
		 for (int i =0 ; i< number ;i++) {
		        outer[i] = new ArrayList<>();
		}
		 */
		 
		
		 ArrayList<ArrayList<Integer>> group = new ArrayList<ArrayList<Integer>>();

		 ArrayList<Integer> adjList1= new ArrayList<Integer>();
		 adjList1.add(1);
		 adjList1.add(2);
		 adjList1.add(3);
		 group.add(adjList1);
		 
		 ArrayList<Integer> adjList2 = new ArrayList<Integer>();
		 adjList2.add(4);
		 adjList2.add(5);
		 adjList2.add(6);
		 group.add(adjList2);
		 
		 for(int i=0;i<group.size();i++){
			 for(int j=0; j<group.get(i).size(); j++){
				 System.out.print(group.get(i).get(j) + " ");
			 }
			 System.out.println();
		 }
		 
		
	}
}
