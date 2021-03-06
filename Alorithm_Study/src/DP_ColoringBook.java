/* 동적계획법, 백준 9521
 https://www.acmicpc.net/problem/9521

상근이는 시간이 날 때마다 색칠 공부를 하고 있다. 상근이는 총 K개의 색이 담겨있는 팔레트를 가지고 있고, 
붓을 이용해 색칠을 한다. 상근이의 친구 선영이는 상근이의 생일 선물로 색칠 공부 책을 선물했다. 
책에는 그림이 총 N개 있으며, 1번부터 N번까지 번호가 붙여져 있다.

상근이는 각각의 그림을 K가지 색 중 하나를 골라 색칠하려고 한다. 
선영이는 화려한 것을 좋아하기 때문에 상근이에게 숫자 N개 f[i]를 정해주었다. 
상근이는 i번 그림을 f[i]번 그림과 다른 색으로 색칠해야 한다. 
f[i] = i 경우에 아무런 제한없이 i번 그림을 색칠할 수 있다.

N과 K, 그리고 fi가 모두 주어졌을 때, 상근이가 색칠 공부 책을 색칠하는 방법의 수를 구하시오

입력 : 첫째 줄에 N과 K(1 ≤ N, K ≤ 1,000,000) 둘째 줄에는 숫자 N개 fi가 주어진다. (1 ≤ fi ≤ N)
출력 : 첫째 줄에 색칠 공부 책을 색칠하는 방법의 수를 출력한다. 
방법의 수가 매우 많기 때문에 1,000,000,007로 나눈 나머지를 출력한다. 
(입력)                                  (입력)
2 3                                      3 4
2 1                                      2 1 1
(출력)                                  (출력)
6                                         36
*/
public class DP_ColoringBook {

	public static void main(String[] args) {

	}

}
