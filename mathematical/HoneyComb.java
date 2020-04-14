package mathematical;

/*
 * https://www.acmicpc.net/problem/2292
 * 백준 2292번 벌집 
 * 시간 제한 2초, 메모리 제한 128MB
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HoneyComb {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(n == 1) {
			System.out.println(1); 
			return;
		}
		
		int i = 1;
		int num = 1;
		int nextNum = 2; 
		while(true) {
			num  += 6*i;
			if(n >= nextNum && n <= num) {
				System.out.println(i+1);
				return;
			}
			nextNum = num + 1;
			i++;
		}
	}
}
