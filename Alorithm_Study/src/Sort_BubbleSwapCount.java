import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Sort_BubbleSwapCount {
	
	
	static int N;
	static int Answer1;
	static int Answer2;
	
	static int[] input;
	static int[] copyinput;
	
	static final int MAX = 10000000;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("sample_BubbleSortSwap.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		long startTime = System.currentTimeMillis();
		
		for(int test_case = 1; test_case <=T; test_case++){
			N = sc.nextInt();
			input = new int[N+1];
			copyinput = new int[N+1];
			
			for(int i=1; i<=N; i++){
				input[i] = sc.nextInt();
			}
			
			//미정렬 상태에서의 교환회수
			//배열복사
			System.arraycopy(input, 0, copyinput, 0, input.length);
			//System.out.println(Arrays.toString(copyinput));//정렬 전 확인
			int beforeCnt = BubbleSort(copyinput);
			//System.out.println(Arrays.toString(copyinput));//정렬 후 확인
			
			//System.out.println("beforeCnt: " + beforeCnt);//미정렬 상태에서의 교환회수
			
			if(beforeCnt==0){
				Answer1 = 0;
				Answer2 = 0;
				System.out.println("#"+ test_case + " " + Answer1 + " " + Answer2);
			}
			else{
				//5개 중 2개 골라 자리바꾸고, 최소 교환회수 구하기
				//조합을 for 문으로 구함.
				int minCount = MAX;
				int checkCount = 0;
				
				for(int i=1; i<=N-1; i++){
					for(int j = i+1; j<=N; j++){
						System.arraycopy(input, 0, copyinput, 0, input.length);
						int tmp = copyinput[j];
						copyinput[j] = copyinput[i];
						copyinput[i] = tmp;
						//System.out.print(Arrays.toString(copyinput));
						int cnt = BubbleSort(copyinput, minCount);
						if(cnt < minCount){
							checkCount = 1;
							minCount = cnt;
						}
						else if(cnt == minCount){
							checkCount++;
						}
						//System.out.println("==>cnt: " + cnt + ", minCount: " + minCount + ", checkCount: " + checkCount);
					}
				}
				
				Answer1 = beforeCnt - minCount;
				Answer2 = checkCount;
				
				System.out.println("#"+ test_case + " " + Answer1 + " " + Answer2);
			}
		}
		System.out.println("Elapsed Time: " + (System.currentTimeMillis() - startTime)/1000.0 );
		sc.close();
	}//end of main
	
	
	public static int BubbleSort(int[] listinput, int mincnt){
		//교환 발생하는 회수
		int count=0;
		
		for(int i=1; i<=N-1; i++){
			for(int j=1; j<=N-i; j++){
				if(listinput[j] > listinput[j+1]){
					int tmp = listinput[j+1];
					listinput[j+1] = listinput[j];
					listinput[j] = tmp;
					count++;
					if(count > mincnt){
						return MAX;
					}
				}
			}
		}
		return count;
	}
	
	public static int BubbleSort(int[] listinput){
		//교환 발생하는 회수
		int count=0;
		
		for(int i=1; i<=N-1; i++){
			for(int j=1; j<=N-i; j++){
				if(listinput[j] > listinput[j+1]){
					int tmp = listinput[j+1];
					listinput[j+1] = listinput[j];
					listinput[j] = tmp;
					count++;
				}
			}
		}
		return count;
	}

}
