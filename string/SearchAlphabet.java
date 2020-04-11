package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/10809
 * 백준 10809번 알파벳 찾기
 * 시간 제한 1초, 메모리 제한 256MB
 */

public class SearchAlphabet {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String word = br.readLine();
		int[] isCheck = new int['z'-'a'+1];
		Arrays.fill(isCheck,-1);
		
		for(int i=0; i<word.length(); i++) {
			int idx = word.charAt(i) - 'a'; 
			if(isCheck[idx] == -1) isCheck[idx] = i; 
		}
		
		for(int i=0; i<isCheck.length; i++) {
			bw.append(isCheck[i]+ " ");
		}
		bw.flush();
		bw.close();
	}
}
