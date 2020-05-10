package queue;
/*
 * https://www.acmicpc.net/problem/11866
 * 백준 11866번 요세푸스 문제 0 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Josephus {

	public static void main(String[] args) throws IOException {
		int idx = 0, realIdx = 0, n = 0, k = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] line = br.readLine().split(" "); 
		List<Integer> resultList = new ArrayList<>();
		n = Integer.parseInt(line[0]);
		k = Integer.parseInt(line[1]);
		
		int[] circle = new int[n];
		for(int i=1; i<=n; i++) {
			circle[i-1] = i; 
		}
		
		while(resultList.size() < n) {
			// 다시 원점으로 돌아간다. 
			if(idx == n) idx %= n; 
			
			if(circle[idx] != -1) {
				realIdx++; 
			}
			
			if(realIdx == k) {
				resultList.add(circle[idx]);
				circle[idx] = -1;
				realIdx = 0;
			}
			
			idx++;
		}
		
		bw.write("<");
		for(int i=0; i<n; i++) {
			if(i == n-1) bw.write(resultList.get(i)+"");
			else bw.write(resultList.get(i)+", ");
		}
		bw.write(">\n");
		
		bw.flush();
		bw.close();
	}
}
