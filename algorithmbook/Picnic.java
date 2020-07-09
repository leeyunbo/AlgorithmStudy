package algorithmbook;
/*
 * n명의 학생이 있다고 할 때, 2명씩 짝지어야함.( 짝지을 수 있는 사람은 배열에 저장되어있음 )
 * 이때 짝지을 수 있는 모든 경우의 수를 출력하시오.
 * 조건) 재귀 호출 사용할 것 
 */
public class Picnic {
	
	private static boolean[] isParing = new boolean[4]; 
	private static boolean[][] areFriends = new boolean[4][4]; 
	private static int answer = 0;
	
	public static void main(String[] args) {
		
		areFriends[0][1] = true;
		areFriends[1][0] = true; 
		areFriends[0][2] = true;
		areFriends[2][0] = true;
		areFriends[0][3] = true;
		areFriends[3][0] = true; 
		areFriends[1][2] = true; 
		areFriends[2][1] = true;
		areFriends[1][3] = true;
		areFriends[3][1] = true; 
		areFriends[2][3] = true;
		areFriends[3][2] = true; 
		
		countParing(0, 0); 
		
		System.out.println(answer);
	}
	
	private static void countParing(int paringCnt, int people) {
		if(paringCnt == 2) {
			answer++;
			return; 
		}
		
		if(isParing[people]) {
			countParing(paringCnt, people + 1);
			return;
		}
		
		for(int i=people+1; i<areFriends[people].length; i++) {
			if(areFriends[people][i] && !isParing[i]) {
				isParing[i] = true; 
				countParing(paringCnt + 1, people + 1);
				isParing[i] = false;
			}
		}
	}

}
