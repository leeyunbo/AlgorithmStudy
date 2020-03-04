package sort;
/**
 * �迭 array�� i��° ���ں��� j��° ���ڱ��� �ڸ��� �������� ��, k��°�� �ִ� ���� ���Ϸ� �մϴ�.
 * ���� ��� array�� [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3�̶��
 * 1. array�� 2��°���� 5��°���� �ڸ��� [5, 2, 6, 3]�Դϴ�.
 * 2. 1���� ���� �迭�� �����ϸ� [2, 3, 5, 6]�Դϴ�.
 * 3. 2���� ���� �迭�� 3��° ���ڴ� 5�Դϴ�.
 * �迭 array, [i, j, k]�� ���ҷ� ���� 2���� �迭 commands�� �Ű������� �־��� ��, commands�� ��� ���ҿ� ���� �ռ� ������ ������ �������� �� ���� ����� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
array�� ���̴� 1 �̻� 100 �����Դϴ�.
array�� �� ���Ҵ� 1 �̻� 100 �����Դϴ�.
commands�� ���̴� 1 �̻� 50 �����Դϴ�.
commands�� �� ���Ҵ� ���̰� 3�Դϴ�.
 */
import java.util.Arrays;

public class KNum {
	static int[] array = {1,5,2,6,3,7,4}; 
	static int[][] commands = {{2,5,3},{4,4,1},{1,7,3}}; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answer = new int[commands.length]; 
		for(int i=0; i<commands.length; i++) {
			int[] nowCommand = commands[i];
			int[] bufferArray = Arrays.copyOfRange(array, nowCommand[0]-1, nowCommand[1]);
			Arrays.sort(bufferArray);
			answer[i] = bufferArray[nowCommand[2]-1];
		}
		
		for(int i=0; i<answer.length; i++) 
			System.out.println(answer[i]);

	}

}
