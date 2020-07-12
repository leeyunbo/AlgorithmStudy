package algorithmbook;

/*
 *	algoSpot.com 
 *	ID : CLOCKSYNC 문제 풀이 
 *	최대 4번까지 가능하지 않나?  
 *	겹치는 경우, 앞에서 3번 누르고 뒤에서 4번 누르면 7번... 만약에 3번으로 제한하면 앞에서 3번 누르고 뒤에서 3번 누르면 6번 회전....? 
 *	따라서 최대 4번 아닌가?
 *	아 만약, 뒤에서 4번누르면 결국 다시 원상태로 복귀하는구나...
 *	따라서 최대 3번이다! 각 스위치는 독립 시행으로 보는 것
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
			// 스위치와 연결된 모든 시계에 대하여 
			for(int j=0; j<switchConnection[switchId].length; j++) {
				// i번 만큼 회전 시킨다. 
				for(int k=0; k<i; k++) {
					if(clock[switchConnection[switchId][j]] == 12) clock[switchConnection[switchId][j]] = 3; 
					else clock[switchConnection[switchId][j]] += 3;
				}
			}
			
			// 다음 스위치로 넘어감
			clockChange(switchId + 1, clickCnt + i);
			
			// back-Tracking, 연결된 모든 시계에 대하여 다시 i번 만큼 되돌린다.
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
