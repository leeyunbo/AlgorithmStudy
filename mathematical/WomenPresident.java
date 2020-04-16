package mathematical;
/*
 * https://www.acmicpc.net/problem/2775
 * ���� 2775�� �γ�ȸ���� ���׾�
 * �ð� ���� 1��, �޸� ���� 128MB
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
			
			// 0������ ��� ���� �ʱ�ȭ �Ѵ�.
			for(int time = 1; time<=n; time++) {
				humanCnts[time] = time;
			}
			
			// �� ���� ���Ͽ� ��� �濡 ���� �ݺ��Ѵ�.
			// �Ʒ����� ��� ���� ��� �ִ� array�� �̿��Ͽ� �ش�Ǵ� ���� �ο� ���� ����Ѵ�.
			// ���� �� aȣ �ο� �� = �Ʒ� �� aȣ ������ �ο� ����
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
