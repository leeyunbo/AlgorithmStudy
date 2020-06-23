package programmers;

import java.util.*;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12981#
 * 프로그래머스 영어 끝말잇기
 */

public class EnglishTrain {

	public static void main(String[] args) {
		String[] words = {"tank, kick, know, wheel, land, dream, mother, robot, tank"};
		int[] answer = solution(3,words);
	}
	
	 private static int[] solution(int n, String[] words) {
	        int[] answer = new int[2];
	        List<String> wordList = new ArrayList<>(words.length);
	        char last, start;
	        int turn = 1, round = 1, i = 1;
	        
	        wordList.add(words[0]); 
	        last = words[0].charAt(words[0].length()-1);
	        
	        for(; i<words.length; i++) {
	            turn++; 
	            String tempWord = words[i];
	            start = tempWord.charAt(0); 
	            
	            if(wordList.contains(tempWord) || start != last || tempWord.length() == 1) {
	                break;
	            }
	            
	            wordList.add(tempWord);
	            
	            last = tempWord.charAt(tempWord.length()-1); 
	            
	            if(turn == n) {
	                round++;
	                turn = 0;
	            }
	        }
	        
	        if(i >= words.length) {
	            answer[0] = 0;
	            answer[1] = 0;
	        }
	        else {
	            answer[0] = turn; 
	            answer[1] = round; 
	        }

	        return answer;
	    }

}
