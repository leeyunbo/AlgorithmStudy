package programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12987
 * 프로그래머스 숫자 게임 
 */

import java.util.*; 

public class NumberGame {

	public static void main(String[] args) {
		int[] A = {5,1,3,7};
		int[] B = {2,2,6,8};
		int answer = solution(A, B);
	}
	
	private static int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A); 
        Arrays.sort(B);
        
        int a = 0, b = 0; 
        
        while(b < B.length) {
            if(A[a] < B[b]) {
                a++;
                b++;
                answer++;
            }
            else {
                b++; 
            }
        }
        
        return answer;
    }

}
