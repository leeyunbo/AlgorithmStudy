package dongwon;

// 1. 긴 문자열의 길이와 짧은 문자열의 길이를 나눴을 때 나머지가 0이 아니면, 같은 모양이 나올수가 없다.
// 1-1. 하지만 만약에 짧은 문자열이 하나의 문자로만 이루어져 있다면 같은 모양이 나오는 경우도 있다. 
// 2. 짧은 문자열 길이를 긴 문자열의 길이로 나눈 것 만큼 짧은 문자열을 반복했을 때 긴 문자열과 똑같이 생겼다면 무한히 같다.

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
