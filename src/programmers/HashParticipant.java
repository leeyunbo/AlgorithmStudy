package programmers;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

/* �ؽ����̺��� �̿��� ������ ������ �������� */

	 class HashParticipant {
		    public String solution(String[] participant, String[] completion) {
		        //completion �������� �ʴ� �������� return ���ּ���. 
		        //���������� �������� �ֽ��ϴ�.
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
