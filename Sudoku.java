import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Sudoku {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] moveArray = {{1,0},{1,1},{0,1},{-1,0},{-1,-1},{0,-1},{1,-1},{-1,1}};
	static int[][] board = new int[9][9];
	static boolean row[][] = new boolean[10][10]; //가로
	static boolean column[][] = new boolean[10][10]; //세로
	static boolean square[][] = new boolean[9][10]; //사각형 3X3 
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<9; i++) {
			String buffer = br.readLine();
			String[] line = buffer.split(" ");
			for(int j=0; j<9; j++) {
				int data = Integer.parseInt(line[j]);
				board[i][j] = data;
				if(data!=0) {
					row[i][data] = true;
					column[j][data] = true;
					square[square(i,j)][data] = true;
				}
			}	
		}

		Sudoku(0,0);
	}
	
	private static int square(int i, int j) {
		return j/3 + (i/3) * 3; 
	}
	
	private static void printSudoku() {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(j==8) {
					System.out.print(board[i][j]);
				} else {
					System.out.print(board[i][j]+ " ");
				}
			}
			System.out.println();
		}
	}
	
	private static boolean checkSudoku() {
		boolean isFinish = true;
		for(int i=0; i<9; i++) {
			for(int j=1; j<10; j++) {
				if(row[i][j] != true) {
					isFinish = false;
					break;
				}
			}
			if(isFinish) break;
		}
		
		return isFinish;
	}
	
	private static void Sudoku(int i, int j) {
		
		if(i == 9) {
			//if(checkSudoku()) {
				printSudoku();
				System.exit(0);// 프로그램 종료
			//} else {
			//	return;
			//}
		}
		
		if(board[i][j] > 0) {
			if(j==8) {
				Sudoku(i+1,0);
			}
			else {
				Sudoku(i,j+1);
			}
			
		} else {
			for(int k=1; k<10; k++) {
				if(!row[i][k] && !column[j][k] && !square[square(i,j)][k])
					if(j==8) {
						board[i][j] = k;
						row[i][k] = column[j][k] = square[square(i,j)][k] = true;
						Sudoku(i+1,0);
						//board[i][j] = 0;
						//row[i][k] = column[j][k] = square[square(i,j)][k] = false;
					}
					else {
						board[i][j] = k;
						row[i][k] = column[j][k] = square[square(i,j)][k] = true;
						Sudoku(i,j+1);
						//board[i][j] = 0;
						//row[i][k] = column[j][k] = square[square(i,j)][k] = false;
					}
			}
		}
		
		
	}
}
