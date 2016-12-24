import java.util.ArrayList;
import java.util.Iterator;


public class Iter_ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(10);
		list.add(20);
		list.add(30);

		
		Iterator<Integer> iter = list.iterator();
		
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		System.out.println( list.contains(20));
		
		System.out.println( list.contains( Integer.valueOf(20) ));
		
		System.out.println(list.contains(50));
		

	}

}
