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

public class PI {
	static int [] list = {2,2,2,2,2,2,2,2};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] cache = new int[10000][10000];
		for(int i=0; i<cache.length; i++) {	
			Arrays.fill(cache[i], -1);
		}
		int three = PI(0,3,cache);
		int four = PI(0,4,cache);
		int five = PI(0,5,cache);
		
		System.out.println(Math.min(Math.min(three, four),five));
	}
	
	
	private static int PI(int startIndex, int jumpIndex, int[][] cache) {
		int ret = 0;
		if(startIndex+jumpIndex > list.length) {
			return 10;
		}
		if(cache[startIndex][jumpIndex]!=-1) {
			return cache[startIndex][jumpIndex];
		}
		DifficultCheck check = new DifficultCheck(list,startIndex,jumpIndex);
		ret = check.difficult();
		if(startIndex + jumpIndex == list.length) {
			return ret;
		}
		return cache[startIndex][jumpIndex] = ret + Math.min(Math.min(PI(startIndex+jumpIndex,3,cache),PI(startIndex+jumpIndex,4,cache)),PI(startIndex+jumpIndex,5,cache));
	}
}


class DifficultCheck {
	private int[] list;
	private int startIndex;
	private int jumpIndex;
	DifficultCheck(int[] list, int startIndex, int jumpIndex) {
		this.list = list;
		this.startIndex = startIndex;
		this.jumpIndex = jumpIndex;
	}
	
	int difficult() {
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
