/*
 * https://www.acmicpc.net/problem/2178
 * 백준 2178번 미로 탐색 
 */

package backjoonChanllenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Maze {
	static Location[][] map;
	static int[][] dir = {{0,1}, {1,0}, {-1,0}, {0,-1}};
	static int[][] distance;
	static boolean[][] check;
	public static void main(String[] args) throws IOException {
		int N,M; 
		
		// input 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arrLine = br.readLine().split(" ");
		N = Integer.parseInt(arrLine[0]);
		M = Integer.parseInt(arrLine[1]);
		
		map = new Location[N][M];
		check = new boolean[N][M];
		distance = new int[N][M];
		for(int i=0; i<N; i++) {
			String strLine = br.readLine(); 
			for(int j=0; j<strLine.length(); j++) {
				map[i][j] = new Location(i, j, strLine.charAt(j) - '0');
			}
		}
		
		System.out.println(Bfs(N, M));

	}
	
	static int Bfs(int N, int M) {
		Queue<Location> queue = new LinkedList<>();
		
		queue.add(map[0][0]);
		distance[0][0] = 1;
		while(!queue.isEmpty()) {
			System.out.println(queue.toString());
			Location temp = queue.poll();
			if(temp.left == N-1 && temp.right == M-1) break; 
			
			for(int i=0; i<4; i++) {
				int nextLeft = temp.left + dir[i][0]; 
				int nextRight = temp.right + dir[i][1];
				if(nextLeft < 0 || nextRight < 0 || nextLeft >= N || nextRight >= M) continue;
				
				Location next = map[nextLeft][nextRight]; 
				if(!check[next.left][next.right] && next.data == 1) {
					queue.add(next);
					check[next.left][next.right] = true; 
					distance[next.left][next.right] = distance[temp.left][temp.right] + 1; 
				}
			}
		}
		
		return distance[N-1][M-1];
	}
}

class Location {
	int left;
	int right; 
	int data; 
	
	public Location(int _left, int _right, int _data) {
		this.left = _left; 
		this.right = _right; 
		this.data = _data;
	}
	
	@Override
	public String toString() {
		return "[" + left+ "," + right + "]";
	}
}

