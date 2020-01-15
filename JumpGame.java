import java.util.Arrays;
import java.util.Scanner;
/*
 * nXn ũ���� ���ڿ� 1���� 9������ ������ �� �������� �ִ�.
 * �̶� ������ ������ �������� ���� �� ĭ���� �����ؼ� �������� �� ������ �Ʒ� ĭ�� �����ϴ� ���̴�. 
 * �̶� �� ĭ�� ���� �ִ� ���ڸ�ŭ �Ʒ����̳� ���������� �̵��� �� ������, �߰��� �����ǿ� ����� �ȵǴ� ��Ģ�� �ִ�.
 * ������ �������� �־��� �� ���������� �������� �����ϴ� ����� �����ϴ����� Ȯ���ϴ� ���̴�.
 * ���ѽð��� �����ϹǷ� �ܼ��� ����Ž�� ���ȣ���� �̿��ϸ� ������ �ð��ʰ��� �߻���.
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
			System.out.println("�Ұ���");
		} else {
			System.out.println("��������");
		}
		
		if(MemoizationJumpGame(0,0,cache)==0) {
			System.out.println("�Ұ���");
		} else {
			System.out.println("��������");
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
