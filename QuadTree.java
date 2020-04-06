package divideandconquer;
import java.util.*;

public class QuadTree {
	static char[][] decompressed = new char[16][16];
	static String compressed;
    
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		compressed = scanner.nextLine();
		decompressed(0,0,16);
		for(int i=0; i<16; i++) {
			for(int j=0; j<16; j++) {
				System.out.print(decompressed[i][j]);
			}
			System.out.println();
		}
	}
	
	private static void decompressed(int x, int y,int size) {
		char head = compressed.charAt(0);
		
		if(head == 'b' || head == 'w') {
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					decompressed[y+i][x+j] = head; 
				}
			}
		}
		else { //만약 x인 경우 
			int half = size/2;
			compressed = compressed.substring(1);
			decompressed(x,y,half);
			compressed = compressed.substring(1);
			decompressed(x+half,y,half);
			compressed = compressed.substring(1);
			decompressed(x,y+half,half);
			compressed = compressed.substring(1);
			decompressed(x+half,y+half,half);
		}
	}
}
