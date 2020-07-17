package nds;

public class SearchAlpha {
    static int[] cnt; 
	public static void main(String[] args) {
		String sentence = "Jackdaws love my big sphinx of quartz";
		String answer = "";
	    cnt = new int[26];
	        
	    for(int i=0; i<sentence.length(); i++) {
	          char temp = sentence.charAt(i);
	           temp = Character.toLowerCase(temp);
	           if((temp) < 97 || (temp) > 122) {
	        	   System.out.println(temp);
	        	   continue;
	           }
	           cnt[(temp) - 97]++;
	       }
	        
	        for(int i=0; i<cnt.length; i++) {
	            if(cnt[i] == 0) {
	                answer += (char) (i+97);
	            }
	        }
	        
	        System.out.println(answer);

	}

}
