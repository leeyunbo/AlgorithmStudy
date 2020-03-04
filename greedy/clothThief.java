package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ���ɽð��� ������ ���, �Ϻ� �л��� ü������ �������߽��ϴ�. ������ ���� ü������ �ִ� �л��� �̵鿡�� ü������ �����ַ� �մϴ�. 
 * �л����� ��ȣ�� ü�� ������ �Ű��� �־�, �ٷ� �չ�ȣ�� �л��̳� �ٷ� �޹�ȣ�� �л����Ը� ü������ ������ �� �ֽ��ϴ�. 
 * ���� ���, 4�� �л��� 3�� �л��̳� 5�� �л����Ը� ü������ ������ �� �ֽ��ϴ�.
 *  ü������ ������ ������ ���� �� ���� ������ ü������ ������ ���� �ִ��� ���� �л��� ü�������� ���� �մϴ�.
 *  ��ü �л��� �� n, ü������ �������� �л����� ��ȣ�� ��� �迭 lost, ������ ü������ ������ �л����� ��ȣ�� ��� �迭 reserve�� �Ű������� �־��� ��, 
 *  ü�������� ���� �� �ִ� �л��� �ִ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 *  
 *  ���ѻ���
 *  ��ü �л��� ���� 2�� �̻� 30�� �����Դϴ�.
 *  ü������ �������� �л��� ���� 1�� �̻� n�� �����̰� �ߺ��Ǵ� ��ȣ�� �����ϴ�.
 *  ������ ü������ ������ �л��� ���� 1�� �̻� n�� �����̰� �ߺ��Ǵ� ��ȣ�� �����ϴ�.
 *  ���� ü������ �ִ� �л��� �ٸ� �л����� ü������ ������ �� �ֽ��ϴ�.
 *  ���� ü������ ������ �л��� ü������ ���������� �� �ֽ��ϴ�. �̶� �� �л��� ü������ �ϳ��� �������ߴٰ� �����ϸ�, 
 *  ���� ü������ �ϳ��̱⿡ �ٸ� �л����Դ� ü������ ������ �� �����ϴ�.
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
