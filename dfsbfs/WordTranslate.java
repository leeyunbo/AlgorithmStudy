package dfsbfs;

import java.util.Arrays;

/**
 * 
 * 두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 
 * 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
 * 1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
 * 2. words에 있는 단어로만 변환할 수 있습니다.
 * 예를 들어 begin이 hit, target가 cog, words가 [hot,dot,dog,lot,log,cog]라면
 *  hit -> hot -> dot -> dog -> cog와 같이 4단계를 거쳐 변환할 수 있습니다.
 * 두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 
 * 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 
 * return 하도록 solution 함수를 작성해주세요.
 * 
 * 
 * 
 * @author 윤복
 *
 */
public class WordTranslate {
	static String[] myWords = {"hot", "dot", "dog", "lot", "log"};
	static String myTarget = "cog";
	static String myBegins = "hit";
	static boolean[] isSelected = new boolean[myWords.length];
	static final int INF = 654321;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = 0;
		Arrays.fill(isSelected, false);
		if(isFinish()) {
			System.out.println(0);
			return;
		}
		answer = WordTranslate(myBegins,0);
		System.out.println(answer);
	}
	
	private static int WordTranslate(String myWord, int count) {
		int answer = INF;
		// base - case 
		if(count == myWords.length+1) return 0;
		if(myWord.equals(myTarget)) return count;
		
		// recursion - case
		for(int i=0; i<myWords.length; i++) {
			String word = myWords[i];
			if(isSelected[i] == false && isTranslate(word,myWord)) {
				isSelected[i] = true;
				answer = Math.min(answer,WordTranslate(word,count+1));	
				isSelected[i] = false;
			}
		}
		
		return answer;
	}
	
	private static boolean isFinish() {
		for(int i=0; i<myWords.length; i++) {
			if(myWords[i].equals(myTarget)) {
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean isTranslate(String a, String b) {
		boolean isTranslate = false;
		int diffCount = 0;
		for(int i=0; i<a.length(); i++) {
			if(a.charAt(i) != b.charAt(i))
				diffCount++;
		}
		
		if(diffCount == 1)
			isTranslate = true;
		
		return isTranslate;
	}
	
	private static boolean isContinue() {
		int falseCount = 0;
		boolean isContinue = false;
		for(int i=0; i<isSelected.length; i++) {
			if(isSelected[i] == false) falseCount++;
		}
		
		if(falseCount > 0)
			isContinue =  true;
		
		return isContinue;
	}

}
