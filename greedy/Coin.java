package greedy;

/*
 * https://www.acmicpc.net/problem/11047
 * 백준 11047번 동전 0
 * 시간 제한 1초, 메모리 제한 256MB 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Coin {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] line = br.readLine().split(" ");
		int result = 0;
		
		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);
		
		int[] coins = new int[n]; 
		
		for(int i=0; i<n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int idx = n-1;
		while(true) {
			if(k == 0) break; 
			
			if(coins[idx] <= k) {
				int cnt = k / coins[idx];
				result += cnt; 
				k = k - (coins[idx] * cnt);
			}

			idx--;
		}
		
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}

}
