import java.util.LinkedList;
import java.util.Scanner;
/*
 * 재귀호출을 활용한 이항계수 문제 풀이
 * Binomial : 동적계획법을 이용한 이항계수 알고리즘 메소드 
 * None_Memoization_Binomial : 동적게획법을 사용하지 않는 이항계수 알고리즘 메소드 
 * 숫자가 커질수록 동적게획법을 사용했을 경우가 재귀호출 횟수가 급격하게 줄어듬 
 */

public class Binomial {
	static int Mcount = 0;
	static int NMCount = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int[][] cache = new int[a+1][b+1];
		for(int i=0; i<cache.length; i++) {
			for(int j=0; j<cache[i].length; j++) {
				cache[i][j] = -1;
			}
		}
		System.out.println(Binomial(a,b,cache));
		System.out.println(None_Memoization_Binomial(a,b));
		System.out.println("Using Memoization : " + Mcount);
		System.out.println("Not Using Memoiztion : " + NMCount);
	}
	
	private static int Binomial(int a, int b,int[][] cache) {
		if(cache[a][b] != -1) {
			return cache[a][b];
		}
		Mcount++;	
		if(b==0 || a == b) {
			return 1;
		}
		
		cache[a][b] = Binomial(a-1,b-1,cache) + Binomial(a-1,b,cache);
		
		return cache[a][b];
	}
	
	private static int None_Memoization_Binomial(int a,int b) {
		NMCount++;
		if(b==0 || a==b) {
			return 1;
		}
		
		return None_Memoization_Binomial(a-1,b-1) + None_Memoization_Binomial(a-1,b);
	}

}
