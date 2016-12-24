import java.util.ArrayList;

public class Graph_VisitAll_DFS {
	
	static int V = 5;
	static int[] visited = new int[V+1];
	
	//static ArrayList<Integer>[] adjList = new ArrayList[V+1];
	
	//ArrayList의 배열을 사용하지 않고, ArrayList의 ArrayList사용하도록 변경
	static ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) {
		
		for(int i=1; i <= V+1 ; i++){
			adjList.add(new ArrayList<Integer>());	
		}
		
		adjList.get(1).add(2);
		adjList.get(1).add(3);
		
		adjList.get(2).add(3);
		adjList.get(2).add(1);
		
		adjList.get(3).add(1);
		adjList.get(3).add(2);
		adjList.get(3).add(4);
		adjList.get(3).add(5);
		
		adjList.get(4).add(3);
		
		adjList.get(5).add(3);
		
		for(int i=1; i<=V; i++){
			visited[i] = 0;
		}
		
		DFS(1);
		
	}
	
	public static void DFS(int n) {
		visited[n] = 1;
		System.out.print(n + " ");
		
		if(adjList.get(n) != null){
			for(int adjacent : adjList.get(n)){
				if(visited[adjacent] == 1){
					continue;
				}
				else{
					DFS(adjacent);
				}
			}
		}
	}

}
