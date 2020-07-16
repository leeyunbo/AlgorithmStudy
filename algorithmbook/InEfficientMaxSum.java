package algorithmbook;

/*
 * ���ӵ� �κ� ���� �� �� ���� �ִ��� ������ ã�� ���� 
 * brute force ��� O(N^3)
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
