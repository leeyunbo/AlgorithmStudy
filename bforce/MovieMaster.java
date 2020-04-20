package bforce;

/*
 * https://www.acmicpc.net/problem/1436
 * ���� 1436�� ��ȭ���� �� 
 * �ð� ���� 2��, �޸� ���� 128MB
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
