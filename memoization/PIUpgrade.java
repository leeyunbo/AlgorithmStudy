/*
 * ������ �ܿ�� 
 * ���� �������� �ܿ�� �ŵ����� ���� ���ڸ� Ȥ�� ���ڸ� �� ����� �ܿ�µ�, �����ϸ� ��Ģ���� ���̴� ��������
 * ���� �����ϴ� ����� ���ϰ� �մϴ�. �̶� �� �������� ���̵��� ������ �����ϴ�.
 * ��� ���ڰ� ���� �� : ���̵� 1
 * ���ڰ� 1�� ���� ���� or ���� ������ ��� : ���̵� 2
 * �� ���� ���ڰ� �����ư��� ��Ÿ�� �� : ���̵� 4
 * ���ڰ� ���� ������ �̷� �� : ���̵� 5
 * �� �� : ���̵� 10
 * �������� �Ϻΰ� �Է����� �־��� ��, ���̵��� ���� �ּ�ȭ�ϵ��� ���ڵ��� �� �ڸ����� �ټ� �ڸ����� ���� �а� �ͽ��ϴ�. 
 * �ּ��� ���̵��� ����ϴ� ���α׷��� �ۼ��ϼ���.
 */
package memoization;

import java.util.Arrays;

public class PIUpgrade {
	static int [] list = {1,2,6,7,3,9,3,9};
	static final int INF = 123456;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] cache = new int[10000];
		Arrays.fill(cache, -1);
		System.out.println(PI(0,cache));
	}
	
	
		private static int PI(int startIndex, int[] cache) {
			if(startIndex >= list.length) {
				return 0; 
			}
			
			if(cache[startIndex] != -1) {
				return cache[startIndex];
			}
			
			int ret = INF;
			for(int i=3; i<=5; i++) {
				DifficultCheck_Upgrade check = new DifficultCheck_Upgrade(list,startIndex,i);
				ret = Math.min(ret, check.difficult() + PI(startIndex+i,cache));
			}
			
			return cache[startIndex] = ret;
	}
}

//���̵� ���ϴ� Ŭ����
class DifficultCheck_Upgrade {
	private int[] list;
	private int startIndex;
	private int jumpIndex;
	DifficultCheck_Upgrade(int[] list, int startIndex, int jumpIndex) {
		this.list = list;
		this.startIndex = startIndex;
		this.jumpIndex = jumpIndex;
	}
	
	int difficult() {
		if(startIndex + jumpIndex > list.length) {
			return 10;
		}
		int ret = 0;
		if(one()) {
			ret = 1;
		}else if(two()) {
			ret = 2;
		}else if(four()) {
			ret = 4;
		}else if(five()) {
			ret = 5;
		}else{
			ret = 10;
		}
		
		return ret;
	}
	
	private boolean one() { //���ڰ� ���� ���
		int before = list[startIndex];
		for(int i=1; i<jumpIndex; i++) {
			int temp = list[startIndex+i];
			if(temp != before) {
				return false;
			}
			before = temp;
		}
		return true;
	}
	
	private boolean two() { //���ڰ� ���� ����, ���� �����ϴ� ���
		int first = list[startIndex];
		int before = list[startIndex+1];
		int d = before - first; //-1 or 1
		if(Math.abs(d) != 1) {
			return false;
		}
		for(int i=2; i<jumpIndex; i++) {
			int temp = list[startIndex+i];
			if(temp != (before + d)) {
				return false;
			}
			before = temp;
		}
		return true;
	}
	
	private boolean four() { // �� ���� ���ڰ� ������ ��Ÿ�� ���
		int first = list[startIndex];
		int second = list[startIndex+1];
		for(int i=2; i<jumpIndex; i++) {
			int temp = list[startIndex+i];
			if(i%2==0) {
				if(first != temp) {
					return false;
				}
			}
			else {
				if(second != temp) {
					return false;
				}
			}
		}
		
		return true;
		
	}
	private boolean five() { // ���ڰ� ���� ������ ���
		int first = list[startIndex];
		int before = list[startIndex+1];
		int d = before - first; //-1 or 1
		for(int i=2; i<jumpIndex; i++) {
			int temp = list[startIndex+i];
			if(temp != (before+d)) {
				return false;
			}
			before = temp;
		}
		return true;	
	}
}
