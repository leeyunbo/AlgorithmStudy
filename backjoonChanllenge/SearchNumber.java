/*
 * https://www.acmicpc.net/problem/1920
 * 백준 1920번 수 찾기 
 */

package backjoonChanllenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SearchNumber {

	static int[] array; 
	
	public static void main(String[] args) throws IOException {
		int N, M;
		
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N]; 
		
		String[] line = br.readLine().split(" "); 
		for(int i=0; i<N; i++) {
			array[i] = Integer.parseInt(line[i]);
		}
		Arrays.sort(array);
		
		M = Integer.parseInt(br.readLine());
		
		line = br.readLine().split(" ");
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(line[i]);
			searchNum(num);
		}
	}
	
	
	static void searchNum(int num) {
		if(bSearch(num, 0, array.length-1)) System.out.println(1);
		else System.out.println(0);
	}
	
	
	static boolean bSearch(int num, int left, int right) {
		if(left > right) return false; 
		
		int mid = (left+right)/2;
		if(array[mid] == num) return true; 
		else if(array[mid] < num) return bSearch(num, mid+1, right);
		else return bSearch(num, left, mid-1);
	}

}
