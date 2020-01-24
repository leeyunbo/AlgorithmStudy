package memoization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
 */
public class MakeOne {
	static final int INF = 123456;
	static int[] cache;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		cache = new int[N+1];
		Arrays.fill(cache, -1);
		System.out.println(MakeOne(N));
	}
	
	private static int MakeOne(int num) {
		if(num==1) return 0;
		
		if(num == INF) return INF; //base-case 
		
		if(cache[num] != -1) return cache[num]; //check cache
		
		return cache[num] = 1 + Math.min(Math.min(MakeOne(one(num)), MakeOne(two(num))),MakeOne(three(num))); //recursion-case
	}
	
	private static int one(int num) {
		if(num % 3 == 0) return num/3;
		
		return INF;
	}
	
	private static int two(int num) {
		if(num % 2 == 0) return num/2;
		
		return INF;
	}

	private static int three(int num) {
		return num-1;
	}

}
