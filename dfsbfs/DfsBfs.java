package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DfsBfs {
	static int N;
	static int M;
	static boolean checked[];
	static List<List<Integer>> list;
	public static void main(String[] args) throws IOException, InterruptedException {
		int V; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String graphInfo[] =  br.readLine().split(" ");
		N = Integer.parseInt(graphInfo[0]);
		M = Integer.parseInt(graphInfo[1]);
		V = Integer.parseInt(graphInfo[2]);
		list = new ArrayList<>();
		checked = new boolean[N+1];
		
		for(int i=0; i<N+1; i++) 
			list.add(new ArrayList<>());
		
		Arrays.fill(checked, false);
		
		for(int i=0; i<M; i++) {
			String buffer[] = br.readLine().split(" ");
			int x = Integer.parseInt(buffer[0]);
			int y = Integer.parseInt(buffer[1]);
			list.get(x).add(y);
			list.get(y).add(x);
		}
		
		for(int i=0; i<N+1; i++) {
			Collections.sort(list.get(i));
		}
		
		DFS(V);
		System.out.println();
		Arrays.fill(checked, false);
		BFS(V);
		
	}
	
	private static void DFS(int V) {
		checked[V] = true;
		System.out.print(V+" ");
		for(int i : list.get(V)) {
			if(!checked[i])
				DFS(i);
		}
	}
	
	private static void BFS(int V) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(V);
		checked[V] = true;
		while(!queue.isEmpty()) {
			int v = queue.poll();
			System.out.print(v+ " ");
			for(int i : list.get(v)) {
				if(!checked[i]) {
					checked[i] = true;
					queue.add(i);
				}
			}
		}
		System.out.println();
	}
	
	private static void BFS2(int V) {
		int[] distance = new int[N+1];
		int[] parent = new int[N+1];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		Arrays.fill(distance, -1);
		distance[V] = 0;
		parent[V] = V;
		queue.add(V);
		while(!queue.isEmpty()) {
			int v = queue.poll();
			for(int i : list.get(v)) {
				if(distance[i] == -1) {
					queue.add(i);
					distance[i] = distance[v] + 1;
					distance[i] = v;
				}
			}
		}
	}
	
	

}
