package queue;
/*
 * https://www.acmicpc.net/problem/18258
 * 백준 18258번 큐2 
 * 시간 제한 1초, 메모리 제한 512MB
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class CreateQueue {

	public static void main(String[] args) throws NumberFormatException, IOException {
		MyQueue queue = new MyQueue();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		for(int cnt=0; cnt<n; cnt++) {
			String[] command = br.readLine().split(" ");
			switch(command[0]) {
				case "push" :
					queue.addLast(Integer.parseInt(command[1]));
					break;
				case "pop" :
					bw.write(queue.pollFirst()+"\n");
					break;
				case "size" :
					bw.write(queue.size()+"\n");
					break;
				case "empty" :
					if(queue.isEmpty()) bw.write(1+"\n");
					else bw.write(0+"\n");
					break;
				case "front" :
					bw.write(queue.peekFirst()+"\n");
					break;
				case "back" :
					bw.write(queue.peekLast()+"\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}


class MyQueue extends LinkedList<Integer> {	
	//front
	@Override
	public Integer peekFirst() {
		// TODO Auto-generated method stub
		if(super.isEmpty()) {
			return -1;
		}
		return super.peekFirst();
	}

	//back
	@Override
	public Integer peekLast() {
		if(super.isEmpty()) {
			return -1;
		}
		return super.peekLast();
	}

	//pop
	@Override
	public Integer pollFirst() {
		if(super.isEmpty()) {
			return -1;
		}
		return super.pollFirst();
	}
}