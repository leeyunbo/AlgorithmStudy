package coupang;

import java.util.Stack;

public class ReverseString {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String noReverse = "abcdefghijklmnop"; 
		Stack stack = new Stack();
		for(int i=0; i<noReverse.length(); i++) 
			stack.push(noReverse.charAt(i));
		
		for(int i=0; i<noReverse.length(); i++) 
			System.out.print(stack.pop());
		System.out.println();
	}

}
