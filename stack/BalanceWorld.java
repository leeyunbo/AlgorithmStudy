package com.leeyunbo.backjoon.stack;

/*
 * acmicpc.net/problem/4949
 * 백준 4949번 균형잡힌 세상 
 * 시간 제한 1초, 메모리 제한 128MB
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Stack;

public class BalanceWorld {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<Character, Character> match = new HashMap<>(); 
		match.put(')','(');
		match.put(']','[');
		
		String line = "";
		boolean isVps = true;
		Stack<Character> stack = new Stack<>();
		while(true) {
			line = br.readLine(); 
			if(line.equals(".")) break;
			stack.clear();
			isVps = true;
			for(int idx=0; idx<line.length(); idx++) {
				char temp = line.charAt(idx); 
				switch(temp) {
					case '(' :
						stack.push(temp);
						break;
					case '[' :
						stack.push(temp);
						break;
					case ')' :
					case ']' :
						if(stack.isEmpty() || stack.pop() != match.get(temp)) {
							isVps = false; 
						}
					default :
				}
				if(!isVps) break; 
			}
			if(stack.isEmpty() && isVps) {
				bw.write("yes\n");
			}
			else {
				bw.write("no\n");
			}
		}
		bw.flush();
		bw.close();
	} // main
} // class
