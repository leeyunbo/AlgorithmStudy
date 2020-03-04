package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 
 * 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 
 * 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
 *  체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
 *  전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 
 *  체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
 *  
 *  제한사항
 *  전체 학생의 수는 2명 이상 30명 이하입니다.
 *  체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 *  여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 *  여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
 *  여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 
 *  남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
 * @author serve
 *
 */
public class clothThief {
	static int lost[] = {1,3};
	static int reverse[] = {2,4};
	static int n = 30;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = 0;
		int lostCnt = 0;
		 boolean isLost[] = new boolean[n];
		 boolean isReverse[] = new boolean[n];
		 Arrays.fill(isLost, false);
		 Arrays.fill(isReverse, false);
		 
		 for(int i=0; i<lost.length; i++) {
			 isLost[lost[i]-1]= true;
			 lostCnt++;
		 }
		 
		 for(int i=0; i<reverse.length; i++) {
			 if(isLost[reverse[i]-1] != true) {
				 isReverse[reverse[i]-1] = true;
			 }
			 else if(isLost[reverse[i]-1] == true) {
				 isLost[reverse[i]-1] = false;
				 lostCnt--;
			 }
		 }
		 
		 for(int i=0; i<n; i++) {
			 if(isReverse[i] == false) continue;
			 if(i==0 && isLost[i+1] == true) {
				isLost[i+1] = false;
				isReverse[i] = false;
				lostCnt--; 
				continue;
			 }
			 if(i==n-1 && isLost[i-1] == true) {
				isLost[i-1] = false;
				isReverse[i] = false;
				lostCnt--;
				break;
			 }
			 if((isLost[i-1] == true && isLost[i+1] == true) || isLost[i-1] == true) {
				 isLost[i-1] = false;
				 isReverse[i] = false;
				 lostCnt--;
			 }
			 else if(isLost[i+1] == true){
				isLost[i+1] = false;
				isReverse[i] = false;
				lostCnt--;
			 }
		 }
		 
		 answer = n - lostCnt;
		 System.out.println(answer);
	}

}
