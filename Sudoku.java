import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Sudoku {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] moveArray = {{1,0},{1,1},{0,1},{-1,0},{-1,-1},{0,-1},{1,-1},{-1,1}};
	static int[][] board;
	static boolean[][] isFinish;
	static boolean row[][] = new boolean[9][9]; //가로
	static boolean column[][] = new boolean[9][9]; //세로
	static boolean square[][] = new boolean[9][9]; //사각형 3X3 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<9; i++) {
			String buffer = br.readLine();
			String[] line = buffer.split(" ");
			for(int j=0; j<9; j++) {
				int data = Integer.parseInt(line[j]);
				if(data==0) {
					isFinish[i][j] = false;
				} else {
					isFinish[i][j] = true;
				}
				board[i][j] = data;
			}	
		}			
	}
	
	public static int square(int i, int j) {
		return i+j; 
	}
	
	public static void Sudoku(int i, int j) {
		
		if(i == 9) {
			//스도쿠 출력 
			System.exit(0);// 프로그램 종료
		}
		
		if(board[i][j] > 0) {
			
		} else {
			for(int k=1; k<10; k++) {
				if(j==8) {
					Sudoku(i+1,0);
				}
				else {
					Sudoku(j,i+1);
				}
			}
		}
		
		
	}
}
