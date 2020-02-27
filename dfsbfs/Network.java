package dfsbfs;

import java.util.Arrays;
/**
 * ��Ʈ��ũ�� ��ǻ�� ��ȣ ���� ������ ��ȯ�� �� �ֵ��� ����� ���¸� �ǹ��մϴ�. 
 * ���� ���, ��ǻ�� A�� ��ǻ�� B�� ���������� ����Ǿ��ְ�, ��ǻ�� B�� ��ǻ�� C�� ���������� ����Ǿ� ���� �� ��ǻ�� A�� ��ǻ�� C�� ���������� ����Ǿ� ������ ��ȯ�� �� �ֽ��ϴ�. 
 * ���� ��ǻ�� A, B, C�� ��� ���� ��Ʈ��ũ �� �ִٰ� �� �� �ֽ��ϴ�.
 * ��ǻ���� ���� n, ���ῡ ���� ������ ��� 2���� �迭 computers�� �Ű������� �־��� ��, 
 * ��Ʈ��ũ�� ������ return �ϵ��� solution �Լ��� �ۼ��Ͻÿ�.
 * 
 * ��ǻ���� ���� n�� 1 �̻� 200 ������ �ڿ����Դϴ�.
 * �� ��ǻ�ʹ� 0���� n-1�� ������ ǥ���մϴ�.
 * i�� ��ǻ�Ϳ� j�� ��ǻ�Ͱ� ����Ǿ� ������ computers[i][j]�� 1�� ǥ���մϴ�.
 * computer[i][i]�� �׻� 1�Դϴ�.
 * 
 * @author ����
 *
 */
public class Network {
	static int[][] computer= 
		{{1,1,0},
		  {1,1,1},
		  {0,1,1}};
	static int n = 3;
	static boolean[] isCheck = new boolean[n];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arrays.fill(isCheck, false);
		int answer = 0;
		
		for(int i=0; i<computer.length; i++) {
			if(isCheck[i] == true)  {
				continue;
			}
			DfsNetworkCount(i);
			answer++;
			
		}
		System.out.println(answer);

	}
	
	
	private static void DfsNetworkCount(int start) {
		isCheck[start] = true;
		for(int i=0; i<computer.length; i++) {
			if(computer[start][i] == 1 && isCheck[i] == false) {
				DfsNetworkCount(i);
			}
		}
	}

}
