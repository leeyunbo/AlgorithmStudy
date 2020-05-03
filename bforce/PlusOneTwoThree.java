package bforce;
/*
 * https://www.acmicpc.net/problem/9095
 * 백준 9095번 1, 2, 3 더하기 
 * 시간 제한 1초, 메모리 제한 128MB
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PlusOneTwoThree {
	static int aim = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			aim = Integer.parseInt(br.readLine());
			bw.write(func(0)+"\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	private static int func(int total) {
		int ret = 0;
		if(total == aim) return 1;
		if(total > aim) return 0;
		
		ret += func(total + 1);
		ret += func(total + 2);
		ret += func(total + 3);
		
		return ret;
	}

}
