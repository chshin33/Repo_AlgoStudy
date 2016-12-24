import java.util.ArrayList;

public class Graph_FindCycle {
	
	static int V = 5;
	
	//ArrayList를 ArrayList로 선언한다!!!
	static ArrayList<ArrayList<Integer>> adjList;
	
	static int[] visited = new int[V+1];
	static int[] onstack = new int[V+1];
	static int[] parent = new int[V+1];
	static int visitedCnt = 1;
	
	static boolean found = false;
	
	public static void main(String[] args){
		//ArrayList를 ArrayList로 선언
		adjList = new ArrayList<ArrayList<Integer>>();
		
		for(int i=1; i<=V+1; i++){
			ArrayList<Integer> adjacent = new ArrayList<Integer>();
			adjList.add(adjacent);
		}
		
		adjList.get(2).add(1);//이해하기 쉽게 첫째자리 부터 시작
		adjList.get(3).add(1);
		adjList.get(3).add(2);
		adjList.get(3).add(5);
		adjList.get(4).add(3);
		adjList.get(5).add(4);
		
		for(int i=1; i <= V; i++){
			if(found){
				break;
			}
			else{
				if(visited[i] == 0){
					DFS(i);
				}	
			}
		}
	}
	
	public static void DFS(int node){
		onstack[node] = 1;
		visited[node] = visitedCnt;
		visitedCnt++;
		
		if(adjList.get(node).size() > 0){
			for(int adjacent : adjList.get(node)){
				if(visited[adjacent] == 0 ){//방문하지 않은 정점일 경우
					parent[adjacent] = node;
					DFS(adjacent);
					if(found==true){
						return;
					}
				}
				else if(onstack[adjacent] ==1 &&
						visited[adjacent] < visited[node]){
					//현재 탐색 중인 경로 상에서 인접 노드 방문시기가 현재 노드보다 이전것이라면
					found = true;
					//싸이클 출력
					printPath(adjacent, node);
					return;
				}
			}
		}//end if
		
		//인접노트가 없다면 초기화
		onstack[node] = 0;
	}
	
	public static void printPath(int start, int end){
		if(start != end){
			printPath(start, parent[end]);
		}
		System.out.print(end + " ");
	}

}

