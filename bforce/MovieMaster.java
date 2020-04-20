package bforce;

/*
 * https://www.acmicpc.net/problem/1436
 * 백준 1436번 영화감독 숌 
 * 시간 제한 2초, 메모리 제한 128MB
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MovieMaster {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		int temp = 666;
		int cnt = 1;
		while(cnt < N) {
			temp++;
			if(String.valueOf(temp).contains("666")) {
				cnt++;
			}
		}
		System.out.println(temp);
	}
}
