package forloop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/10039
 * 백준 10039번 평균 점수 
 * 시간 제한 1초, 메모리 제한 128MB
 */
public class ScoreAverage {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int total = 0;
		int score = 0;
		for(int i=0; i<5; i++) {
			score = Integer.parseInt(br.readLine());
			if(score < 40) total += 40; 
			else total += score; 
		}
		System.out.println(total/5);
	}
}
