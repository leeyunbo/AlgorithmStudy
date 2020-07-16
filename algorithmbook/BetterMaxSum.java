package algorithmbook;

/*
 * 연속된 부분 구간 중 그 합이 최대인 구간을 찾는 문제 
 * Divide & Conquer 사용 O(NlgN) 
 */

public class BetterMaxSum {
	
	static int maxSum = 0;
	static int A[] = {-7,4,-3,6,3,-8,3,4};
	static final int UNINF = -654321;
	
	public static void main(String[] args) {

		maxSum = betterMaxSum(0, A.length-1);
		System.out.println(maxSum);
	}
	
	
	private static int betterMaxSum(int left, int right) {
		if(left == right) return A[left];
		
		int mid = (left + right)/2; 
		
		// 양쪽에 걸친 sum 을 구한다.
		// 왼쪽의 경우 
		// 오른쪽의 경우 
		int crossLeftSum = UNINF, crossRightSum = UNINF, sum = 0;
		for(int i = mid; i >= left; i--) {
			sum += A[i]; 
			crossLeftSum = Math.max(crossLeftSum, sum);
		}
		
		sum = 0;
		for(int i = mid+1; i <= right; i++) {
			sum += A[i]; 
			crossRightSum = Math.max(crossRightSum, sum);
		}

		// 왼쪽, 오른쪽에만 있을 경우의 sum을 구한다. 
		int single = Math.max(betterMaxSum(left, mid), betterMaxSum(mid+1, right));
		
		// 왼쪽, 오른쪽, 양쪽에 걸친 sum에 대하여 최댓값을 찾는다.
		
		return Math.max(single, crossLeftSum + crossRightSum); 
	}
}
