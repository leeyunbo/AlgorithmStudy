package programmers;
/*
 * �ٷ� �չ�ȣ�� �л��̳�, �ٷ� �޹�ȣ�� �л����Ը� ü������ ������ �� ���� 
 * ex) 4���л��� 3���л�, 5���л����Ը�. 
 * �ִ��� ���� �л��鿡�� ���������. 
 * ��ü �л� �� : n, �������� �л����� ��ȣ : lost, ������ ü������ ������ �л� : reserve 
 * ü�������� ���� �� �ִ� �л����� �ִ� ��? 
 */

import java.util.Arrays;

public class ClothGreedy {
	
	
	public static void main(String[] args) {
		int n = 5; //�� �л� ��
		int[] lost = {2,4}; // �������� �л� , {1,3,5}
		int[] reserve = {3}; // ���� ü������ �ִ� �л� , �յڷθ� ������ �� �ְ�, �������. �׷��� ��.
		ClothDynamic clothDynamic = new ClothDynamic(n,lost,reserve);
		clothDynamic.init();
		System.out.println(clothDynamic.countTrue(clothDynamic.borrowCloth(clothDynamic.isOk,false,0,0,true)));
		
		
	}
}

class ClothDynamic {
	int n; 
	int[] lost;
	int[] reserve;
	boolean[] isBorrow;
	boolean[] isOk;
	int answer = 0;
	
	ClothDynamic(int n, int[] lost, int[] reserve) {
		this.n = n;
		this.lost = lost;
		this.reserve = reserve;
		this.isBorrow = new boolean[n];     
		this.isOk = new boolean[n+2];
	}
	
	public void init() {
		Arrays.fill(isOk, true);
		isOk[0] = false;
		isOk[isOk.length-1] = false;
		for(int i = 0; i < lost.length; i++) {
			isOk[lost[i]] = false;
		}

	}
	
	public boolean[] borrowCloth( boolean[] isOk, boolean isLeft, int next,int now,boolean isFirst) {
		boolean[] isOkCopy = new boolean[n+2];
		for(int i = 0; i < isOk.length; i ++) {
			isOkCopy[i] = isOk[i];
		}
		// ó�� : {1,3,5}, {3}, {2,4}
		if(isFirst == false) {
			if(isLeft == true) {
				isOkCopy[reserve[now] - 1] = true; // 1235
			} else {
				isOkCopy[reserve[now] + 1] = true; // 1345
			}
		}
		
		if(next == reserve.length) {
			return isOkCopy;
		}
		
		for(int i = next; i < reserve.length; i++) { // i = 1
		  if(reserve[i] == 1) { //���� ù��° �л��̸�, ������ ������ true
			  if(!isOkCopy[reserve[i] +1]) {
				  isOkCopy[reserve[i] +1] = true;
			  }
		  } else if(reserve[i]  == n) { //���� ������ �л��̸�, ���� ������ true
			  if(!isOkCopy[reserve[i] -1])
				  isOkCopy[reserve[i] -1] = true;
		  }
		  else { // �� �� �߰� �л��̸� 
			if(!isOkCopy[reserve[i]-1] && !isOkCopy[reserve[i] + 1]) { // ���� �� �ڰ� �Ѵ� false�̸�, Ž����� �̿��� ���� ���� ������ �� �ִ� �л��� ������ �����Ѵ�.
				boolean[] Left = borrowCloth(isOkCopy, true, i+1, i, false); 
				boolean[] Right = borrowCloth(isOkCopy,false,i+1,i,false);
				if (countTrue(Left) >= countTrue(Right)) { // ����, ������ �л��� ��� �߿� �� ū ������ ����
					isOkCopy = Left; //������ �� ũ��, ���� ����
				} else {
					isOkCopy = Right; //�������� �� ũ��, ������ ���� 
				}
			} else if(!isOkCopy[reserve[i]-1] && isOkCopy[reserve[i] +1]) { //���� ���� �л��� false��, ���� �л� true
				isOkCopy[reserve[i] -1] = true;
			} else if(isOkCopy[reserve[i]-1] && !isOkCopy[reserve[i]+1]){ //���� ������ �л��� false��, ������ �л� true
				isOkCopy[reserve[i] +1] = true;
			}
		  }
		    	
		    
		}
		return isOkCopy;
	}
	
	
	public int countTrue(boolean[] isOk) {
		int count = 0;
		for(int i = 0; i < isOk.length; i++) {
			if(isOk[i] == true) {
				count = count + 1;
			}
		}
		return count;
	}
}
                                                                                                                               