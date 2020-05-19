package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * https://www.acmicpc.net/problem/14503
 * 백준 14503번 로봇 청소기 
 */
public class RobotCleaner {
	
	private static int[][] map;
	private static boolean[][] isClean;
	private static int possibleArea = 0;
	private static int n = 0, m = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int direction = 0, leftIdx = 0, rightIdx = 0, impossible = 0, nextLeftIdx = 0, nextRightIdx = 0; 
		int[] directionIdx; 
		String[] line;
		
		line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]); 
		map = new int[n][m];  
		isClean = new boolean[n][m]; 
		
		line = br.readLine().split(" "); 
		leftIdx = Integer.parseInt(line[0]);
		rightIdx = Integer.parseInt(line[1]); 
		direction = Integer.parseInt(line[2]);
		
		for(int i=0; i<n; i++) {
			line = br.readLine().split(" "); 
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		while(true) {
			if(leftIdx < 0 || rightIdx < 0 || leftIdx >= n || rightIdx >= m) break;
			// 만약 청소되지 않은 곳이라면 청소
			if(isClean[leftIdx][rightIdx] == false) {
				isClean[leftIdx][rightIdx] = true;
				possibleArea++;
			}
			
			for(int i=0; i<4; i++) {
				direction = getNextDirection(direction); 
				directionIdx = getDirectionIdx(direction); 
				nextLeftIdx = leftIdx + directionIdx[0]; 
				nextRightIdx = rightIdx + directionIdx[1];
				if(map[nextLeftIdx][nextRightIdx] == 0 && isClean[nextLeftIdx][nextRightIdx] == false) {
					leftIdx = nextLeftIdx;
					rightIdx = nextRightIdx; 
					break;
				}
				else impossible++;
			}
			
			// 만약 네 방면이 청소가 불가능하다면 방향을 유지한채로 후진한다. 
			// 만약 후진이 불가능하다면 종료
			if(impossible == 4) {
				directionIdx = getDirectionIdx(direction);
				nextLeftIdx = leftIdx - directionIdx[0]; 
				nextRightIdx = rightIdx - directionIdx[1];
				if(map[nextLeftIdx][nextRightIdx] == 1) {
					break;
				}
				else {
					leftIdx = nextLeftIdx; 
					rightIdx = nextRightIdx;
				}
			}
			
			impossible = 0;
		}
		System.out.println(possibleArea);
	}
	
	private static int[] getDirectionIdx(int direction) {
		int[] directionIdx = new int[2];
		switch (direction) {
		case 0 : 
			directionIdx[0] = -1;
			directionIdx[1] = 0;
			break;
		case 1 :
			directionIdx[0] = 0;
			directionIdx[1] = 1;
			break;
		case 2 :
			directionIdx[0] = 1; 
			directionIdx[1] = 0;
			break;
		case 3 :
			directionIdx[0] = 0;
			directionIdx[1] = -1;
		}
		
		return directionIdx;
	}
	
	private static int getNextDirection(int beforeDirection) {
		if(beforeDirection == 0) return 3; 
		else return beforeDirection - 1;
	}
}
