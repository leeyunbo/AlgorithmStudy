/*
 * https://www.acmicpc.net/problem/2206
 * 백준 2206번 벽 부수고 이동하기 
 */

package backjoonChanllenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BreakAndMove {
	
	static int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
	static int[][] distance; 
	static int[][] map; 
	static Boolean[][][] isChecked; 
	static int N = 0, M = 0;
	static final int broken = 1;
	static final int unbroken = 0;
	
	
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arrLine = br.readLine().split(" ");
		
		N = Integer.parseInt(arrLine[0]);
		M = Integer.parseInt(arrLine[1]);
		map = new int[N][M];
		isChecked = new Boolean[N][M][2];
		distance = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String strLine = br.readLine();
			for(int j=0; j<strLine.length(); j++) {
				map[i][j] = strLine.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				for(int k=0; k<2; k++) {
					isChecked[i][j][k] = false;
				}
			}
		}
		
		// main logic
		Bfs();
		int result = getResult();
		
		// output
		System.out.println(result);
	}
	
	private static int getResult() {
		if(distance[N-1][M-1] == 0) return -1;
		else return distance[N-1][M-1];
	}
	
	
	// 목적지 N-1, M-1
	private static void Bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0, map[0][0], unbroken)); 
		
		isChecked[0][0][unbroken] = isChecked[0][0][broken] = true;
		distance[0][0] = 1;
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			int isBreak = temp.isBreak;
			if(temp.left == N-1 && temp.right == M-1) return;
			
			for(int i=0; i<directions.length; i++) {
				int n_left = temp.left + directions[i][0];
				int n_right = temp.right + directions[i][1];
				
				if(n_left < 0 || n_right < 0 || n_left >= N || n_right >= M) continue; 
				
				if(map[n_left][n_right] == 1) {
					if(isBreak == unbroken && !isChecked[n_left][n_right][broken]) {
						isChecked[n_left][n_right][unbroken] = true; 
						distance[n_left][n_right] = distance[temp.left][temp.right] + 1;
						queue.add(new Node(n_left, n_right, map[n_left][n_right], broken));
					}
				}
				else {
				   if(!isChecked[n_left][n_right][broken]) {
					   isChecked[n_left][n_right][broken] = true; 
					   distance[n_left][n_right] = distance[temp.left][temp.right] + 1;
					   queue.add(new Node(n_left, n_right, map[n_left][n_right], isBreak));
				   }
				}
			}

		}
	}
}

class Node {
	int data, left, right;
	int isBreak;
	
	public Node(int _left, int _right, int _data, int _isBreak) {
		left = _left;
		right = _right;
		data = _data;
		isBreak = _isBreak;
	}
	
	@Override 
	public String toString() {
		return "[" + left + "," + right + "]";
	}
}
