package coding;
import java.util.*;

public class charCount {

	public static void main(String[] args) {
		//Mississipi 
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();
		HashMap<Character, Integer> map = new HashMap<Character,Integer>();
		char max_key = ' ';
		int max = 0;
		int max_count = 0;
		for(int i=0; i<word.length(); i++) {
			char key = word.charAt(i);
			if((97 <= key) && (key <= 122)) { //대문자로 변경 
				key = (char) (key - 32);
			} 
			if(map.get(key) != null) { //만약 해당되는 키를 가지는 값이 있다면
				map.put(key,map.get(key)+1); //원래 count에 + 1 후, 다시 넣어줌
				if(map.get(key)+1 > max) { // 만약 현재 키값의 count가 가장 큰값이라면
					max = map.get(key) + 1; // max값을 최신화 시켜줌
					max_key = key; // 최댓값을 가지는 키
					max_count = 1;  // 최댓값을 가지고 있는 키값들의 갯수 = 1
				} 
				else if(map.get(key) + 1 == max) { //만약 현재 키의 값이 최댓값과 같다면 	
					max_count++;  // max_count 증가
				}
			}
			else {
				map.put(key,1);
				if(1 > max) {
					max = 1;
					max_key = key;
					max_count = 1;
				} 
				
				else if(1 == max) {
					max_count++;
				}
			}
		}
		if(max_count > 1) {
			System.out.println("?");
			return;
		}
		
		System.out.println(max_key);
		
		

	}

}
