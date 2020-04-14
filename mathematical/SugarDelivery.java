package mathematical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/2839
 * ���� 2839�� ���� ��� 
 * �ð� ���� 1��, �޸� ���� 128MB
 */

public class SugarDelivery {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sugarWeight = Integer.parseInt(br.readLine());
		
		int cnt = 654321;
		for(int i=0; i<=sugarWeight/5; i++) {
			int tempCnt = i;
			int remainder = sugarWeight - (5*i);
			if(remainder % 3 == 0) {
				System.out.print("5 : " + tempCnt);
				tempCnt = tempCnt + remainder/3;
				System.out.println(" 3 : " + remainder/3);
				cnt = Math.min(cnt, tempCnt);
			}
		}
		
		if(cnt == 654321) System.out.println(-1);
		else System.out.println(cnt);
	}
}
