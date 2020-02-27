package dfsbfs;

import java.util.Arrays;

/**
 * 
 * �� ���� �ܾ� begin, target�� �ܾ��� ���� words�� �ֽ��ϴ�. 
 * �Ʒ��� ���� ��Ģ�� �̿��Ͽ� begin���� target���� ��ȯ�ϴ� ���� ª�� ��ȯ ������ ã������ �մϴ�.
 * 1. �� ���� �� ���� ���ĺ��� �ٲ� �� �ֽ��ϴ�.
 * 2. words�� �ִ� �ܾ�θ� ��ȯ�� �� �ֽ��ϴ�.
 * ���� ��� begin�� hit, target�� cog, words�� [hot,dot,dog,lot,log,cog]���
 *  hit -> hot -> dot -> dog -> cog�� ���� 4�ܰ踦 ���� ��ȯ�� �� �ֽ��ϴ�.
 * �� ���� �ܾ� begin, target�� �ܾ��� ���� words�� �Ű������� �־��� ��, 
 * �ּ� �� �ܰ��� ������ ���� begin�� target���� ��ȯ�� �� �ִ��� 
 * return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * 
 * 
 * @author ����
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
