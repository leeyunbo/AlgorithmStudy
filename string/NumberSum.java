package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *  https://www.acmicpc.net/problem/11720
 *  ���� 11720�� ������ �� 
 *  �ð� ���� 1��, �޸� ���� 256MB
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
