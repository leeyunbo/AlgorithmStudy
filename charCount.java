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
			if((97 <= key) && (key <= 122)) { //�빮�ڷ� ���� 
				key = (char) (key - 32);
			} 
			if(map.get(key) != null) { //���� �ش�Ǵ� Ű�� ������ ���� �ִٸ�
				map.put(key,map.get(key)+1); //���� count�� + 1 ��, �ٽ� �־���
				if(map.get(key)+1 > max) { // ���� ���� Ű���� count�� ���� ū���̶��
					max = map.get(key) + 1; // max���� �ֽ�ȭ ������
					max_key = key; // �ִ��� ������ Ű
					max_count = 1;  // �ִ��� ������ �ִ� Ű������ ���� = 1
				} 
				else if(map.get(key) + 1 == max) { //���� ���� Ű�� ���� �ִ񰪰� ���ٸ� 	
					max_count++;  // max_count ����
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
