package programmers;

public class Level1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Solution solution = new Solution();
			String solutions = solution.solution("abcdefghijk");
			
			System.out.print(solutions);
	}


}


class Solution {
	  public String solution(String s) {
	      String answer = "";
	      for(int i=0; i<s.length(); i++) {
	          if(i%2==0) answer = answer + s.substring(i,i+1).toUpperCase();
	          else answer = answer + s.substring(i,i+1);
	      }
	      return answer;
	  }
	}
