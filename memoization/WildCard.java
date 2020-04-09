import java.util.Arrays;
import java.util.Scanner;
/*
 * 와일드카드는 다양한 운영체제에서 파일 이름의 일부만으로 파일 이름을 지정하는 방법입니다.
 * 이때 사용하는 문자열을 와일드카드 패턴이라고 하는데, 패턴은 일반적인 파일명과 비슷하지만 특수 문자 *나 ?를 포함할 수 있는 문자열 입니다.
 * 와일드카드 패턴을 앞에서 한 글자씩 파일명과 비교해서 모든 글자가 일치했을 때 해당 와일드카드 패턴이 파일명과 대응된다고 말합니다.
 * 단, 와일드카드 패턴에 포함된 ?는 어떤 글자와도 대응된다고 가정하며, *는 0 글자 이상의 어떤 문자열에도 대응된다고 가정합니다.
 * 와일드카드 패턴과 파일명이 주어질 때, 패턴에 대응되는지 확인하는 프로그램을 작성하세요.
 * 프로그램은 2초 안에 실행되어야 하며, 64MB 이하의 메모리를 사용해야 합니다.
 */

public class WildCard {
	static String Oproblem;
	static String Oword;
	static int MCount = 0;
	static int NMCount = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Oproblem = scanner.nextLine();
		Oword = scanner.nextLine();
		if(wildCard(Oproblem, Oword)) System.out.println(Oword);
		
		
		int[][] cache = new int[101][101]; // 문자열의 갯수는 최대 100으로 정해져있음
		for(int i=0; i<cache.length; i++) {
			Arrays.fill(cache[i], -1);
		}
		
		
		if(memoizationWildCard(Oproblem, Oword, cache) == 1) System.out.println(Oword);
		
		
		System.out.println(MCount);
		System.out.println(NMCount);
	}
	
	
	private static boolean wildCard(String problem, String word) {
		int pos = 0;
		NMCount++;
		while(pos < problem.length() && pos < word.length() && ((word.charAt(pos) == '?') || (word.charAt(pos) == problem.charAt(pos)))) 
			pos++;
		
		// *이 없고, 서로 다 같고 길이도 같으면 그것은 바로 TRUE
		if(pos == problem.length()) return pos == word.length();
		
		
		//*을 만난경우 몇개의 알파벳에 매치 시킬지 알 수 없음, 재귀호출을 이용하여 모든 경우의 수를 탐색 
		for(int plus=0; pos+plus<=word.length(); plus++) {
			if(wildCard(problem.substring(pos+1),word.substring(pos+plus))) return true;
			
		}
		
		return false;
	}
	
	private static int memoizationWildCard(String problem, String word, int[][] cache) {
		int pos = 0;
		int left = Oword.length()-word.length(); //cache의 인덱스
		int right = Oproblem.length()-problem.length(); //cache의 인덱스
		
		if(cache[left][right] != -1) { // 만약 이미 계산된 subProblem이라면 해당 되는 값 리턴
			return cache[left][right];
		}
		MCount++;
		while(pos < problem.length() && pos < word.length() && ((word.charAt(pos) == '?') || (word.charAt(pos) == problem.charAt(pos)))) // 일치하면 계속 앞으로 전진
			pos++;
		
		// *이 없고, 서로 다 같고 길이도 같으면 그것은 바로 TRUE
		if(pos == problem.length()) {
			if(pos == word.length()) return cache[left][right] = 1;
		}
		
		//*을 만난경우 몇개의 알파벳에 매치 시킬지 알 수 없음, 재귀호출을 이용하여 모든 경우의 수를 탐색 
		for(int plus=0; pos+plus<=word.length(); plus++) {
			if(wildCard(problem.substring(pos+1),word.substring(pos+plus))) return cache[left][right] = 1;
			
		}
		
		return cache[left][right] = 0;
	}
	
	
	


}
