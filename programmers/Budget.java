package programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12982
 * 프로그래머스 예산 
 */

import java.util.*; 

public class Budget {
	public static void main(String[] args) {
		int[] d = {1,3,2,5,4}; 
		int answer = solution(d, 9);
	}
	
	private static int solution(int[] d, int budget) {
	       int answer = 0;
	        
	       Arrays.sort(d); 
	        
	       for(int i=0; i<d.length; i++) {
	            if(budget >= d[i]) {
	                budget -= d[i];
	                answer++;
	            }
	            else break; 
	        }

	       return answer;
	}
}
