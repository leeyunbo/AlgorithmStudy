package programmers;
/*
 * 바로 앞번호의 학생이나, 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있음 
 * ex) 4번학생은 3번학생, 5번학생에게만. 
 * 최대한 많은 학생들에게 빌려줘야해. 
 * 전체 학생 수 : n, 도난당한 학생들의 번호 : lost, 여벌의 체육복을 가져온 학생 : reserve 
 * 체육수업을 들을 수 있는 학생들의 최대 수? 
 */

import java.util.Arrays;

public class ClothGreedy {
	
	
	public static void main(String[] args) {
		int n = 5; //총 학생 수
		int[] lost = {2,4}; // 도난당한 학생 , {1,3,5}
		int[] reserve = {3}; // 여벌 체육복이 있는 학생 , 앞뒤로만 빌려줄 수 있고, 빌려줬다. 그러면 끝.
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
		// 처음 : {1,3,5}, {3}, {2,4}
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
		  if(reserve[i] == 1) { //만약 첫번째 학생이면, 오른쪽 무조건 true
			  if(!isOkCopy[reserve[i] +1]) {
				  isOkCopy[reserve[i] +1] = true;
			  }
		  } else if(reserve[i]  == n) { //만약 마지막 학생이면, 왼쪽 무조건 true
			  if(!isOkCopy[reserve[i] -1])
				  isOkCopy[reserve[i] -1] = true;
		  }
		  else { // 그 외 중간 학생이면 
			if(!isOkCopy[reserve[i]-1] && !isOkCopy[reserve[i] + 1]) { // 만약 앞 뒤가 둘다 false이면, 탐욕법을 이용해 가장 많이 빌려줄 수 있는 학생을 선택해 진행한다.
				boolean[] Left = borrowCloth(isOkCopy, true, i+1, i, false); 
				boolean[] Right = borrowCloth(isOkCopy,false,i+1,i,false);
				if (countTrue(Left) >= countTrue(Right)) { // 왼쪽, 오른쪽 학생인 경우 중에 더 큰 곳으로 진행
					isOkCopy = Left; //왼쪽이 더 크면, 왼쪽 선택
				} else {
					isOkCopy = Right; //오른쪽이 더 크면, 오른쪽 선택 
				}
			} else if(!isOkCopy[reserve[i]-1] && isOkCopy[reserve[i] +1]) { //만약 왼쪽 학생만 false면, 왼쪽 학생 true
				isOkCopy[reserve[i] -1] = true;
			} else if(isOkCopy[reserve[i]-1] && !isOkCopy[reserve[i]+1]){ //만약 오른쪽 학생만 false면, 오른쪽 학생 true
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
                                                                                                                               