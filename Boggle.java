import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Boggle {
	static int go[][] = {{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,1},{-1,-1},{1,-1}};
	static int cnt = 0;
	static char[][] board = {
			{'a','a','b','c','e'},
			{'a','a','b','c','e'},
			{'a','a','b','c','e'},
			{'a','a','b','c','e'},
			{'a','a','b','c','e'}};
	static String words = "abce";
	
	public static void main(String[] args) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				boggle(i,j,words);
				if(cnt > 0) {
					System.out.println("있네");
					return;
				}
			}
		}
		
		System.out.println("없네");
		
	
	}
	
	public static boolean boggle(int y, int x, String words) {
		
		
		if(x < 0 || y < 0 || x > 4 || y > 4) {
			return false;
		}
		
		if(board[y][x] != words.charAt(0)) { 
			return false;
		}
		
		if(words.length() == 1) {
			cnt++;
			return true;
		}
		
		for(int i=0; i<go.length; i++) {
			int moveY = y + go[i][1];
			int moveX = x + go[i][0];
			if(boggle(moveY,moveX,words.substring(1))) {
				return true;
			}
		}
		
		return false;
	}

}
