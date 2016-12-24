import java.util.*;

public class LinkedList_ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> nlist = new ArrayList<Integer>();
		
		int n = 50;
		
		nlist.add(new Integer(n));
		
		for(int val : nlist){
			System.out.println(val);
		}
				
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("포도");
		list.add("딸기");
		list.add("복숭아");
		

		int num = list.size();
		
		for (int cnt = 0 ; cnt < num ; cnt++){
			String str = list.get(cnt);
			System.out.println(str);
		}
		
		System.out.println();
		
		for(String str : list){
			System.out.println(str);
		}
		
		list.clear();
		
		list.add("망고");
		list.add("파인애플");
		list.add("바나나");
		
		for(String str : list){
			System.out.println(str);
		}
		
		Iterator<String> iterator = list.iterator();
		
		while(iterator.hasNext())
		{
			String str= iterator.next();
			System.out.println(str);
			
		}

	}
	

}
