package coding;
import java.util.*;

public class hanSu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String N;
		int n,result = 0;
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextLine();
		n = Integer.parseInt(N);
		
		if(n<=99) {
			System.out.println(n);
			return;
		}
		
		for(int i=100; i<=n; i++) {
			if(checkHansu(Integer.toString(i))) {
				result++;
			} 
		}
		
		System.out.println(99+result);

	}
	
	private static boolean checkHansu(String N) {
		int temp,before = 0;
		
		before = calcCha(N.charAt(0),N.charAt(1));
		for(int i=1; i<N.length()-1; i++) {
			temp = calcCha(N.charAt(i),N.charAt(i+1));
			if(before != temp) {
				return false;
			}
		}
		
		return true;
	}
	
	private static int calcCha(char a, char b) {
		return (b-'0')-(a-'0');
	}
}
