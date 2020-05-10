package greedy;

/*
 * https://www.acmicpc.net/problem/1541
 * น้มุ 1541น๘ ภาพ๎น๖ธฐ ฐýศฃ 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Lost {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> expressions = new ArrayList<>();
		String expression = br.readLine(); 
		
		StringBuffer tempNumber = new StringBuffer("");
		for(int i=0; i<expression.length(); i++) {
			char temp = expression.charAt(i);
			if(temp == '-' || temp == '+') {
				expressions.add(tempNumber.toString());
				expressions.add(String.valueOf(temp));
				tempNumber = new StringBuffer("");
			}
			else {
				tempNumber.append(temp);
			}
		}
		
		expressions.add(tempNumber.toString());
		
		int result = 0;
		for(int i=0; i<expressions.size()-3; i++) {
			String temp = expressions.get(i); 
			if(temp.equals("-") && expressions.get(i+2).equals("+")) {
				result += Integer.parseInt(expressions.get(i+1)) + Integer.parseInt(expressions.get(i+3));
				expressions.add(i+1, String.valueOf(result));
				expressions.remove(i+2);
				expressions.remove(i+2);
				expressions.remove(i+2);
				result = 0;
				i = i - 1;
			}
		}
		
		System.out.println(calc(expressions));
		
	}
	
	private static int calc(List<String> expressions) {
		int result = Integer.parseInt(expressions.get(0));
		for(int i=1; i<expressions.size(); i+=2) {
			String temp = expressions.get(i); 
			if(temp.equals("+")) {
				result += Integer.parseInt(expressions.get(i+1));
			}
			if(temp.equals("-")) {
				result -= Integer.parseInt(expressions.get(i+1));
			}
		}
		
		return result; 
	}
}
