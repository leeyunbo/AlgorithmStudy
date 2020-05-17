package greedy;
/*
 * https://www.acmicpc.net/problem/13458
 * 백준 13458번 시험 감독
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestMonitor {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] candidates, line;
		int n = 0, b = 0, c = 0;
		long result = 0;
	
		n = Integer.parseInt(br.readLine());
		
		candidates = br.readLine().split(" "); 
		
		line = br.readLine().split(" "); 
		b = Integer.parseInt(line[0]);
		c = Integer.parseInt(line[1]); 
		
		for(int i=0; i<n; i++) {
			result += 1;
			int candidate = Integer.parseInt(candidates[i]) - b;
			if(candidate <= 0) continue;
			else {
				if(candidate % c > 0) {
					result += candidate / c + 1; 
				}
				else {
					result += candidate / c; 
				}
			}
		}
		
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}
}
