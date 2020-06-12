package samsungswtest;
/*
 * https://www.acmicpc.net/problem/17144
 * 백준 17144번, 미세먼지 안녕!
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
		
		// 1. 미세먼지의 Weight 추가, 공기 청정기의 위치 체크 
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
		// 2. T 초 동안 반복한다
		for(int time=1; time<=T; time++) {
		// 2-1. 미세먼지를 확산하여 최신화 시킨다.
			spreadMicroDust();
		
		// 2-2. 공기청정기를 가동시켜 미세먼지를 이동 시킨다. 
			startCleaning();
		}
		
		// 3. T초 후, 미세먼지의 총합을 구한다. 
		System.out.println(sumMicroDust());
		
	}
	
	private static void spreadMicroDust() {
		int[][] nextBoard = new int[R][C]; 

		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				nextBoard[i][j] = board[i][j];
			}
		}
		
		// 미세먼지가 존재하는 모든 칸에 대하여, 미세먼지 확산을 계산한다 
		// 만약 범위가 벗어나거나, 에어컨이 존재하는 위치라면 패스한다.
		// 만약 확산된 곳이, 원래는 미세먼지가 존재하던 위치가 아니라면 미세먼지 위치를 갖고 있는 리스트에 추가한다.
		// 확산된 방향의 수를 체크하여, 미세먼지 양을 조정한다.
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
		
		// 변화된 미세먼지의 정보를 최신화 시켜준다. 
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

		
		// 1. 위쪽을 청소한다.
		// ->
		nextBoard[topR][topC+1] = 0;
		for(int i=topC+1; i<C-1; i++) nextBoard[topR][i+1] = board[topR][i]; 
		
		// 위로
		for(int i=topR; i>0; i--) nextBoard[i-1][C-1] = board[i][C-1];

		// 왼쪽으로
		for(int i=C-1; i>0; i--) nextBoard[0][i-1] = board[0][i];
		
		// 아래로
		for(int i=0; i<topR-1; i++) nextBoard[i+1][topC] = board[i][topC];
		
		
		// 2. 아래쪽을 청소한다. 
		// ->
		nextBoard[bottomR][bottomC+1] = 0;
		for(int i=bottomC+1; i<C-1; i++) nextBoard[bottomR][i+1] = board[bottomR][i]; 
		
		// 아래로
		for(int i=bottomR; i<R-1; i++) nextBoard[i+1][C-1] = board[i][C-1];
		
		// 왼쪽으로
		for(int i=C-1; i>0; i--) nextBoard[R-1][i-1] = board[R-1][i];
		
		// 위로 
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
