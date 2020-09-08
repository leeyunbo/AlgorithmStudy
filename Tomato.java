/*
 * https://www.acmicpc.net/problem/7576
 * 백준 7576번 토마토 문제 풀이
 */

package backjoonChanllenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato {
	
	static Queue<TomatoInfo> queue = new LinkedList<>();
	static TomatoInfo[][] container;
	static boolean[][] check;
	static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
	static int aim = 0;
	
	public static void main(String[] args) throws IOException {
		int N,M,complete = 0;
		
		// input 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		M = Integer.parseInt(line[0]);
		N = Integer.parseInt(line[1]);

		container = new TomatoInfo[N][M]; 
		check = new boolean[N][M];
		for(int i=0; i<N; i++) {
			line = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				container[i][j] = new TomatoInfo(i, j, Integer.parseInt(line[j]), 0);
				if(container[i][j].state == 1) {
					queue.add(container[i][j]);
					check[i][j] = true;
					complete++;
				}
				if(container[i][j].state == 0) aim++;
			}
		}
		// main logic 	
		// output 
		System.out.println(func(N, M));
	}
	
	static int func(int N, int M) {
		int result = -0;
		int temp = 0;
		while(!queue.isEmpty()) {
			TomatoInfo tomato = queue.poll();
			int depth = container[tomato.left][tomato.right].depth + 1; 
			
			// 주변 토마토 익히기 
			for(int i=0; i<4; i++) {
				int n_left = tomato.left + dir[i][0];
				int n_right = tomato.right + dir[i][1];
				if(n_left < 0 || n_right < 0 || n_left >= N || n_right >= M) continue;
				if(!check[n_left][n_right] && container[n_left][n_right].state == 0) {
					container[n_left][n_right].state = 1;
					container[n_left][n_right].depth = depth;
					result = Math.max(result, depth);
					check[tomato.left][tomato.right] = true;
					queue.add(container[n_left][n_right]);
					temp++;
				}
			}
		}
		
		if(aim != temp) return -1;
		else return result;
	}
}

class TomatoInfo {
	int left;
	int right; 
	int state;
	int depth;
	
	public TomatoInfo(int _left, int _right, int _state, int _depth) {
		left = _left;
		right = _right;
		state = _state; 
		depth = _depth;
	}
	
	@Override
	public String toString() {
		return "[" + state + "," + left + "," + right + "]";
	}
	
}
