import java.util.Arrays;
import java.util.Scanner;
/*
 * ���ϵ�ī��� �پ��� �ü������ ���� �̸��� �Ϻθ����� ���� �̸��� �����ϴ� ����Դϴ�.
 * �̶� ����ϴ� ���ڿ��� ���ϵ�ī�� �����̶�� �ϴµ�, ������ �Ϲ����� ���ϸ�� ��������� Ư�� ���� *�� ?�� ������ �� �ִ� ���ڿ� �Դϴ�.
 * ���ϵ�ī�� ������ �տ��� �� ���ھ� ���ϸ�� ���ؼ� ��� ���ڰ� ��ġ���� �� �ش� ���ϵ�ī�� ������ ���ϸ�� �����ȴٰ� ���մϴ�.
 * ��, ���ϵ�ī�� ���Ͽ� ���Ե� ?�� � ���ڿ͵� �����ȴٰ� �����ϸ�, *�� 0 ���� �̻��� � ���ڿ����� �����ȴٰ� �����մϴ�.
 * ���ϵ�ī�� ���ϰ� ���ϸ��� �־��� ��, ���Ͽ� �����Ǵ��� Ȯ���ϴ� ���α׷��� �ۼ��ϼ���.
 * ���α׷��� 2�� �ȿ� ����Ǿ�� �ϸ�, 64MB ������ �޸𸮸� ����ؾ� �մϴ�.
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
		
		
		int[][] cache = new int[101][101]; // ���ڿ��� ������ �ִ� 100���� ����������
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
		
		// *�� ����, ���� �� ���� ���̵� ������ �װ��� �ٷ� TRUE
		if(pos == problem.length()) return pos == word.length();
		
		
		//*�� ������� ��� ���ĺ��� ��ġ ��ų�� �� �� ����, ���ȣ���� �̿��Ͽ� ��� ����� ���� Ž�� 
		for(int plus=0; pos+plus<=word.length(); plus++) {
			if(wildCard(problem.substring(pos+1),word.substring(pos+plus))) return true;
			
		}
		
		return false;
	}
	
	private static int memoizationWildCard(String problem, String word, int[][] cache) {
		int pos = 0;
		int left = Oword.length()-word.length(); //cache�� �ε���
		int right = Oproblem.length()-problem.length(); //cache�� �ε���
		
		if(cache[left][right] != -1) { // ���� �̹� ���� subProblem�̶�� �ش� �Ǵ� �� ����
			return cache[left][right];
		}
		MCount++;
		while(pos < problem.length() && pos < word.length() && ((word.charAt(pos) == '?') || (word.charAt(pos) == problem.charAt(pos)))) // ��ġ�ϸ� ��� ������ ����
			pos++;
		
		// *�� ����, ���� �� ���� ���̵� ������ �װ��� �ٷ� TRUE
		if(pos == problem.length()) {
			if(pos == word.length()) return cache[left][right] = 1;
		}
		
		//*�� ������� ��� ���ĺ��� ��ġ ��ų�� �� �� ����, ���ȣ���� �̿��Ͽ� ��� ����� ���� Ž�� 
		for(int plus=0; pos+plus<=word.length(); plus++) {
			if(wildCard(problem.substring(pos+1),word.substring(pos+plus))) return cache[left][right] = 1;
			
		}
		
		return cache[left][right] = 0;
	}
	
	
	


}
