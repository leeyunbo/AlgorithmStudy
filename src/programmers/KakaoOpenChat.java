package programmers;
import java.util.*;

public class KakaoOpenChat {

	    public String[] solution(String[] record) {
	        ArrayList<String> answer = new ArrayList<String>();
	        ArrayList<String> uidList = new ArrayList<String>();
	        ArrayList<String> howList = new ArrayList<String>();
	        HashMap<String,String> map = new HashMap<String,String>(); 
	        int index = 0;
	        
	        for(String command : record) {
	            String[] words = command.split(" ");
	        
	            if(words[0].equals("Enter")) {
	                howList.add(words[0]);
	                uidList.add(words[1]);
	                map.put(words[1],words[2]);
	                index++;
	            } 
	            else if(words[0].equals("Leave")) {
	                howList.add(words[0]);
	                uidList.add(words[1]);
	            }
	            else if(words[0].equals("Change"))
	            {
	                map.put(words[1],words[2]);            
	            }
	        }
	        
	        for(int i = 0; i < index+1; i++) {
	            if(howList.get(i).equals("Enter")) {
	                answer.add(map.get(uidList.get(i))+"´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
	            } 
	            else if(howList.get(i).equals("Leave")) {
	                answer.add(map.get(uidList.get(i))+"´ÔÀÌ ³ª°¬½À´Ï´Ù.");
	            }
	        }
	    
	        String[] real_answer = answer.toArray(new String[answer.size()]);
	        
	        for(int k=0; k<index+1; k++) {
	        System.out.println(real_answer[k]);
	        }
	        return real_answer;

	    }
	
}
