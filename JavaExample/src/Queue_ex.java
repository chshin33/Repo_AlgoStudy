import java.util.*;
public class Queue_ex {
	
	public static void main(String args[]){
		
		LinkedList<String> queue = new LinkedList<String>();
		
		queue.offer("토끼");
		queue.offer("사슴");
		queue.offer("호랑이");
		
		System.out.println("Peek:" + queue.peek());
		
		while(!queue.isEmpty()){
			String str = queue.poll();
			System.out.println(str);
		}
	}
}