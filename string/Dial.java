package string;
/*
 * https://www.acmicpc.net/problem/5622
 * 백준 5622번 다이얼 
 * 시간 제한 1초, 메모리 제한 128MB
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Dial {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		int time = 0;
		for(int i=0; i<word.length(); i++) {
			char temp = word.charAt(i);
			if(temp >= 'W') {
				time += 10; 
			}
			else if(temp >= 'T') {
				time += 9; 
			}
			else if(temp >= 'P') {
				time += 8; 
			}
			else if(temp >= 'M') {
				time += 7; 
			}
			else if(temp >= 'J') {
				time += 6; 
			}
			else if(temp >= 'G') {
				time += 5; 
			}
			else if(temp >= 'D') {
				time += 4;
			}
			else {
				time += 3;
			}
		}
		
		System.out.println(time);
	}

}
