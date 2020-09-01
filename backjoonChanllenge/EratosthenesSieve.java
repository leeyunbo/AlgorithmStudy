package backjoonChanllenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class EratosthenesSieve {

	public static void main(String[] args) throws IOException {
		int N,M;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] line = br.readLine().split(" "); 
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		boolean[] check = new boolean[M+1];
		Arrays.fill(check, true);
		
		for(int p=2; p<=Math.sqrt(M); p++) {
			for(int num=N; num<=M; num++) {
				if(num == p || !check[num]) continue;
				if(num%p==0) check[num] = false; 
			}
		}
		
		for(int i=N; i<=M; i++) {
			if(i!= 1 && check[i]) bw.write(i+"\n");
		}
		bw.flush();
	}

}
