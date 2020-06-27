package twopointer;

public class TwoPointer {

	public static void main(String[] args) {
		int[] A = {1,1,1,1,1,1,1}; 
		int S = 3; 
		int left = 0, right = 0, sum = A[left], answer = 100001; 
		
		
		while(true) {
			if(sum < S && right < A.length - 1) {
				right++; 
				sum = sum + A[right]; 
			}
			else if(sum >= S && left <= right) {
				answer = Math.min(answer, right - left + 1);
				left++; 
				sum = sum - A[left-1]; 
			}
			else break; 
		}
		
		System.out.println(answer); 

	}

}
