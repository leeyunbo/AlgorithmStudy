package memoization;
import java.util.Arrays;

public class Quantization {
		static final int INF = 654321;
		static int[] b = {1,744,755,4,897,902,890,6,777};
	public static void main(String[] args) {
		Arrays.sort(b);
		int cache[][] = new int[b.length][3];
		for(int i=0; i<cache.length; i++) {
			Arrays.fill(cache[i], -1);
		}
		System.out.println(Quantization(0, 3, cache));
	}
	
	private static int Quantization(int start, int parts, int cache[][]) { //index, parts 
		int ret = INF;
		
		if(start == b.length) {
			return 0;
		} //숫자가 더이상 없는 경우
		
		if(parts == 0) {
			return INF;
		} //숫자는 남아있는데 parts가 남은 경우 
		
		if(cache[start][parts-1] != -1) return cache[start][parts-1];
		
		for(int i=1; i<=b.length-start; i++) {
			ret = Math.min(ret, minError(start,start+i) + Quantization(start+i,parts-1,cache));
		}
		
		return cache[start][parts-1] = ret;	
	}
	private static int minError(int start, int end) {
		int ret = INF;
		int total = 0;
		int max = 0;
		int min = INF;
		
		for(int i=start; i<end; i++) {
			if(min > b[i]) {
				min = b[i];
			}
			if(max < b[i]) {
				max = b[i];
			}
		}
		
		for(int j=min; j<=max; j++) {
			for(int i=start; i<end; i++) {
				total += (int)Math.pow((j - b[i]),2);
			}
			if(total < ret) {
				ret = total;
			}
			total = 0;
		}
		return ret;
	}

}
