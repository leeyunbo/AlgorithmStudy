package stack;

import java.util.Stack;

/**
 * ���� ������ ž N�븦 �������ϴ�. ��� ž�� ����⿡�� ��ȣ�� ��/�����ϴ� ��ġ�� ��ġ�߽��ϴ�.
 *  �߻��� ��ȣ�� ��ȣ�� ���� ž���� ���� ž������ �����մϴ�. ����, �� �� ���ŵ� ��ȣ�� �ٸ� ž���� �۽ŵ��� �ʽ��ϴ�.
 *  ���� ��� ���̰� 6, 9, 5, 7, 4�� �ټ� ž�� �������� ���ÿ� ������ ��ȣ�� �߻��մϴ�. 
 *  �׷���, ž�� ������ ���� ��ȣ�� �ְ�޽��ϴ�. ���̰� 4�� �ټ� ��° ž���� �߻��� ��ȣ�� ���̰� 7�� �� ��° ž�� �����ϰ�,
 *   ���̰� 7�� �� ��° ž�� ��ȣ�� ���̰� 9�� �� ��° ž��, ���̰� 5�� �� ��° ž�� ��ȣ�� ���̰� 9�� �� ��° ž�� �����մϴ�. 
 *   ���̰� 9�� �� ��° ž�� ���̰� 6�� ù ��° ž�� ���� ������ ��ȣ�� � ž������ ������ �� �����ϴ�.
 * 
 * �� ���ʺ��� ������� ž�� ���̸� ���� �迭 heights�� �Ű������� �־��� �� �� ž�� �� ��ȣ�� ��� ž���� �޾Ҵ��� 
 * ����� �迭�� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * @author ������
 *
 */
public class StackTopSync {
	public static void main(String[] args) {
		int[] heights = {1,5,3,6,7,6,5};
		int[] answer = new int[heights.length];
		Stack<Integer> leftTopList = new Stack<>();
		for(int i=0; i<heights.length; i++) {
			if(i==0) answer[i] = 0; 
			for(int j=0; j<i; j++) {
				leftTopList.push(heights[j]);
			}
			for(int k=i; k>0; k--) {
				if(leftTopList.pop() > heights[i]) {
					answer[i] = k;
					break;
				}
			}
			leftTopList.clear();
		}
		
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
		
		

	}
}
