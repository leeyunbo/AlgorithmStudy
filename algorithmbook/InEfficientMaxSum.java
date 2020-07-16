package algorithmbook;

/*
 * 연속된 부분 구간 중 그 합이 최대인 구간을 찾는 문제 
 * brute force 사용 O(N^3)
 */

public class InEfficientMaxSum {
	
	static int maxSum = 0;
	static int A[] = {-7,4,-3,6,3,-8,3,4};
	
	public static void main(String[] args) {
		for(int i=0; i<A.length; i++) {
			for(int j=0; j<A.length; j++) {
				int sum = 0;
				for(int k=i; k<=j; k++) {
					sum += A[k]; 
				}
				maxSum = Math.max(sum, maxSum);
			}
		}
		
		System.out.println(maxSum);
	}
}
