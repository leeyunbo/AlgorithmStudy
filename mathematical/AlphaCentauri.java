package mathematical;

/*
 * https://www.acmicpc.net/problem/1011
 * 백준 1011번 Fly me to the Alpha Centauri 
 * 시간 제한 2초, 메모리 제한 512MB 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AlphaCentauri {
	static final long INF = 2000000000;
	static long result = INF;
	static long x = 0;
	static long y = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			String[] line = br.readLine().split(" "); 
			x = Integer.parseInt(line[0]);
			y = Integer.parseInt(line[1]);
			moveToCentauri(0, 0, 0);
			bw.write(result+"\n");
			result = INF;	
		}
		bw.flush();
		bw.close();
	}
	
	public static void moveToCentauri(long k, long time, long distance) {
		// base-case
		// 이동거리가 도착거리를 넘었으면 return 
		// 목적지에 도착하는 경우 최솟값을 계산 후 return  
		if(distance >= (y-x)) return;
		if(distance == (y-x)-1) {
			result = Math.min(result, time+1);
			return; 
		}
		
		// recursion-case
		// k-1, k , k+1번 만큼 이동한다.
		if((k-1)>0) 
			moveToCentauri(k-1, time+1, distance+k-1);
		if(k>0) 
			moveToCentauri(k, time+1, distance+k);
		if((k+1)>0)
			moveToCentauri(k+1, time+1, distance+k+1);	
		return; 
	}
}
