
public class fastSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		System.out.println(fastSum(n));

	}
	
	public static int fastSum(int n) {
		if(n==1) return 1;
		if(n%2==1) return fastSum(n-1) + n;
		return 2 * fastSum(n/2) + (n*n)/4;
	}

}
