package array;
/*
 * https://www.acmicpc.net/problem/2562
 * 백준 2562번 최댓값 
 * 시간 제한 1초, 메모리 제한 128MB
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetMaxIndex {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		int maxIdx = 0;
		for(int i=0; i<9; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(max < temp) {
				max = temp; 
				maxIdx = i;
			}
		}
		System.out.println(max);
		System.out.println(maxIdx+1);
	}
}
