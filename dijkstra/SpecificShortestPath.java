package dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * https://www.acmicpc.net/problem/1504
 * ���� 1504�� Ư���� �ִ� ��� 
 * �ð� ���� 1��, �޸� ���� 256MB
 */
public class SpecificShortestPath {
	
	static Node[] nodes; 
	static List<List<int[]>> edge_weights;
	static boolean[] isChecked;
	static public final long INF = 1000000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int vertexCnt,edgeCnt; 
		int v1,v2;
		
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
		
		// ���� ����ġ ����Ʈ�� �ʱ�ȭ �Ѵ�.
		for(int cnt=0; cnt<edgeCnt; cnt++) {
			line = br.readLine().split(" "); 
			int start = Integer.parseInt(line[0]);
			
			int[] end_weight = new int[2];
			end_weight[0] = Integer.parseInt(line[1]);
			end_weight[1] = Integer.parseInt(line[2]);
			edge_weights.get(start).add(end_weight);
			
			int[] end_weight_reverse = new int[2]; 
			end_weight_reverse[0] = start; 
			end_weight_reverse[1] = end_weight[1];
			edge_weights.get(end_weight[0]).add(end_weight_reverse);
		}
		
		line = br.readLine().split(" ");
		v1 = Integer.parseInt(line[0]);
		v2 = Integer.parseInt(line[1]);
		
		
		long first = 0;
		long second = 0;
		
		
		// v1 or v2�� ���� ��ĥ ���
		// �ִ� ��θ� �ʱ�ȭ �Ѵ�.
		nodes[1].shortest_distance = 0;
		dijkstra(1, vertexCnt);
		if(nodes[v1].shortest_distance == INF) first = INF;
		else first += nodes[v1].shortest_distance;
		
		if(nodes[v2].shortest_distance == INF) second = INF;
		else second += nodes[v2].shortest_distance;
		for(int cnt=1; cnt<=vertexCnt; cnt++) nodes[cnt].shortest_distance = INF;
			
		if(first == INF && second == INF) {
			System.out.println("-1");
			return;
		}
		
		// v1���� v2�� or v2���� v1���� (������̶� ����)
		nodes[v1].shortest_distance = 0;
		dijkstra(v1, vertexCnt);
		if(nodes[v2].shortest_distance == INF) {
			System.out.println("-1");
			return;
		}
		if(first != INF) first += nodes[v2].shortest_distance;
		if(second != INF) second += nodes[v2].shortest_distance;
		for(int cnt=1; cnt<=vertexCnt; cnt++) nodes[cnt].shortest_distance = INF;
		
		// v1���� �������� 
		nodes[v1].shortest_distance = 0;
		dijkstra(v1, vertexCnt);
		if(second != INF && nodes[vertexCnt].shortest_distance != INF) second += nodes[vertexCnt].shortest_distance;
		else second = INF;
		for(int cnt=1; cnt<=vertexCnt; cnt++) nodes[cnt].shortest_distance = INF;
		
		// v2���� ��������
		nodes[v2].shortest_distance = 0;
		dijkstra(v2, vertexCnt);
		
		if(first != INF && nodes[vertexCnt].shortest_distance != INF) first += nodes[vertexCnt].shortest_distance;
		else first = INF;
		
		if(first == INF && second == INF) System.out.println("-1");
		else System.out.println(Math.min(first, second));
	}
	
	private static void dijkstra(int startVertex, int vertexCnt) {
		PriorityQueue<Node> pqueue = new PriorityQueue<>();
		Arrays.fill(isChecked, false);
		
		//���� ��带 �켱���� ���� �ִ´�.		 
		pqueue.add(nodes[startVertex]);
		
		
		//���� ��� ����ġ�� ���� ��带 ���� ���� �����Ѵ�.
		//���� ��尡 ����Ǿ� ������ �ش� ����� shortest path�� �ֽ�ȭ �Ѵ�.
		//��� ��尡 ���� ���� ���õǾ����� �����Ѵ�.
		while(!pqueue.isEmpty()) {
			Node start = pqueue.poll();
			isChecked[start.num] = true;
			
			for(int[] list : edge_weights.get(start.num)) {
				long before = nodes[list[0]].shortest_distance;
				nodes[list[0]].shortest_distance = 
						Math.min(nodes[list[0]].shortest_distance, start.shortest_distance + list[1]);  
				
				if(nodes[list[0]].shortest_distance != before && !isChecked[list[0]]) {
					pqueue.remove(nodes[list[0]]);
					pqueue.add(nodes[list[0]]);
				}
			}
		}
		pqueue = null;
	}
	
	static class Node implements Comparable<Node> {
		int num;
		long shortest_distance;  
		
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
