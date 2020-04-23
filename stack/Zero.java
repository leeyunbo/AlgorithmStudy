package com.leeyunbo.backjoon.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Zero {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int k = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack();
		int total = 0;
		
		for(int i=0; i<k; i++) {
			int n = Integer.parseInt(br.readLine());
			switch(n) {
				case 0 :
					total = total - stack.pop();
					break;
				default :
					stack.push(n);
					total += n;
			}
		}
		
		bw.write(total+"");
		bw.flush();
		bw.close();
	}
}
