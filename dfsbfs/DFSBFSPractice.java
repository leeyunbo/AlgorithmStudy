package dfsbfs;

import java.io.*;
import java.util.*;

public class DFSBFSPractice {
	private static List<List<Integer>> adjList = new ArrayList<>();
	private static boolean[] isChecked; 
	private static int N,M,V;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" "); 
		
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		V = Integer.parseInt(line[2]);
		isChecked = new boolean[N+1];
		
		for(int i=0; i<=N; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			line = br.readLine().split(" ");
			int start = Integer.parseInt(line[0]);
			int end = Integer.parseInt(line[1]);
			adjList.get(start).add(end);
			adjList.get(end).add(start);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(adjList.get(i));
		}
		
		
		DFS(V);
		System.out.println();
		Arrays.fill(isChecked, false);
		
		BFS(V); 

	}
	
	private static void DFS(int start) {
		isChecked[start] = true; 
		System.out.print(start + " ");
		
		if(isFinish()) return;
		
		List<Integer> temp = adjList.get(start); 
		for(Integer node : temp) {
			if(!isChecked[node]) {
				DFS(node); 
			}
		}
	}
	
	private static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>(); 
		
		queue.add(start); 
		isChecked[start] = true;
		
		while(!queue.isEmpty()) {
			int node = queue.poll(); 
			System.out.print(node + " ");
			
			List<Integer> temp = adjList.get(node); 
			for(Integer end : temp) {
				if(!isChecked[end]) {
					queue.add(end);
					isChecked[end] = true; 
				}
			}
			
		}
	}
	
	private static boolean isFinish() {
		for(int i=1; i<=N; i++) {
			if(!isChecked[i]) { 
				return false; 
			}
		}
		
		return true;
	}
}
