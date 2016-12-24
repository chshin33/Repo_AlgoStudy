/* 이클립스 및 기본함수
폰트 변경 : General > Appearance > Colors and Font > Basic > Text Font
라인 번호 : General > Editors > Text Editors, Show line number
자동 완성 : Preferences > Java > Editor > Content Assist  
템플릿(Ctrl + space) : Java > Editor > Templates 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class ArrayAndArrayList {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int[] arr2 = new int[5];
		
		//오름차순 정렬
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		ArrayList<Integer> list= new ArrayList<Integer>();
		//배열을 리스트에 넣기
		for(int n : arr){
			list.add(n);
		}
		
		//역순으로 출력
		Collections.reverse(list);
		System.out.println(list);
		
		//배열을 일괄로 복사
		//System.arraycopy(Object src, int srcPos, Object dest, int destPos)
		System.arraycopy(arr, 0, arr2, 0, arr.length);
		
		System.out.println(Arrays.toString(arr2));
		
		//ArrayList 초기화
		list.clear();
		
		int n = 50;
		list.add(new Integer(n));
		for(int val : list){
			System.out.println(val);
		}
				
		ArrayList<String> strlist = new ArrayList<String>();
		
		strlist.add("포도");
		strlist.add("딸기");
		strlist.add("복숭아");

		for (int cnt = 0 ; cnt < strlist.size() ; cnt++){
			String str = strlist.get(cnt);
			System.out.println(str);
		}
		
		Iterator<String> iterator = strlist.iterator();
		
		while(iterator.hasNext())
		{
			String str= iterator.next();
			System.out.println(str);
		}
		
	}
}
