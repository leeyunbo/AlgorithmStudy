/*
 * https://www.acmicpc.net/problem/11726
 * 백준 11726번 2xn 타일링 문제 풀이
 */

package backjoonChanllenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tiling {
	static int[] cache;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		cache = new int[n+1];
		
		System.out.println(tile(n));

	}
	
	static int tile(int n) {
		if(n == 1) return 1;
		if(n == 2) return 2;
		if(cache[n] > 0) return cache[n];
		
		
		return cache[n] = (tile(n-2) + tile(n-1)) % 10007;
	}
}
