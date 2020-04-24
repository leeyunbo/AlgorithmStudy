package dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://www.acmicpc.net/problem/1753
 * 백준 1753번 최단 경로 
 * 시간 제한 1초, 메모리 제한 256MB 
 */

public class ShortestPath {
	
	static Node[] nodes; 
	static List<List<int[]>> edge_weights;
	static boolean[] isChecked;
	static public final int INF = 1000000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int vertexCnt,edgeCnt; 
		
		String[] line = br.readLine().split(" "); 
		vertexCnt = Integer.parseInt(line[0]);
		edgeCnt = Integer.parseInt(line[1]);
		edge_weights = new ArrayList<>();
		nodes = new Node[vertexCnt+1];
		isChecked = new boolean[vertexCnt+1];
		
		// Node를 담고 있는 list를 초기화 한다.
		// 인접 리스트를 초기화 한다.
		edge_weights.add(new ArrayList<>());
		for(int cnt=1; cnt<=vertexCnt; cnt++) {
			nodes[cnt] = new Node(cnt);
			edge_weights.add(new ArrayList<>());
		}
		
		int startVertex = Integer.parseInt(br.readLine());
		nodes[startVertex].shortest_distance = 0;
		
		// 간선 가중치 리스트를 초기화 한다.
		for(int cnt=0; cnt<edgeCnt; cnt++) {
			line = br.readLine().split(" "); 
			int start = Integer.parseInt(line[0]);
			
			int[] end_weight = new int[2];
			end_weight[0] = Integer.parseInt(line[1]);
			end_weight[1] = Integer.parseInt(line[2]);
			
			edge_weights.get(start).add(end_weight);
		}
		
		// 최단 경로를 계산한다. 
		dijkstra(startVertex, vertexCnt);
		
		printNodes();
		
		line = null; 
		nodes = null;
		edge_weights = null;
	}
	
	private static void dijkstra(int startVertex, int vertexCnt) {
		PriorityQueue<Node> pqueue = new PriorityQueue<>();
		//모든 노드들을 우선순위 힙에 넣는다.
		for(int cnt=1; cnt<=vertexCnt; cnt++) {
			pqueue.add(nodes[cnt]);
		}
		
		//가장 경로 가중치가 작은 노드를 시작 노드로 선택한다.
		//만약 노드가 연결되어 있으면 해당 노드의 shortest path를 최신화 한다.
		//모든 노드가 시작 노드로 선택되었으면 종료한다.
		while(!pqueue.isEmpty()) {
			Node start = pqueue.poll();
			isChecked[start.num] = true;
			
			for(int[] list : edge_weights.get(start.num)) {
				int before = nodes[list[0]].shortest_distance;
				nodes[list[0]].shortest_distance = 
						Math.min(nodes[list[0]].shortest_distance, start.shortest_distance + list[1]);  
				
				if(nodes[list[0]].shortest_distance != before) {
					pqueue.remove(nodes[list[0]]);
					pqueue.add(nodes[list[0]]);
				}
			}
		}
		pqueue = null;
	}
	
	private static void printNodes() {
		for(int idx=1; idx<nodes.length; idx++) {
			if(nodes[idx].shortest_distance == INF) {
				System.out.println("INF");
			}
			else 
				System.out.println(nodes[idx].shortest_distance);
		}
		System.out.println();
	}
	
	static class Node implements Comparable<Node> {
		int num;
		int shortest_distance;  
		
		public Node(int num) {
			this.num = num;
			this.shortest_distance = INF;
		}

		@Override
		public int compareTo(Node target) {
			if (this.shortest_distance < target.shortest_distance) {
				return -1;
			} else if (this.shortest_distance > target.shortest_distance) {
				return 1; 
			}
			return 0;
		}
		
		@Override
		public String toString() {
			return "[" + num + "," + shortest_distance + "]";
		}
	}
}

