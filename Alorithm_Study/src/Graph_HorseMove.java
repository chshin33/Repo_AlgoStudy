import java.util.ArrayDeque;

public class Graph_HorseMove {
	
	static int N = 4;
	static int[][] input = {
									{0, 0, 0, 0, 0},
									{0, 1, 2, 0, 3},
									{0, 1, 3, 2, 1},
									{0, 2, 3, 2, 3},
									{0, 1, 2, 1, 1},
									};
	
	static int[][] discovered = new int[N+1][N+1];
	static int[][] parent = new int[N+1][N+1];
	
	static ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
	static int Answer=0;
	
	public static void main(String[] args) {
		Answer = 	BFS();
		System.out.println("Answer : " + Answer);
		
		printPath(N,N);
	}
	
	public static int BFS(){
		queue.clear();
		
		for(int i=1; i<=N; i++)
			for(int j=1; j<=N; j++)
				discovered[i][j]=0;
		
		queue.add((N+1)*1+1);
		
		int tmp;
		int row;
		int col;
		
loop: while(queue.isEmpty() == false){
			tmp = queue.poll();
			row = tmp / (N+1);
			col = tmp % (N+1);
			
			//아래쪽 인접칸들을 탐색
			for(int i=1; i <= input[row][col]; i++){
				if(row + i > N){
					break;
				}
				if(discovered[row+i][col] == 0 ) {//방문하지 않았다면
					discovered[row+i][col] = discovered[row][col] + 1;
					queue.add((row+i)*(N+1) + col);
					
					parent[row+i][col] = row *(N+1) + col; 
					
					
					//최종지점 확인
					if(row + i == N && col == N){
						break loop;
					}
				}
			}
			
			//오른쪽 인접칸들을 탐색
			for(int j=1; j<= input[row][col] ; j++){
				if(col + j > N){
					break;
				}
				if(discovered[row][col + j] == 0){//방문하지 않았다면
					discovered[row][col +j] = discovered[row][col] + 1;
					queue.add(row*(N+1) + (col + j));
					
					parent[row][col+j] = row *(N+1) + col;
					
				}
				//최종지점 확인
				if(col + j == N && row == N ){
					break loop;
				}
			}
		}//end of while
		
		return discovered[N][N];
	}
	
	static void printPath(int row, int col){
		if(parent[row][col] != 0 ){
			printPath(parent[row][col] / (N+1), parent[row][col] % (N+1));
		}
		System.out.printf("[%d, %d]", row, col);
	}
}
