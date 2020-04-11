package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *  https://www.acmicpc.net/problem/11720
 *  백준 11720번 숫자의 합 
 *  시간 제한 1초, 메모리 제한 256MB
 */

public class NumberSum {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String numbers = br.readLine();
		
		int total = 0;
		for(int i=0; i<N; i++) {
			total += Character.getNumericValue(numbers.charAt(i));
		}
		System.out.println(total);
	}
}
