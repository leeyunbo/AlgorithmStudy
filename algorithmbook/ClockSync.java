package algorithmbook;

/*
 *	algoSpot.com 
 *	ID : CLOCKSYNC ���� Ǯ�� 
 *	�ִ� 4������ �������� �ʳ�?  
 *	��ġ�� ���, �տ��� 3�� ������ �ڿ��� 4�� ������ 7��... ���࿡ 3������ �����ϸ� �տ��� 3�� ������ �ڿ��� 3�� ������ 6�� ȸ��....? 
 *	���� �ִ� 4�� �ƴѰ�?
 *	�� ����, �ڿ��� 4�������� �ᱹ �ٽ� �����·� �����ϴ±���...
 *	���� �ִ� 3���̴�! �� ����ġ�� ���� �������� ���� ��
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ClockSync {
	
	static int[] clock = new int[16];
	static int[][] switchConnection = {{0,1,2}, {3,7,9,11}, {4,10,14,15}, {0,4,5,6,7}, {6,7,8,10,12}, {0,2,14,15}, {3,14,15}, {4,5,7,14,15}, {1,2,3,4,5}, {3,4,5,9,13}};
	static int answer = 654321;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCaseCnt = Integer.parseInt(br.readLine());
		
		for(int i=0; i<testCaseCnt; i++) {
			String line[] = br.readLine().split(" ");
			
			for(int j=0; j<line.length; j++) {
				clock[j] = Integer.parseInt(line[j]);
			}
			
			
			clockChange(0, 0);
			
			bw.write(answer + "\n");
			
			answer = 654321; 
		}
		
		bw.flush();
		
	}
	
	private static void clockChange(int switchId, int clickCnt) {
		if(check()) {
			answer = Math.min(clickCnt, answer);
			return;
		}
		
		if(switchId >= switchConnection.length) return; 
		
		for(int i=0; i<=3; i++) {
			// ����ġ�� ����� ��� �ð迡 ���Ͽ� 
			for(int j=0; j<switchConnection[switchId].length; j++) {
				// i�� ��ŭ ȸ�� ��Ų��. 
				for(int k=0; k<i; k++) {
					if(clock[switchConnection[switchId][j]] == 12) clock[switchConnection[switchId][j]] = 3; 
					else clock[switchConnection[switchId][j]] += 3;
				}
			}
			
			// ���� ����ġ�� �Ѿ
			clockChange(switchId + 1, clickCnt + i);
			
			// back-Tracking, ����� ��� �ð迡 ���Ͽ� �ٽ� i�� ��ŭ �ǵ�����.
			for(int j=0; j<switchConnection[switchId].length; j++) {
				for(int k=0; k<i; k++) {
					if(clock[switchConnection[switchId][j]] == 3) clock[switchConnection[switchId][j]] = 12; 
					else clock[switchConnection[switchId][j]] -= 3;
				}
			}
		}
	}
	
	private static boolean check() {
		boolean isFinish = true; 
		
		for(int i=0; i<clock.length; i++) {
			if(clock[i] != 12) {
				isFinish = false;
				break;
			}
		}
		
		return isFinish;
	}

}
