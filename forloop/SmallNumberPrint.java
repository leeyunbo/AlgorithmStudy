package forloop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/10871
 * ���� 10871�� X���� ���� �� 
 * �ð� ���� 1��, �޸� ���� 256MB 
 */

public class SmallNumberPrint {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" "); 
		int n = Integer.parseInt(line[0]);
		int number = Integer.parseInt(line[1]); 
		
		String[] others = br.readLine().split(" ");
		
		
		for(int idx=0; idx<n; idx++) {
			if(Integer.parseInt(others[idx]) < number) {
				System.out.print(others[idx]+ " ");
			}
		}
	}
}
