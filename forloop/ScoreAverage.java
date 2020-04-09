package forloop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.acmicpc.net/problem/10039
 * ���� 10039�� ��� ���� 
 * �ð� ���� 1��, �޸� ���� 128MB
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
