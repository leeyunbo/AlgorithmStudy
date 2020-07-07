package algorithmbook;

/*
 * M-이동평균 선형 시간 이내 알고리즘으로 문제 풀이 
 * O(i) 
 */

public class MMovingAverage {
	static int[] weight = {0, 50, 60, 70, 80, 70, 60, 50, 40, 50, 60, 50, 50};
	static int[] MAverage = new int[13];
	static int M = 3;
	public static void main(String[] args) {
		int sum = 0;
		for(int i=1; i<=12; i++) {
			if(i <= M) {
				sum += weight[i]; 
			}
			else {
				sum = sum + weight[i] - weight[i-M];
			}
			
			if(i >= M) {
				MAverage[i] = sum / M;
			}
		}
		
		for(int i=1; i<=12; i++) {
			System.out.println(MAverage[i]);
		}
		
	}

}
