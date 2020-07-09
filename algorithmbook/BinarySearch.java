package algorithmbook;

/*
 * lo < hi�� ������ �����ؾ��� 
 * A[lo] <= x <= A[hi] �� �����ؾ���
 */

public class BinarySearch {
	static int A[] = {1,2,3,4,5}; 
	public static void main(String[] args) {
		
		System.out.println(binsearch(1));
	}
	
	private static int binsearch(int data) {
		int h = A.length-1;
		int l = 0;
		int m = 0;
		
		while(l < h) {
			m = (h + l) / 2;
			if(A[m] == data) break;
			if(A[m] < data) {
				l = m + 1;
			}
			else {
				h = m; 
			}
		}
		return m;
	}
	
}
