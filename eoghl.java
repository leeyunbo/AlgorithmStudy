package coding;
import java.util.*;

public class eoghl {
	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		int H = in.nextInt();
		int M = in.nextInt();
		
		if(M < 45) {
			H = H - 1;
			M = M - 45 + 60; 
		} else {
			M = M - 45;
		}
		
		if(H < 0) {
			H += 24;
		}
		
		System.out.print(H+" "+M);
		
	}
	
	

}
