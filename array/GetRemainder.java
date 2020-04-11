package array;

/*
 * https://www.acmicpc.net/problem/3052
 * ���� 3052�� ������ 
 * �ð� ���� 1��, �޸� ���� 128MB
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetRemainder {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] numbers = new int[42];
		for(int i=0; i<10; i++) {
			numbers[Integer.parseInt(br.readLine())%42]++;
		}
		
		int result = 0;
		for(int i=0; i<42; i++) {
			if(numbers[i] > 0) result++; 
		}
		System.out.println(result);
	}
}
