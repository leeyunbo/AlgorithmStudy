package bforce;

import java.util.Arrays;

/**
 * 숫자 야구 게임이란 2명이 서로가 생각한 숫자를 맞추는 게임입니다.
 * 각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 3자리의 숫자를 불러서 결과를 확인합니다.
 * 그리고 그 결과를 토대로 상대가 정한 숫자를 예상한 뒤 맞힙니다.

* 숫자는 맞지만, 위치가 틀렸을 때는 볼
* 숫자와 위치가 모두 맞을 때는 스트라이크     스트라이크 => 위치, 숫자 다 맞음.  볼 => 숫자만 맞음 아웃 => 다 틀림 
* 숫자와 위치가 모두 틀렸을 때는 아웃
* 예를 들어, 아래의 경우가 있으면
* 
* A : 123
* B : 1스트라이크 1볼. //2개의 숫자가 같아야함 
* A : 356
* B : 1스트라이크 0볼. //1개의 숫자가 같아야하며, 위치도 같아야함 
* A : 327
* B : 2스트라이크 0볼. //2개의 숫자가 같아야하며, 모두 위치도 같아야함
* A : 489
* B : 0스트라이크 1볼. //1개의 숫자가 같아야하며, 위치가 달라야함
* 
* 이때 가능한 답은 324와 328 두 가지입니다. return 2
* 질문한 세 자리의 수, 스트라이크의 수, 볼의 수를 담은 2차원 배열 baseball이 매개변수로 주어질 때, 
* 가능한 답의 개수를 return 하도록 solution 함수를 작성해주세요.
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
