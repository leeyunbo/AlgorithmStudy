package bforce;
/*
 * https://www.acmicpc.net/status?user_id=servers1&problem_id=14500&from_mine=1
 * 백준 14500번 테트로미노
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Tetromino {
	static final int[][] first = {{-1,0}, {0,-1}, {0,1}};  // ㅗ 
	static final int[][] second = {{0,-1}, {-1,0}, {1,0}}; // ㅓ
	static final int[][] third = {{1,0}, {0,-1}, {0,1}};   // ㅜ
	static final int[][] fourth = {{-1,0}, {1,0}, {0,1}};  // ㅏ
	static final int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
	static int[][] paper;
	static boolean[][] isChecked;
	static int result = 0, n = 0, m = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line; 
		
		line = br.readLine().split(" "); 
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		
		paper = new int[n][m];
		isChecked = new boolean[n][m]; 
		
		for(int i=0; i<n; i++) {
			line = br.readLine().split(" "); 
			for(int j=0; j<line.length; j++) {
				paper[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				other(i,j);
				isChecked[i][j] = true;
				DFS(paper[i][j], i, j, 1);
				isChecked[i][j] = false;
			}
		}
		
		System.out.println(result);
	}
	
	private static void DFS(int sum, int left, int right, int count) {
		//1. base-case 
		if(count == 4) {
			result = Math.max(result, sum);
			return;
		}

		//2. recursion-case 
		for(int i=0; i<direction.length; i++) {
			int nextLeft = left + direction[i][0]; 
			int nextRight = right + direction[i][1];
			
			if(nextLeft < 0 || nextRight < 0 || nextLeft >= n || nextRight >= m) continue;
			
			if(isChecked[nextLeft][nextRight] == false) {
				isChecked[nextLeft][nextRight] = true;
				DFS(sum + paper[nextLeft][nextRight], nextLeft, nextRight, count + 1);
				isChecked[nextLeft][nextRight] = false;
			}
		}
	}
	
	private static void other(int left, int right) {
		int sum = paper[left][right];
		//1번째 모양 ㅗ 
		for(int i=0; i<3; i++) {
			int nextLeft = left + first[i][0];
			int nextRight = right + first[i][1]; 
			if(nextLeft < 0 || nextRight < 0 || nextLeft >= n || nextRight >= m) break;
			sum += paper[nextLeft][nextRight]; 
		}
		if(sum != paper[left][right]) result = Math.max(result, sum);
		sum = paper[left][right];
		
		
		int tempSum = paper[left][right];
		//2번째 모양 ㅏ 
		for(int i=0; i<3; i++) {
			int nextLeft = left + second[i][0];
			int nextRight = right + second[i][1]; 
			if(nextLeft < 0 || nextRight < 0 || nextLeft >= n || nextRight >= m) break;
			sum += paper[nextLeft][nextRight]; 
		}
		if(sum != paper[left][right]) result = Math.max(result, sum);
		sum = paper[left][right];
		
		//3번째 모양 ㅜ
		for(int i=0; i<3; i++) {
			int nextLeft = left + third[i][0];
			int nextRight = right + third[i][1]; 
			if(nextLeft < 0 || nextRight < 0 || nextLeft >= n || nextRight >= m) break;
			sum += paper[nextLeft][nextRight]; 
		}
		if(sum != paper[left][right]) result = Math.max(result, sum);
		sum = paper[left][right];
		
		//4번재 모양 ㅓ 
		for(int i=0; i<3; i++) {
			int nextLeft = left + fourth[i][0];
			int nextRight = right + fourth[i][1]; 
			if(nextLeft < 0 || nextRight < 0 || nextLeft >= n || nextRight >= m) break;
			sum += paper[nextLeft][nextRight]; 
		}
		if(sum != paper[left][right]) result = Math.max(result, sum);
		sum = paper[left][right];
	}

}
