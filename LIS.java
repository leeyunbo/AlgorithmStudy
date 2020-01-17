import java.util.Arrays;
/*
 * ���� ���� S�� �κ� �����̶� S���� 0�� �̻��� ���ڸ� ����� ���� ������ ���Ѵ�.
 * ���� ��� '1,2,4'�� '1,5,2,4,7'�� �κ� �����̴�. �κ� ������ ���Ե� ���ڵ��� �� �����ϸ� 
 * �� �κ� ������ ���� �κ� �����̶�� �θ���. �־��� �������� ���� �� ���� �κ� ������ ���ϴ� �˰����� �ۼ��϶�.
 * �� ������ ������ ������ ���� ��ȹ�� ���� ������ �ϳ��̴�.
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
