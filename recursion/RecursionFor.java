package coding;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * n개의 원소중 m개를 골라야함
 * 이걸 재귀호출로 풀어라
 */
public class RecursionFor {
	static int count = 0;
	static int[][][] coverType = 
		{{{0,0},{1,0},{0,-1}},
		 {{0,0},{1,0},{0,1}},
		 {{0,0},{0,1},{1,1}},
		 {{0,0},{1,0},{1,1}}};
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int H,W;
		ArrayList<String> board = new ArrayList<String>();
		ArrayList<Integer> count_list = new ArrayList<Integer>();
		int c = scanner.nextInt();
		
		for(int i=0; i<c; i++) {
			H = scanner.nextInt();
			W = scanner.nextInt();
			for(int j=0; j<H; j++) {
				board.add(scanner.nextLine());
			}
			boardCover(0,0,board);
			count_list.add(count);
			count = 0;
			board.clear();
		}	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	
	public static void boardCover(int y, int x, ArrayList<String> board) {
		if(!isWhite(y,x,board)) {
			return;
		}
		
		
		
		
		
		
		
		
	}
	
	public static boolean isWhite(int y, int x, ArrayList<String> board) {
		if(board.get(y).charAt(x) != '.') {
			return false;
		}
		return true;
	}

}
