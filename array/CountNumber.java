package array;
/*
 * https://www.acmicpc.net/problem/2577
 * ���� 2577�� ������ ���� 
 * �ð� ���� 1��, �޸� ���� 128MB
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountNumber {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] counts = new int[10];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		String number = String.valueOf(A*B*C);
		
		for(int i=0; i<number.length(); i++) {
			counts[Character.getNumericValue(number.charAt(i))]++;
		}
		
		for(int i=0; i<counts.length; i++) {
			System.out.println(counts[i]);
		}
	}
}
