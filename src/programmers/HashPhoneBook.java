package programmers;

import java.util.Arrays;

public class HashPhoneBook {
	    public boolean solution(String[] phone_book) {
	        boolean answer = true;
	        Arrays.sort(phone_book);
	        
	        for(int i=0; i<phone_book.length-1; i++) {
	            String temp = phone_book[i];
	            for(int j = i+1; j<phone_book.length; j++) {
	                if(phone_book[j].indexOf(temp) == 0) {
	                    answer = false;
	                    break;
	                }
	            }
	            if(answer == false) break;
	            
	        }
	        
	        return answer;
	    }
	
}
