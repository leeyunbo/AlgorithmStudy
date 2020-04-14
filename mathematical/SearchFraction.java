package mathematical;

/*
 * https://www.acmicpc.net/problem/1193
 * ���� 1193�� �м�ã�� 
 * �ð� ���� 0.5��, �޸� ���� 256MB
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchFraction {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int denominator = 1; //�и�
		int numerator = 1; //����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		int cnt = 1;
		int tempCnt = 1;
		boolean isTop = true; 
		for(int i=1; i<X; i++) {
			if(tempCnt == cnt) {
				if(isTop) denominator++;
				else numerator++;
				isTop = !isTop;
				tempCnt = 1;
				cnt++;
			}
			else {
				if(!isTop) {
					denominator--;
					numerator++;
				}
				else {
					denominator++;
					numerator--;
				}
				tempCnt++;
			}
		}
		System.out.println(numerator+"/"+denominator);
	}
}
