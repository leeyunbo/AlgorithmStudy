package forloop;
/*
 * https://www.acmicpc.net/problem/2446
 * ���� 2446�� �� ��� - 9
 * �ð� ���� 1��, �޸� ���� 128MB 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HardStarPrint {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int starMaxCnt = n * 2 - 1;
	
		for(int i=n; i>0; i--) {
			int starCnt = i*2-1;
			int spaceCnt = starMaxCnt - starCnt;
			
			for(int j=0; j<spaceCnt/2; j++) {
				System.out.print(" ");
			}
		
			for(int j=0; j<starCnt; j++) {
				System.out.print("*");
			}
			
			
			System.out.println();
		}
		
		for(int i=2; i<=n; i++) {
			int starCnt = i*2-1; 
			int spaceCnt = starMaxCnt - starCnt;
			
			for(int j=0; j<spaceCnt/2; j++) {
				System.out.print(" ");
			}
			
			for(int j=0; j<starCnt; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
}
