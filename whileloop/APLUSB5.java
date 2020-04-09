package whileloop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * https://www.acmicpc.net/problem/10952
 * 백준 10952번 A+B - 5
 * 시간 제한 1초, 메모리 제한 256MB
 */
public class APLUSB5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		String[] line;
		while(true) {
			line = br.readLine().split(" "); 
			int A = Integer.parseInt(line[0]);
			int B = Integer.parseInt(line[1]);
			if(A == 0 && B == 0) break;
			list.add(A+B);
		}
		
		for(int result : list) {
			System.out.println(result);
		}
	}
}
