package backjoonChanllenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PrimeNumber {

	public static void main(String[] args) throws IOException {
		int N,M;
		boolean isPrime = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] line = br.readLine().split(" "); 
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		
		for(int i = N; i <= M; i++) {
			if(i==1) continue;
			isPrime = true; 
			for(int j = 2; j <= Math.sqrt(i); j++) {
				if(i%j == 0) {
					isPrime = false;
					break; 
				}
			}
			if(isPrime) bw.write(i+"\n");
		}
		
		bw.flush();
		
		

	}

}
