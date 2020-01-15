import java.util.Arrays;
import java.util.Scanner;
/*
 * nXn 크기의 격자에 1부터 9까지의 정수를 쓴 게임판이 있다.
 * 이때 게임의 목적은 게임판의 왼쪽 위 칸에서 시작해서 게임판의 맨 오른쪽 아래 칸에 도착하는 것이다. 
 * 이때 각 칸에 적혀 있는 숫자만큼 아래쪽이나 오른쪽으로 이동할 수 있으며, 중간에 게임판에 벗어나면 안되는 규칙이 있다.
 * 문제는 게임판이 주어질 때 시작점에서 끝점으로 도달하는 방법이 존재하는지를 확인하는 것이다.
 * 제한시간이 존재하므로 단순한 완전탐색 재귀호출을 이용하면 무조건 시간초과가 발생함.
 */

public class JumpGame {
	static int MCount = 0;
	static int NCount = 0;
	static int[][] impossible_board = {
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,2},
			{1,1,1,1,1,2,0},
	};
	static int[][] board = {
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1},
			{1,1,1,1,1,1,0},
	};
	static int N;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		int[][] cache = new int[N][N];
		for(int i=0; i<cache.length; i++) {
			Arrays.fill(cache[i],-1);
		}
		
		if(JumpGame(0,0)==false) {
			System.out.println("불가능");
		} else {
			System.out.println("도착가능");
		}
		
		if(MemoizationJumpGame(0,0,cache)==0) {
			System.out.println("불가능");
		} else {
			System.out.println("도착가능");
		}
		
		System.out.println("Memoization : " + MCount);
		System.out.println("Not Memoization : " + NCount);
		
		
		
	}

	private static boolean JumpGame(int a, int b) {
		NCount++;
		if(a == N-1 && b == N-1) {
			return true;
		}
		
		if(a > N-1 || b > N-1) {
			return false;
		}
		
		return JumpGame(a+board[a][b],b) || JumpGame(a,b+board[a][b]);	
	}
	
	private static int MemoizationJumpGame(int a, int b, int[][] cache) {
		if(a == N-1 && b == N-1) {
			return 1;
		}
		
		if(a > N-1 || b > N-1) {
			return 0;
		}
		
		if(cache[a][b] != -1) {
			return cache[a][b];
		}
		MCount++;

		
		return cache[a][b] = MemoizationJumpGame(a+board[a][b],b,cache) | MemoizationJumpGame(a,b+board[a][b],cache);
	}
}
