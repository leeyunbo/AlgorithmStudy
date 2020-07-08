package algorithmbook;

public class BinarySearch {
	static int A[] = {1,2,3,4,5,6,7,8,9,10}; 
	public static void main(String[] args) {
		

	}
	
	private static int binsearch(int data) {
		int h = A.length-1;
		int l = 0;
		int m = 0;
		while(true) {
			m = h + l / 2;
			if(A[m] == data) break;
			if(A[m] < data) {
				
			}
			else {
				
			}
		}
		
		
		return m;
	}

}
