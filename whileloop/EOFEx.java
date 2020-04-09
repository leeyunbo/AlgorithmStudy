package whileloop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * https://www.acmicpc.net/problem/10951
 * 백준 10951번 A+B -4 
 * 시간 제한 1초, 메모리 제한 256MB 
 */
public class EOFEx {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		String[] lineArray;
		while(true) {
			line = br.readLine();
			if(line == null) break;
			lineArray = line.split(" ");
			int A = Integer.parseInt(lineArray[0]);
			int B = Integer.parseInt(lineArray[1]);
			System.out.println(A+B);
		}
	}

}
