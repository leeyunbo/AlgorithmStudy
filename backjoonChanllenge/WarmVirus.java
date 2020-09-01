package backjoonChanllenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * https://www.acmicpc.net/problem/2606
 * 백준 2606번 바이러스 
 * 양방향을 신경 써줘야 함! 
 */

public class WarmVirus {
	
	static List<ArrayList<Integer>> adjList = new ArrayList<>();
	static boolean[] isVisited; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// input 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int computer = Integer.parseInt(br.readLine());
		int edge = Integer.parseInt(br.readLine());
		
		for(int i=0; i<=computer; i++) {
			adjList.add(new ArrayList<>());
		}
		isVisited = new boolean[computer+1];
		
		for(int i=0; i<edge; i++) {
			String[] line = br.readLine().split(" ");
			int start = Integer.parseInt(line[0]);
			int end = Integer.parseInt(line[1]); 
			adjList.get(start).add(end); 
			adjList.get(end).add(start);
		}
		
		// main logic
		int result = DFS(1) - 1; 
		
		// output 
		System.out.println(result);

	}
	
	static int DFS(int node) {
		isVisited[node] = true; 
		int ret = 1;
		
		for(int aim : adjList.get(node)) {
			if(!isVisited[aim]) {
				ret += DFS(aim);
			}
		}
		
		return ret;
	}

}
