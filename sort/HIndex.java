package sort;
/**
 * H-Index�� �������� ���꼺�� ������� ��Ÿ���� ��ǥ�Դϴ�. ��� �������� H-Index�� ��Ÿ���� ���� h�� ���Ϸ��� �մϴ�. 
 * ��Ű���1�� ������, H-Index�� ������ ���� ���մϴ�.
 * � �����ڰ� ��ǥ�� �� n�� ��, h�� �̻� �ο�� ���� h�� �̻��̰� ������ ���� h�� ���� �ο�Ǿ��ٸ� h�� �� �������� H-Index�Դϴ�.
 * � �����ڰ� ��ǥ�� ���� �ο� Ƚ���� ���� �迭 citations�� �Ű������� �־��� ��, 
 * �� �������� H-Index�� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * ���ѻ���
 * �����ڰ� ��ǥ�� ���� ���� 1�� �̻� 1,000�� �����Դϴ�.
 * ���� �ο� Ƚ���� 0ȸ �̻� 10,000ȸ �����Դϴ�.
 * ���� : https://en.wikipedia.org/wiki/H-index ��Ű��� 
 */
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class HIndex {
	static int[] citations = {3,0,6,1,5}; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = 0;
		LinkedList<Integer> queue = new LinkedList<>();	
		LinkedList<Integer> h = new LinkedList<>();
		for(int i=0; i<citations.length; i++) 
			queue.add(citations[i]);
		
		Collections.sort(queue);
		
		for(int i=0; i<citations.length; i++) {
			int a = queue.poll();
			int b = queue.size()+1;
			h.add(Math.min(a, b));
		}
		
		Collections.sort(h,Collections.reverseOrder());
		answer = h.poll();
	}

}
