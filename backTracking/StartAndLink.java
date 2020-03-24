package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/source/18647201

public class StartAndLink {
		static int minResult = 1000000000;
		static int N;
		static int[][] array;
		static boolean[] isChecked;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N][N];
		isChecked = new boolean[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int count = st.countTokens();
			for(int j=0; j<count; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
			
		//1. A와 B팀의 차이가 최소인 경우를 계산한다. 
		StartAndLinkFunc(0,0);
		
		//2. 결과를 출력한다.
		System.out.println(minResult);
		
	}
	
	private static void StartAndLinkFunc(int startNode, int depth) {
		//1. A팀이 꽉찼으면, A팀과 B팀의 점수를 계산 
		if(depth == N/2) {
			CalcScore();
			return;
		}
		
		//2. A팀이 꽉차지 않았다면, 모든 경우의 수를 체크한다. 
		for(int i=startNode; i<N; i++) {
			if(isChecked[i] == false) {
				isChecked[i] = true;
				StartAndLinkFunc(i+1,depth+1);
				isChecked[i] = false;
			}
		}
		
	}
	
	private static void CalcScore() {
		int aScore = 0;
		int bScore = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(isChecked[i]==true && isChecked[j]==true) 
					aScore += array[i][j]; 
				else if(isChecked[i] == false && isChecked[j] == false) 
					bScore += array[i][j];
			}
		}
		
		if(minResult > Math.abs(aScore-bScore)) {
			minResult = Math.abs(aScore-bScore);
		}
		
	}

}
