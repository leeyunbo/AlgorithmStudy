package memoization;
/*
 * 
 * �����̿��� 2�� ������ ������ �ֱ� ����, ������ �ƹ����� �׿��� Ÿ�ϵ��� �������̴ּ�. �׸��� �� ������ Ÿ�ϵ��� 0 �Ǵ� 1�� ���� �ִ� ������ Ÿ�ϵ��̴�.
��� �� ������ ���ְ� �������� ���θ� �����ϱ� ���� 0�� ������ ������ Ÿ�ϵ��� �ٿ��� �� ������ �̷���� 00 Ÿ�ϵ��� �������. 
�ᱹ ���� 1 �ϳ������� �̷���� Ÿ�� �Ǵ� 0Ÿ���� �� �� ���� �� ���� 00Ÿ�ϵ鸸�� ���� �Ǿ���.
�׷��Ƿ� �����̴� Ÿ�Ϸ� �� �̻� ũ�Ⱑ N�� ��� 2�� ������ ���� �� ���� �Ǿ���. ���� ���, N=1�� �� 1�� ���� �� �ְ�, N=2�� ���� 00, 11�� ���� �� �ִ�. (01, 10�� ���� �� ���� �Ǿ���.)
���� N=4�� ���� 0011, 0000, 1001, 1100, 1111 �� �� 5���� 2�� ������ ���� �� �ִ�.
�츮�� ��ǥ�� N�� �־����� �� �����̰� ���� �� �ִ� ��� �������� ���� ���̴�. �� Ÿ�ϵ��� ������ ���� ������ ��������.
 */
import java.util.Arrays;
import java.util.Scanner;

public class Tile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int cache[] = new int[n+1];
		Arrays.fill(cache, -1);
		System.out.println(tile(n,cache));
	}
	
	private static int tile(int n,int[] cache) {
		if(n==2) {
			return 2;
		}
		if(n==1) {
			return 1;
		}
		if(n==0) {
			return 0;
		}
		
		if(cache[n] != -1) {
			return cache[n];
		}
		
		return cache[n] = (tile(n-2,cache) + tile(n-1,cache)) % 15746;
	}

}
