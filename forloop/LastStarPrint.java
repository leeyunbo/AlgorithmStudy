package forloop;

/*
 * https://www.acmicpc.net/problem/10996
 * 백준 10996번 별 찍기 - 21
 * 시간 제한 1초, 메모리 제한 256MB
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LastStarPrint {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int firstCnt = 0;
		int secondCnt = 0;
		int spaceCnt = 0;
		for(int i=1; i<=n; i++) {
			if(n%2==0) {
				firstCnt=secondCnt=n/2; 
			}
			else {
				firstCnt = n/2 + n%2; 
				secondCnt = firstCnt - n%2; 
			}
			for(int j=0; j<firstCnt; j++) {
				if(j==firstCnt-1) System.out.print("*");
				else System.out.print("* ");
			}
			System.out.println();
			for(int j=0; j<secondCnt; j++) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}
}
