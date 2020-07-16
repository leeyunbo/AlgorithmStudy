package algorithmbook;

/*
 * ���ӵ� �κ� ���� �� �� ���� �ִ��� ������ ã�� ���� 
 * Divide & Conquer ��� O(NlgN) 
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
		
		// ���ʿ� ��ģ sum �� ���Ѵ�.
		// ������ ��� 
		// �������� ��� 
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

		// ����, �����ʿ��� ���� ����� sum�� ���Ѵ�. 
		int single = Math.max(betterMaxSum(left, mid), betterMaxSum(mid+1, right));
		
		// ����, ������, ���ʿ� ��ģ sum�� ���Ͽ� �ִ��� ã�´�.
		
		return Math.max(single, crossLeftSum + crossRightSum); 
	}
}
