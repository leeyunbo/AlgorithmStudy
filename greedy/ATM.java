package greedy;
/*
 * https://www.acmicpc.net/problem/11399
 * น้มุ 11399น๘ ATM 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ATM {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n = Integer.parseInt(br.readLine());
		
		String[] line = br.readLine().split(" ");
		
		int[] peoples = new int[n];
		for(int i=0; i<n; i++) {
			peoples[i] = Integer.parseInt(line[i]);
		}
		
		Arrays.sort(peoples);
		
		int result = peoples[0];
		for(int i=1; i<n; i++) {
			peoples[i] = peoples[i-1] + peoples[i];
			result += peoples[i];
		}
		
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}
}
