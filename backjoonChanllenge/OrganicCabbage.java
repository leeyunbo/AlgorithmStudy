/*
 * https://www.acmicpc.net/problem/1012
 * 백준 1012번 유기농 배추 
 */

package backjoonChanllenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class OrganicCabbage {
	
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean[][] check;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCaseCnt = Integer.parseInt(br.readLine());
		for(int i=0; i<testCaseCnt; i++) {
			String[] line = br.readLine().split(" ");
			int M = Integer.parseInt(line[0]);
			int N = Integer.parseInt(line[1]);
			int cabCnt = Integer.parseInt(line[2]);
			
			check = new boolean[N][M];
			map = new int[N][M];
			for(int j=0; j<cabCnt; j++) {
				line = br.readLine().split(" ");
				int cabLeft = Integer.parseInt(line[1]);
				int cabRight = Integer.parseInt(line[0]);
				map[cabLeft][cabRight] = 1;
			}
			
			bw.write(func(N, M) + "\n");
		}
		
		bw.flush();
	}
	
	static int func(int N, int M) {
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!check[i][j] && map[i][j] == 1) cnt += Bfs(i, j, N, M);
			}
		}
		
		return cnt;
	}
	
	
	static int Bfs(int startLeft, int startRight, int N, int M) {
		Queue<Loc> queue = new LinkedList<>();
		
		queue.add(new Loc(startLeft, startRight));
		check[startLeft][startRight] = true;
		while(!queue.isEmpty()) {
			Loc temp = queue.poll(); 
			for(int i=0; i<dir.length; i++) {
				int nextL = temp.left + dir[i][0];
				int nextR = temp.right + dir[i][1]; 
				if(nextL < 0 || nextR < 0 || nextL >= N || nextR >= M) continue; 
				if(!check[nextL][nextR] && map[nextL][nextR] == 1) {
					check[nextL][nextR] = true;
					queue.add(new Loc(nextL, nextR)); 
				}
			}
		}
		
		return 1;
	}
}

class Loc {
	int left;
	int right;
	
	public Loc(int _left, int _right) {
		left = _left;
		right = _right;
	}
}
