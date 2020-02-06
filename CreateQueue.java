package coupang;

import java.util.Stack;

public class CreateQueue {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = {1,2,3,4};
		Queue queue = new Queue(list);
		queue.push(0);
		System.out.println(queue.toString());
		for(int i=0; i<queue.size(); i++) { 
			System.out.print(queue.pop()+",");
		}
		System.out.println();
		
		
		/*
		String elsa = "elsa";
		Stack stack = new Stack();
		Stack stack2 = new Stack();
		for(int i=0; i<elsa.length(); i++) 
			stack.push(elsa.charAt(i));
		
		for(int i=0; i<elsa.length(); i++) 
			stack2.push(stack.pop());
		
		for(int i=0; i<elsa.length(); i++)
			System.out.print(stack2.pop());
		System.out.println();*/
	}

}

class Queue {
	Stack<Integer> stack = new Stack();
	int[] list;
	public Queue(int[] list) {
		this.list = list;
	}
	public void push(int idx) {
		if(idx >= list.length) return; //기본적으로 자바의 함수 호출은 호출 스택에 쌓이기 때문에, 맨 마지막에 push 된 함수가 첫번째로 호출된다.
		push(idx+1);
		stack.push(list[idx]);
	}
	public String toString() {
		return stack.toString();
	}
	public int pop() {
		return stack.pop();
	}
	public int size() {
		return list.length;
	}
	
}


