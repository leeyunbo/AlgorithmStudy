package dongwon;

// 1. �� ���ڿ��� ���̿� ª�� ���ڿ��� ���̸� ������ �� �������� 0�� �ƴϸ�, ���� ����� ���ü��� ����.
// 1-1. ������ ���࿡ ª�� ���ڿ��� �ϳ��� ���ڷθ� �̷���� �ִٸ� ���� ����� ������ ��쵵 �ִ�. 
// 2. ª�� ���ڿ� ���̸� �� ���ڿ��� ���̷� ���� �� ��ŭ ª�� ���ڿ��� �ݺ����� �� �� ���ڿ��� �Ȱ��� ����ٸ� ������ ����.

public class InfiniteSame2 {

	public static void main(String[] args) {
		String s = "AA";
		String t = "AAA"; 
		String shortWord, longWord; 
		boolean answer = true; 
		
		if(s.length() > t.length()) {
			longWord = s;
			shortWord = t; 
		}
		else {
			longWord = t;
			shortWord = s; 
		}
		
		if(longWord.length() % shortWord.length() != 0 && shortWord.charAt(0) != shortWord.charAt(1)) {
			answer = false; 
		}
		else if(shortWord.charAt(0) == shortWord.charAt(1)) {
			String newShort = "";
			String newLong = "";
			
			for(int i=0; i<t.length(); i++) {
				newShort += s; 
			}
			
			for(int i=0; i<s.length(); i++) {
				newLong += t; 
			}
			
			if(newShort.equals(newLong)) answer = true;
			else answer = false;
			
		}
		else {
			String newWord = "";
			
			for(int i=0; i<(longWord.length()/shortWord.length()); i++) {
				newWord += shortWord; 
			}
			
			if(newWord == longWord) answer = true; 
			else answer = false;
		}
		
		System.out.println(answer);
	}
}
