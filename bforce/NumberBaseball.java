package bforce;

import java.util.Arrays;

/**
 * ���� �߱� �����̶� 2���� ���ΰ� ������ ���ڸ� ���ߴ� �����Դϴ�.
 * ���� ���� �ٸ� 1~9���� 3�ڸ� ������ ���ڸ� ���� �� ���ο��� 3�ڸ��� ���ڸ� �ҷ��� ����� Ȯ���մϴ�.
 * �׸��� �� ����� ���� ��밡 ���� ���ڸ� ������ �� �����ϴ�.

* ���ڴ� ������, ��ġ�� Ʋ���� ���� ��
* ���ڿ� ��ġ�� ��� ���� ���� ��Ʈ����ũ     ��Ʈ����ũ => ��ġ, ���� �� ����.  �� => ���ڸ� ���� �ƿ� => �� Ʋ�� 
* ���ڿ� ��ġ�� ��� Ʋ���� ���� �ƿ�
* ���� ���, �Ʒ��� ��찡 ������
* 
* A : 123
* B : 1��Ʈ����ũ 1��. //2���� ���ڰ� ���ƾ��� 
* A : 356
* B : 1��Ʈ����ũ 0��. //1���� ���ڰ� ���ƾ��ϸ�, ��ġ�� ���ƾ��� 
* A : 327
* B : 2��Ʈ����ũ 0��. //2���� ���ڰ� ���ƾ��ϸ�, ��� ��ġ�� ���ƾ���
* A : 489
* B : 0��Ʈ����ũ 1��. //1���� ���ڰ� ���ƾ��ϸ�, ��ġ�� �޶����
* 
* �̶� ������ ���� 324�� 328 �� �����Դϴ�. return 2
* ������ �� �ڸ��� ��, ��Ʈ����ũ�� ��, ���� ���� ���� 2���� �迭 baseball�� �Ű������� �־��� ��, 
* ������ ���� ������ return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * @author serve
 *
 */
public class NumberBaseball {
	static int[][] baseballs = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
	static int[] selectedNum = new int[3];
	public static void main(String[] args) {
		int answer = 0;
		for(int myNum = 123; myNum<=987; myNum++) {
			selectedNum = changeArray(myNum);
			if(selectedNum == null) continue;
			answer += numCorrect();
		}
		
		System.out.println(answer);
	}
	
	private static int numCorrect() {
		int correctCnt = 0;
		int ret = 0;
		for(int idx=0; idx<baseballs.length; idx++) {
			int callNum = baseballs[idx][0];
			int strikeCnt = baseballs[idx][1];
			int ballCnt = baseballs[idx][2];
			int myStrikeCnt = 0;
			int myBallCnt = 0;
			int[] canSelectedNum = new int[3];
			canSelectedNum = changeArray(callNum);
			
			if(canSelectedNum == null) return 0;
			
			for(int i=0; i<selectedNum.length; i++) {
				if(selectedNum[i] == canSelectedNum[i]) {
					myStrikeCnt++;
				}
			}
			if(myStrikeCnt != strikeCnt) 
				return 0;
			
			for(int i=0; i<selectedNum.length; i++) {
				int temp = selectedNum[i];
				for(int j=0; j<canSelectedNum.length; j++) {
					if(temp == canSelectedNum[j]) {
						myBallCnt++;
						break;
					}
				}
			}
			
			if((myBallCnt - myStrikeCnt) != ballCnt) {
				return 0;
			}
		}
		return 1;
	}
	
	private static int[] changeArray(int callNum) {
		int[] canSelectedNum = new int[3];
		boolean[] isSelected = new boolean[9];
		int selectedCnt = 0;
		Arrays.fill(isSelected, false);
		for(int i=0,j=100; i<3; i++,j/=10) {
			canSelectedNum[i] = callNum/j; 
			callNum = callNum - (canSelectedNum[i] * j);
			if(canSelectedNum[i] == 0) return null;
			isSelected[canSelectedNum[i]-1] = true;
		}
		
		for(int i=0; i<isSelected.length; i++) {
			if(isSelected[i] == true) 
				selectedCnt++;
		}
		
		if(selectedCnt != 3) return null;
		
		return canSelectedNum;
	}

}
