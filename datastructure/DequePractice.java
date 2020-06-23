package datastructure;

/*
 * https://www.acmicpc.net/problem/10866
 * น้มุ ตฆ 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class DequePractice {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); 
		Deque deque = new Deque(); 
		for(int i=0; i<n; i++) {
			String[] line = br.readLine().split(" "); 
			String command = line[0]; 
			if(command.equals("push_back")) {
				deque.push_back(Integer.parseInt(line[1]));
			}
			else if(command.equals("push_front")) {
				deque.push_front(Integer.parseInt(line[1]));
			}
			else if(command.equals("front")) {
				System.out.println(deque.front());
			}
			else if(command.equals("back")) {
				System.out.println(deque.back());
			}
			else if(command.equals("size")) {
				System.out.println(deque.size());
			}
			else if(command.equals("empty")) {
				System.out.println(deque.empty());
			}
			else if(command.equals("pop_front")) {
				System.out.println(deque.pop_front());
			}
			else if(command.equals("pop_back")) {
				System.out.println(deque.pop_back());
			}
		}
	}

}


class Deque {
	LinkedList<Integer> list = new LinkedList<>(); 
	
	public void push_front(int x) {
		list.addFirst(x);
	}
	
	public void push_back(int x) {
		list.addLast(x);
	}
	
	public int pop_front() {
		if(empty()==1) return -1;
		return list.pollFirst();
	}
	
	public int pop_back() {
		if(empty()==1) return -1;
		return list.pollLast();
	}
	
	public int size() {
		return list.size();
	}
	
	public int empty() {
		if(list.isEmpty()) return 1; 
		else return 0;
	}
	
	public int front() {
		if(empty()==1) return -1;
		return list.peekFirst();
	}
	
	public int back() {
		if(empty()==1) return -1;
		return list.peekLast();
	}
}
