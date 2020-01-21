/*
 * 원주율 외우기 
 * 보통 원주율을 외우는 신동들을 보면 세자리 혹은 네자리 씩 끊어가며 외우는데, 가능하면 규칙성이 보이는 조각들이
 * 많이 등장하는 방법을 택하곤 합니다. 이때 각 조각들의 난이도는 다음과 같습니다.
 * 모든 숫자가 같을 때 : 난이도 1
 * 숫자가 1씩 단조 증가 or 단조 감소할 경우 : 난이도 2
 * 두 개의 숫자가 번갈아가며 나타날 때 : 난이도 4
 * 숫자가 등차 수열을 이룰 때 : 난이도 5
 * 그 외 : 난이도 10
 * 원주율의 일부가 입력으로 주어질 때, 난이도의 합을 최소화하도록 숫자들을 세 자리에서 다섯 자리까지 끊어 읽고 싶습니다. 
 * 최소의 난이도를 계산하는 프로그램을 작성하세요.
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
	
	private boolean one() { //숫자가 같을 경우
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
	
	private boolean two() { //숫자가 단조 증가, 단조 감소하는 경우
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
	
	private boolean four() { // 두 개의 숫자가 번갈아 나타날 경우
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
	private boolean five() { // 숫자가 등차 수열일 경우
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
