package backTracking;
import java.util.Scanner;

public class Picnic {
	static int cnt = 0;
	static boolean[][] friend_list = new boolean[10][10];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int C = scanner.nextInt();
		for(int i=0; i<C; i++) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			boolean[] isSelect = new boolean[n];
			for(int j=0; j<n; j++) {
				isSelect[i] = false;
			}
			for(int j=0; j<m; j++) {
				int r_i = scanner.nextInt();
				int d_i = scanner.nextInt();
				friend_list[r_i][d_i] = true;
			}
			
						
			
			int ret = picnic(isSelect);
			System.out.println(ret);
			
		}

	}
	
	public static int picnic(boolean[] isSelect) {
		boolean finished = true;
		int first = 0;
		for(int i=0; i<isSelect.length; i++) {
			if(!isSelect[i]) {
				first = i;
				finished = false;
				break;
			}	
		}
				
		if(finished) {
			return 1;
		}		
		int ret = 0;
		
		for(int i=first+1; i<isSelect.length; i++) {
			if(!isSelect[i] && friend_list[first][i]) {
				isSelect[first] = isSelect[i] = true;
				ret += picnic(isSelect);
				isSelect[first] = isSelect[i] = false;
			}
		}
		
		return ret;
		
		
	
		
		
	}

}
