import java.util.HashMap;
import java.util.HashSet;



public class Hash {

	public static void main(String[] args) {

		HashMap<String, Integer> hashtable = new HashMap<String, Integer>();
		
		hashtable.put("aaa", new Integer(95));
		hashtable.put("bbb", 100);
		hashtable.put("ccc", 1);
		hashtable.put("ddd", new Integer(20));
		hashtable.put("eee", new Integer(50));
		
		System.out.println(hashtable.get("ccc"));
		
	}

}
