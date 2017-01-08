
public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//숫자배열을 문자열로 만들고, 문자열을 10진수로 나타내고, ArrayList에 기존것과 비교하고
		//없으면 추가하고, Answer+1 처리
		
		int[] list = {1,2,12};
		
		String str = "";
		for(int i = 0 ; i < list.length ; i ++){
			str = str + list[i];
		}
		
		System.out.println(str);
		
		System.out.println(Integer.parseInt(str));
	}
	
}
