package forloop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/2438
 * ���� 2438�� �� ��� - 1
 * �ð� ���� 1��, �޸� ���� 128MB
 */
public class StarPrint {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); 
		for(int printCnt = 1; printCnt <= n; printCnt++) {
			for(int cnt = 1; cnt <= printCnt; cnt++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
