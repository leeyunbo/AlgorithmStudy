package line;

import java.util.Stack;

public class stackCheck {
	static String[][] check = {{"<",">"},{"[","]"},{"{","}"},{"(",")"}}; 
	public static void main(String[] args) {
		int answer = 0;
		String inputString = "if (Count of eggs is 4.) {Buy milk.}";
		Stack<String> stack = new Stack<>();
		for(int i=0; i<inputString.length(); i++) {
			String temp = inputString.substring(i,i+1);
			for(int j=0; j<check.length; j++) {
				if(temp.equals(check[j][0])) {
					stack.push(temp);
				}
				if(temp.equals(check[j][1])) {
					if(stack.empty()) {
						System.out.println("-1");
						return;
					}
					if(!stack.pop().equals(check[j][0])) {
						 System.out.println("-1");
						 return;
					 }
					 else {
						 answer++;
					 }
				}
			}
		}
		
		System.out.println(answer);
	}

}
