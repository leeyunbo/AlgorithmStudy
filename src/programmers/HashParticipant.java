package programmers;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

/* 해쉬테이블을 이용한 마라톤 완주자 가려내기 */

	 class HashParticipant {
		    public String solution(String[] participant, String[] completion) {
		        //completion 존재하지 않는 선수들을 return 해주세요. 
		        //동명이인이 있을수도 있습니다.
		        String answer = "";
		        HashMap<String, Integer> map = new HashMap<String, Integer>();
		        
		        for(String name : participant) {
		            Integer count = map.get(name);
		            map.put(name, (count == null) ? 1 : count+1);
		        }
		        
		        for(String name : completion) {
		            Integer count = map.get(name);
		            map.put(name, count-1);
		        }
		        
		        for(String name : participant) {
		            if(map.get(name) > 0) {
		                answer = name;
		            }
		        }
		        
		        return answer;
		
		
	}
	


}
