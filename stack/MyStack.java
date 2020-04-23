package com.leeyunbo.backjoon.stack;
/*
 * https://www.acmicpc.net/problem/10828
 * 백준 10828번 스택 
 * 시간 제한 0.5초, 메모리 제한 256MB
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class MyStack {
	
	static BufferedReader br; 
	static BufferedWriter bw;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		NewStack stack = new NewStack(); 
		
		for(int i=0; i<n; i++) {
			String[] command = br.readLine().split(" ");
			switch(command[0]) {
				case "push" :
					int num = Integer.parseInt(command[1]);
					stack.push(num);
					break;
				case "top" :
					bw.write(stack.peek() + "\n");
					bw.flush();
					break;
				case "size" :
					bw.write(stack.size() + "\n"); 
					bw.flush();
					break;
				case "empty" :
					if(stack.empty()) bw.write(1+"\n");
					else bw.write(0 + "\n");
					bw.flush();
					break;
				case "pop" :
					bw.write(stack.pop() + "\n");
					bw.flush();
			}
		}
		bw.close();
	}	
}

class NewStack extends Stack {
	@Override
	public Object push(Object item) {
		// TODO Auto-generated method stub
		return super.push(item);
	}

	@Override
	public synchronized Object pop() {
		if(super.empty()) {
			return -1;
		}
		return super.pop();
	}

	@Override
	public synchronized Object peek() {
		if(super.empty()) {
			return -1;
		}
		return super.peek();
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return super.empty();
	}

	@Override
	public synchronized int search(Object o) {
		// TODO Auto-generated method stub
		return super.search(o);
	}
	
	
}


