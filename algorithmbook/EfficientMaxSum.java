package algorithmbook;

/*
 * 연속된 부분 구간 중 그 합이 최대인 구간을 찾는 문제 
 */

public class EfficientMaxSum {
	static int maxSum = 0;
	static int A[] = {-7,4,-3,6,3,-8,3,4};
	public static void main(String[] args) {
		maxSum = A[0];
		int efficientSumInArray = A[0];
		for(int i=1; i<A.length; i++) {
			if(efficientSumInArray <= 0) {
				efficientSumInArray = A[i];
			}
			else {
				efficientSumInArray += A[i]; 
			}
			
			maxSum = Math.max(efficientSumInArray, maxSum);
		}
		
		System.out.println(maxSum);

	}

}
