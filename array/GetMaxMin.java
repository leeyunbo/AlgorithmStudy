package array;
/*
 * https://www.acmicpc.net/problem/10818
 * 백준 10818번 최소, 최대 
 * 시간 제한 1초, 메모리 제한 256MB
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetMaxMin {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int max = -1000000;
		int min = 1000000;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] line = br.readLine().split(" ");
		
		for(int i=0; i<n; i++) {
			int temp = Integer.parseInt(line[i]);
			max = Math.max(max,temp);
			min = Math.min(min,temp);
		}
		System.out.println(min+ " " +max);	
	}
}
