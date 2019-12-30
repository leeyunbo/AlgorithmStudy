package coding;
import java.util.*;

class Snail {
	int A;
	int B;
	
	Snail(int A, int B) {
		this.A = A;
		this.B = B;
	}
}

public class snailCheck {
	public static void main(String[] args) {
		int V,A,B = 0;
		Scanner scanner = new Scanner(System.in);
		A = scanner.nextInt();
		B = scanner.nextInt();
		V = scanner.nextInt();
		Snail snail = new Snail(A,B);
		System.out.println(snailDayCheck(V,snail.A,snail.B));
	}
	
	public static int snailDayCheck(int V,int A,int B) {
		int sum = 0;
		int day = 0;
		int other = 0;
		int V2 = 0;
		
		V2 = V - A;
		day = V2 / (A-B);
		other = V2 % (A-B);
		
		if(other == 0)
			return day + 1;
		
		return day + 2;
		
	}
}

