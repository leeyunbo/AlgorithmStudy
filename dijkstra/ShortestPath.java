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
 * ���� 1753�� �ִ� ��� 
 * �ð� ���� 1��, �޸� ���� 256MB 
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
		
		// Node�� ��� �ִ� list�� �ʱ�ȭ �Ѵ�.
		// ���� ����Ʈ�� �ʱ�ȭ �Ѵ�.
		edge_weights.add(new ArrayList<>());
		for(int cnt=1; cnt<=vertexCnt; cnt++) {
			nodes[cnt] = new Node(cnt);
			edge_weights.add(new ArrayList<>());
		}
		
		int startVertex = Integer.parseInt(br.readLine());
		nodes[startVertex].shortest_distance = 0;
		
		// ���� ����ġ ����Ʈ�� �ʱ�ȭ �Ѵ�.
		for(int cnt=0; cnt<edgeCnt; cnt++) {
			line = br.readLine().split(" "); 
			int start = Integer.parseInt(line[0]);
			
			int[] end_weight = new int[2];
			end_weight[0] = Integer.parseInt(line[1]);
			end_weight[1] = Integer.parseInt(line[2]);
			
			edge_weights.get(start).add(end_weight);
		}
		
		// �ִ� ��θ� ����Ѵ�. 
		dijkstra(startVertex, vertexCnt);
		
		printNodes();
		
		line = null; 
		nodes = null;
		edge_weights = null;
	}
	
	private static void dijkstra(int startVertex, int vertexCnt) {
		PriorityQueue<Node> pqueue = new PriorityQueue<>();
		//��� ������ �켱���� ���� �ִ´�.
		for(int cnt=1; cnt<=vertexCnt; cnt++) {
			pqueue.add(nodes[cnt]);
		}
		
		//���� ��� ����ġ�� ���� ��带 ���� ���� �����Ѵ�.
		//���� ��尡 ����Ǿ� ������ �ش� ����� shortest path�� �ֽ�ȭ �Ѵ�.
		//��� ��尡 ���� ���� ���õǾ����� �����Ѵ�.
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

