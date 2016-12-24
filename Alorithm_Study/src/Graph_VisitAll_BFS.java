import java.util.ArrayDeque;
import java.util.ArrayList;

public class Graph_VisitAll_BFS {
	
	static int V=5;
	static int[] discovered = new int[V+1];
	
	//ArrayList를 ArrayList로 선언한다!!!
	static ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
	
 	static ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

	public static void main(String[] args) {

		for(int i=1;i<=V+1;i++){
			adjList.add(new ArrayList<Integer>());
		}
		
		adjList.get(1).add(2);
		adjList.get(1).add(3);
		
		adjList.get(2).add(1);
		adjList.get(2).add(3);
		
		adjList.get(3).add(1);
		adjList.get(3).add(2);
		adjList.get(3).add(4);
		adjList.get(3).add(5);
		
		adjList.get(4).add(3);
		
		adjList.get(5).add(3);
		
				
		for(int i=1; i<=V; i++){
			discovered[i] = 0;
		}
		BFS();
	}
	
	static void BFS(){
		queue.add(1);
		discovered[1] = 1;
		
		int node;
		
		while(queue.size() > 0){
			node = queue.pollFirst();
			
			//출력
			System.out.print(node + " ");
			
			if(adjList.get(node).size()>0)
				for(int adjacent : adjList.get(node)){
					if(discovered[adjacent] == 0 ){
						queue.add(adjacent);
						discovered[adjacent] = 1;
					}
				}
			}
	}
}
