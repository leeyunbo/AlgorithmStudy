package programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/62049
 * 프로그래머스 종이접기
 */

import java.util.*;

public class Origami {

	public static void main(String[] args) {
		solution(5000);
	}
	
    private static int[] solution(int n) {
        int[] answer;
        int left,right; 
        
        List<Integer> list = new ArrayList<>();  
        list.add(0);
        
        
        for(int i=1; i<n; i++) {
            left = list.size()-1; 
            list.add(0);
            while(left >= 0) {
                if(list.get(left) == 1) list.add(0);
                else list.add(1);
                left--;
            }
        }
        
        answer = new int[list.size()]; 
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

}
