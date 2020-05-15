package bforce;
/*
 * https://www.acmicpc.net/problem/14502
 * 백준 14502번 연구소
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Laboratory {
	
	static List<int[]> virusIndex = new ArrayList<>();
	static int[][] laboratory;
	static boolean[][] isChecked;
	static int result = 0;
	static int n = 0, m = 0, safeZone = -3;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line;
		
		line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		laboratory = new int[n][m]; 
		isChecked = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			line = br.readLine().split(" "); 
			for(int j=0; j<line.length; j++) {
				laboratory[i][j] = Integer.parseInt(line[j]);
				if(laboratory[i][j] == 2) { 
					int[] index = {i,j};
					virusIndex.add(index);
				}
				if(laboratory[i][j] == 0) 
					safeZone++;
			}
		}
		corporation(0, 0); 
		System.out.println(result);
	}
	
	private static void corporation(int before, int wallNum) {
		if(wallNum == 3) {
			result = Math.max(result, safeZone - calcVirusZone());
			return; 
		}
		
		for(int i = before; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(laboratory[i][j] == 0) {
					laboratory[i][j] = 1;
					corporation(i, wallNum+1); 
					laboratory[i][j] = 0;
				}
			}
		}
	}
	
	private static int calcVirusZone() {
		int virusZoneCount = 0;
		
		//모든 바이러스 시작점에 대하여 바이러스 오염 확산을 계산한다.
		for(int i=0; i<virusIndex.size(); i++) {
			int[] idx = virusIndex.get(i);
			virusZoneCount += DFS(idx[0], idx[1]);
		}
		
		for(int i=0; i<isChecked.length; i++) {
			Arrays.fill(isChecked[i], false);
		}
		
		return virusZoneCount; 
	}
	
	private static int DFS(int leftIdx, int rightIdx) {
		int virusZoneCount = 0;
		//만약, 부지를 벗어났거나 이미 들렸거나 혹은 감염시킬 안전지대가 아니라면 종료 
		if(leftIdx >= n || rightIdx >= m || leftIdx < 0 || rightIdx < 0) return 0;
		if(isChecked[leftIdx][rightIdx] == true) return 0; 
		if(laboratory[leftIdx][rightIdx] == 1) return 0;
		
		if(laboratory[leftIdx][rightIdx] == 0) virusZoneCount += 1;

		//난 여기 들렸어.
		isChecked[leftIdx][rightIdx] = true;
		
		//사방면으로 이동한다. 
		virusZoneCount += DFS(leftIdx+1, rightIdx+0);
		virusZoneCount += DFS(leftIdx-1, rightIdx+0); 
		virusZoneCount += DFS(leftIdx, rightIdx+1); 
		virusZoneCount += DFS(leftIdx, rightIdx-1); 
		
		return virusZoneCount; 
	}
	
	private static void printLaboratory() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(laboratory[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
