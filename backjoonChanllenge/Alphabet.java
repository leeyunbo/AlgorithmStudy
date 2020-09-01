/*
 * https://www.acmicpc.net/problem/1987
 * 백준 1987번 알파벳 
 */

package backjoonChanllenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Alphabet {
	
	static char[][] map;
	static int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean[] alphaCheck;
	static boolean[][] isChecked;
	static int result = -1; 
	static int R, C; 
	
	public static void main(String[] args) throws IOException {
		
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arrLine = br.readLine().split(" ");
		R = Integer.parseInt(arrLine[0]);
		C = Integer.parseInt(arrLine[1]);
		
		alphaCheck = new boolean['z' - 'a' + 1];  
		isChecked = new boolean[R][C];
		map = new char[R][C]; 
		for(int i=0; i<R; i++) {
			String strLine = br.readLine();
			for(int j=0; j<strLine.length(); j++) {
				map[i][j] = strLine.charAt(j);
			}
		}
		
		// main logic 
		alphaCheck[map[0][0] - 65] = true;
		DFS(0, 0, 1);
		
		
		// output
		System.out.println(result);
	}
	
	private static void DFS(int leftIdx, int rightIdx, int length) {		
		for(int i=0; i<directions.length; i++) {
			int n_leftIdx = leftIdx + directions[i][0]; 
			int n_rightIdx = rightIdx + directions[i][1]; 
			
			if(n_leftIdx < 0 || n_rightIdx < 0 || n_leftIdx >= R || n_rightIdx >= C) continue;
			if(alphaCheck[map[n_leftIdx][n_rightIdx] - 65] || isChecked[n_leftIdx][n_rightIdx]) continue;
			
			isChecked[n_leftIdx][n_rightIdx] = true; 
			alphaCheck[map[n_leftIdx][n_rightIdx] - 65] = true;
			DFS(n_leftIdx, n_rightIdx, length + 1);
			alphaCheck[map[n_leftIdx][n_rightIdx] - 65] = false;
			isChecked[n_leftIdx][n_rightIdx] = false; 
		}
		
		result = Math.max(result, length);
		return;
	}
}
