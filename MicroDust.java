package samsungswtest;
/*
 * https://www.acmicpc.net/problem/17144
 * ���� 17144��, �̼����� �ȳ�!
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MicroDust {
	private static int R = 0, C = 0, T = 0;
	private static List<MicroDustCleaner> cleanerLocations = new ArrayList<>();
	private static int[][] canMoveDirection = {{1,0},{0,1},{-1,0},{0,-1}};
	private static int[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" "); 
		R = Integer.parseInt(line[0]);
		C = Integer.parseInt(line[1]);
		T = Integer.parseInt(line[2]);
		board = new int[R][C];
		int cleanerLocationCnt = 0;
		
		// 1. �̼������� Weight �߰�, ���� û������ ��ġ üũ 
		for(int i=0; i<R; i++) {
			line = br.readLine().split(" "); 
			for(int j=0; j<line.length; j++) {
				board[i][j] = Integer.parseInt(line[j]);
				if(board[i][j] == -1) {
					cleanerLocationCnt++;
					cleanerLocations.add(new MicroDustCleaner(i,j));
				}
			}
		}
		// 2. T �� ���� �ݺ��Ѵ�
		for(int time=1; time<=T; time++) {
		// 2-1. �̼������� Ȯ���Ͽ� �ֽ�ȭ ��Ų��.
			spreadMicroDust();
		
		// 2-2. ����û���⸦ �������� �̼������� �̵� ��Ų��. 
			startCleaning();
		}
		
		// 3. T�� ��, �̼������� ������ ���Ѵ�. 
		System.out.println(sumMicroDust());
		
	}
	
	private static void spreadMicroDust() {
		int[][] nextBoard = new int[R][C]; 

		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				nextBoard[i][j] = board[i][j];
			}
		}
		
		// �̼������� �����ϴ� ��� ĭ�� ���Ͽ�, �̼����� Ȯ���� ����Ѵ� 
		// ���� ������ ����ų�, �������� �����ϴ� ��ġ��� �н��Ѵ�.
		// ���� Ȯ��� ����, ������ �̼������� �����ϴ� ��ġ�� �ƴ϶�� �̼����� ��ġ�� ���� �ִ� ����Ʈ�� �߰��Ѵ�.
		// Ȯ��� ������ ���� üũ�Ͽ�, �̼����� ���� �����Ѵ�.
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(board[r][c] == 0 || board[r][c] == -1) continue;
				
				int spreadCnt = 0;
				for(int k=0; k<canMoveDirection.length; k++) {
					int nextR = r + canMoveDirection[k][0];
					int nextC = c + canMoveDirection[k][1]; 
					
					if(nextR < 0 || nextC < 0 || nextR >= R || nextC >= C) continue; 
					if(board[nextR][nextC] == -1) continue;

					nextBoard[nextR][nextC] = nextBoard[nextR][nextC] + (board[r][c]/5);
					spreadCnt++;
				}
				
				nextBoard[r][c] = nextBoard[r][c] - ((board[r][c]/5) * spreadCnt);
				if(nextBoard[r][c] < 0) nextBoard[r][c] = 0;
			}
		}
		
		// ��ȭ�� �̼������� ������ �ֽ�ȭ �����ش�. 
		board = nextBoard; 
	}
	
	private static int sumMicroDust() {
		int total = 0; 
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(board[i][j] == -1) continue;
				total += board[i][j];
			}
		}

		return total; 
	}
	
	private static void startCleaning() {
		int[][] nextBoard = new int[R][C];
		int topR = cleanerLocations.get(0).x;
		int topC = cleanerLocations.get(0).y; 
		int bottomR = cleanerLocations.get(1).x;
		int bottomC = cleanerLocations.get(1).y; 
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				nextBoard[i][j] = board[i][j];
			}
		}

		
		// 1. ������ û���Ѵ�.
		// ->
		nextBoard[topR][topC+1] = 0;
		for(int i=topC+1; i<C-1; i++) nextBoard[topR][i+1] = board[topR][i]; 
		
		// ����
		for(int i=topR; i>0; i--) nextBoard[i-1][C-1] = board[i][C-1];

		// ��������
		for(int i=C-1; i>0; i--) nextBoard[0][i-1] = board[0][i];
		
		// �Ʒ���
		for(int i=0; i<topR-1; i++) nextBoard[i+1][topC] = board[i][topC];
		
		
		// 2. �Ʒ����� û���Ѵ�. 
		// ->
		nextBoard[bottomR][bottomC+1] = 0;
		for(int i=bottomC+1; i<C-1; i++) nextBoard[bottomR][i+1] = board[bottomR][i]; 
		
		// �Ʒ���
		for(int i=bottomR; i<R-1; i++) nextBoard[i+1][C-1] = board[i][C-1];
		
		// ��������
		for(int i=C-1; i>0; i--) nextBoard[R-1][i-1] = board[R-1][i];
		
		// ���� 
		for(int i=R-1; i>bottomR+1; i--) nextBoard[i-1][bottomC] = board[i][bottomC];
		
		
		board = nextBoard;
	}
}

class MicroDustLocation {
	int r;
	int c; 
	
	public MicroDustLocation(int _r, int _c) {
		r = _r; 
		c = _c; 
	}
}

class MicroDustCleaner {
	int x;
	int y; 
	
	public MicroDustCleaner(int _x, int _y) {
		x = _x;
		y = _y; 
	}
}
