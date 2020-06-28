package forloop;

public class InfiniteSame {
	public static void main(String[] args) {
		String s = "AB";
		String t = "ABA"; 
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
		
		
		int shortIdx = 0;
		for(int i=0; i<longWord.length(); i++) {
			if(shortWord.charAt(shortIdx) != longWord.charAt(i)) {
				answer= false; 
				return; 
			}
			
			shortIdx++;
			shortIdx %= (shortWord.length()); 
		}
		
		if(shortIdx != 0 && shortWord.charAt(0) != shortWord.charAt(1)) answer = false; 
		
		System.out.println(answer);
	}
}
