package forloop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/2438
 * 백준 2438번 별 찍기 - 1
 * 시간 제한 1초, 메모리 제한 128MB
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
