package backjoonChanllenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class HideAndSeek {
	public static void main(String[] args) throws IOException {		
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int[] dir = {1, -1, 2};
		int N = Integer.parseInt(line[0]);
		int K = Integer.parseInt(line[1]);
		
		Queue<Integer> queue = new LinkedList<>();
		int[] cnts = new int[100001];
		boolean[] isVisited = new boolean[100001];
		
		queue.add(N);
		isVisited[N] = true;
		int current = 0, next = 0;
		while(!queue.isEmpty()) {
			current = queue.poll(); 
			
			if(current == K) break; 
			
			
			for(int i=0; i<3; i++) {
				if(i==2) {
					next = current * dir[i];
				}
				else {
					next = current + dir[i];
				}
			
			
				if(next >= 0 && next < 100001) {
					if(!isVisited[next]) {
						queue.add(next);
						isVisited[next] = true; 
						cnts[next] = cnts[current] + 1;
					}
				}
			}
		}
		
		System.out.println(cnts[K]);
	}
}
