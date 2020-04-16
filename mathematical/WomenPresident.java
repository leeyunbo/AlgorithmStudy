package mathematical;
/*
 * https://www.acmicpc.net/problem/2775
 * 백준 2775번 부녀회장이 될테야
 * 시간 제한 1초, 메모리 제한 128MB
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class WomenPresident {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cnt = Integer.parseInt(br.readLine());
		for(int i=0; i<cnt; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[] humanCnts = new int[n+1];
			
			// 0층부터 사람 수를 초기화 한다.
			for(int time = 1; time<=n; time++) {
				humanCnts[time] = time;
			}
			
			// 각 층에 대하여 모든 방에 대해 반복한다.
			// 아래층의 사람 수를 담고 있는 array를 이용하여 해당되는 방의 인원 수를 계산한다.
			// 현재 층 a호 인원 수 = 아래 층 a호 까지의 인원 총합
			int sum = 0;
			for(int floor = 1; floor <= k; floor++) {
				sum = 0;
				for(int time = 1; time <= n; time++) {
					sum += humanCnts[time];
					humanCnts[time] = sum; 
				}
			}
			
			bw.write(humanCnts[n]+"\n");		
		}
		bw.flush();
		bw.close();
	}
}
