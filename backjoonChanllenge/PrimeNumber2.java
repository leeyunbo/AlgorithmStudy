/*
 * https://www.acmicpc.net/problem/1978
 * 백준 1978번 소수 찾기 
 */

package backjoonChanllenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumber2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N;
		int[] numbers;
		int cnt = 0;
		
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		String[] line = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(line[i]);
		}
		
		// main logic 
		for(int number : numbers) {
			if(number == 1) continue;
			boolean isPrimeNumber = true;
			for(int i=2; i<=Math.sqrt(number); i++) {
				if(number % i == 0) { 
					isPrimeNumber = false;
					break;
				}
			}
			
			if(isPrimeNumber) cnt++;
		}
		
		System.out.println(cnt);
	}
}
