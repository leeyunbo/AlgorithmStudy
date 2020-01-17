import java.util.Arrays;
/*
 * 정수 수열 S의 부분 수열이란 S에서 0개 이상의 숫자를 지우고 남은 수열을 말한다.
 * 예를 들어 '1,2,4'는 '1,5,2,4,7'의 부분 수열이다. 부분 수열에 포함된 숫자들이 순 증가하면 
 * 이 부분 수열을 증가 부분 수열이라고 부른다. 주어진 수열에서 가장 긴 증가 부분 수열을 구하는 알고리즘을 작성하라.
 * 이 문제는 굉장히 유명한 동적 계획법 연습 문제중 하나이다.
 */
public class LIS {
	static int[] A = {5,1,3,5,2,1,5,9,2,3,4,5,6};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cache[] = new int[100];
		int max_len = 0;
		Arrays.fill(cache, -1);
		
		for(int i=0; i<A.length; i++) {
			max_len = Math.max(max_len,LIS(i,cache));
		}
		System.out.println(max_len);
	}
	
	
	private static int LIS(int start,int cache[]) {
		int ret = 1;
		
		if(cache[start] != -1) {
			return cache[start];
		}
	
		for(int j=start+1; j<A.length; j++) {
			if(A[start] < A[j]) {
				ret = Math.max(ret,1 + LIS(j,cache));
			}
		}	
		return cache[start] = ret;
	
	}

}
