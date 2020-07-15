package dp;

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
			cache = new long[n][1];
			fibonacci(n);
			bw.write(cache[n][1] + " " + cache[n][2] + "\n");
		}
		
		bw.flush();
	}
	
	
	private static long fibonacci(int n) {
		if(cache[n][0] > 0 || cache[n][1] > 0) {
			zeroCnt += cache[n][0]; 
			oneCnt += cache[n][1]; 
			return 0;
		}
		
		if(n == 0) {
			zeroCnt++;
			return 0; 
		}
		
		if(n == 1) {
			oneCnt++;
			return 1; 
		}
		
		cache[n][0] = zeroCnt;
		cache[n][1] = oneCnt; 
		
		return fibonacci(n-1) + fibonacci(n-2);
	}

}
