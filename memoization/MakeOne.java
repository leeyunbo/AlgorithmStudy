package memoization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * ���� X�� ����� �� �ִ� ������ ������ ���� �� ���� �̴�.

X�� 3���� ������ ��������, 3���� ������.
X�� 2�� ������ ��������, 2�� ������.
1�� ����.
���� N�� �־����� ��, ���� ���� ���� �� ���� ������ ����ؼ� 1�� ������� �Ѵ�. ������ ����ϴ� Ƚ���� �ּڰ��� ����Ͻÿ�.
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
