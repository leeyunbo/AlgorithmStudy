package com.leeyunbo.backjoon.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
 * https://www.acmicpc.net/problem/9012
 * 백준  9012번 괄호 
 * 시간 제한 1초, 메모리 제한 128MB 
 */
public class VPS {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Character> stack = new Stack<>(); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean isVps = true;
		int t = Integer.parseInt(br.readLine());
		for(int cnt=0; cnt<t; cnt++) {
			String line = br.readLine();
			isVps = true; 
			stack.clear();
			for(int idx=0; idx<line.length(); idx++) {
				char temp = line.charAt(idx);
				switch(temp) {
					case '(':
						stack.push(temp);
						break;
					case ')':
						if(stack.isEmpty() || stack.pop() != '(') {
							isVps = false; 
						}
				}
			}
			if(isVps == true && stack.isEmpty()) {
				bw.write("YES\n");
			}
			else {
				bw.write("NO\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
