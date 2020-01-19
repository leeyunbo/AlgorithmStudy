package memoization;

import java.util.Arrays;
import java.util.Scanner;

public class Fib {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long cache[] = new long[n+1];
		Arrays.fill(cache, -1);
		System.out.println(fib(n,cache));
	}
	
	private static long fib(int n, long cache[]) {
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		if(cache[n] != -1) {
			return cache[n];
		}
		
		
		return cache[n] = fib(n-2,cache) + fib(n-1,cache);
	}

}
