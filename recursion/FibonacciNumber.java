package coding;

import java.util.Scanner;

public class FibonacciNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if(n >20) {
			return;
		}
		System.out.println(fib(n));
		

	}
	
	public static int fib(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
		
		if(n == 0) {
			return 0;
		}
		
		return fib(n-1) + fib(n-2);
	}

}
