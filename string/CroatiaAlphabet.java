package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/2941
 * 백준 2941번 크로아티아 알파벳 
 * 시간 제한 1초, 메모리 제한 128MB
 */
public class CroatiaAlphabet {
	public static void main(String[] args) throws IOException {
		ArrayList<String> croatiaAlphabet = new ArrayList<>(Arrays.asList("c=","c-","dz=","d-","lj","nj","s=","z="));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 0;
		String word = br.readLine();
		for(int i=0; i<word.length(); i++) {
			if(i<word.length()-1 && croatiaAlphabet.contains(word.substring(i, i+2))) {
				cnt++;
				i = i + 1; 
			}
			else if (i<word.length()-2 && croatiaAlphabet.contains(word.substring(i, i+3))){
				cnt++;
				i = i + 2;
			}
			else {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
