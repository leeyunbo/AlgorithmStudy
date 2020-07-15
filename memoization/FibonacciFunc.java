package dp;

/*
 * https://www.acmicpc.net/problem/1003
 * 백준 1003번 피보나치 함수 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class FibonacciFunc {

	static long[][] cache; 
	static long zeroCnt = 0, oneCnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine()); 
		
		for(int i=0; i<T; i++) {
			zeroCnt = oneCnt = 0;
			int n = Integer.parseInt(br.readLine());
			cache = new long[n+1][2];
			fibonacci(n);
			bw.write(cache[n][0] + " " + cache[n][1] + "\n");
		}
		
		bw.flush();
	}
	
	
	
	// fib(2) = fib(1)에서 나온 0 혹은 1의 갯수 + fib(0)에서 나온 0 혹은 1의 갯수 
	// fib(3) = fib(2)에서 나온 0 혹은 1의 갯수 + fib(1)에서 나온 0 혹은 1의 갯수 
	private static void fibonacci(int n) {
		if(n == 0) {
			zeroCnt++;
			cache[n][0] = 1;
			return;
		}
		
		if(n == 1) {
			oneCnt++; 
			cache[n][1] = 1;
			return; 
		}
		
		if(cache[n][0] > 0 || cache[n][1] > 0) {
			zeroCnt += cache[n][0]; 
			oneCnt += cache[n][1]; 
			return; 
		}
		else {
			fibonacci(n-1);
			fibonacci(n-2);
			cache[n][0] = zeroCnt; 
			cache[n][1] = oneCnt; 
		}
	
	}

}
