
public class ParkTrash {
	static int answer = 0;
	static int[][] park = {{2,0,0},{2,0,0},{2,2,2}};
	static int parkN = 3;
	static int parkM = 3;
	
	public static void main(String[] args) {
		func(0, 0, 0);
		System.out.println(answer);
	}
	
	private static void func(int trashCnt, int leftIdx, int rightIdx) {
		// base-case 
		// Park�� ��� ��� 
		if(leftIdx < 0 || rightIdx < 0 || leftIdx >= parkN || rightIdx >= parkM) return;
		
		// ������ ���� �߰� 
		trashCnt += park[leftIdx][rightIdx];
		
		
		// ������ ��ġ���� ������ ���
		if(leftIdx == parkN-1 && rightIdx == parkM-1) {
			answer = Math.max(answer, trashCnt);
			return;
		}
			
		// recursion-case 
		func(trashCnt, leftIdx+1, rightIdx);
		func(trashCnt, leftIdx, rightIdx+1);
	}
}
