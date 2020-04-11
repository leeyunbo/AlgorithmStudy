package array;

/*
 * https://www.acmicpc.net/problem/1546
 * 백준 1546번 평균
 * 시간 제한 2초, 메모리 제한 128MB
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AverageOperation {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = 0;  
		double M = 0; 
		double total = 0;
		double[] scoreArray;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); 
		scoreArray = new double[N]; 
		String[] line = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			scoreArray[i] = Double.parseDouble(line[i]);
			M = Math.max(scoreArray[i], M);
		}
		
		for(int i=0; i<N; i++) {
			scoreArray[i] = (scoreArray[i]/M) * 100;
			total += scoreArray[i]; 
		}
		
		
		System.out.println(total/N);
		
	}
}

