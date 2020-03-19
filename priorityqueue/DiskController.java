package priorityqueue;

import java.util.PriorityQueue;

/**
 * �� �۾��� [�۾��� ��û�Ǵ� ����, �۾��� �ҿ����]���� ���� ��,
 * �۾����� �پ��� ������ ó���Ѵٰ� �������� ��, 
 * �۾����� (����ð� - ��û�Ǵ� ����)�� ���� ����� �ּڰ��� �������ּ���.
 * 
 * !!!!���� ����!!!!! 
 * (�Ҽ��� ������ ���� �����ϴ�.) 
 * �۾��� ������ 1�̻� 500���� �Դϴ�. 
 * �ð��� 0~1000, �ҿ�ð��� 1~1000�Դϴ�. 
 * �ϵ��ũ�� �۾��� �������� �ʰ� ���� ��쿡�� ���� ��û�� ���� �۾����� ó���մϴ�.  
 * @author serve
 *
 */

public class DiskController {
	static int[][] myJobs = {{1,9},{1,4},{1,5},{1,7},{1,3}};
	public static void main(String[] args) {
		Server server = new Server();
		PriorityQueue<Node> readyQueue = new PriorityQueue<>(
				(Node n1, Node n2) -> n1.requestTime >= n2.requestTime ? 1 :  -1);
		addNodeToReadyQueue(readyQueue);
		server.quitTime = readyQueue.peek().requestTime;
		for(int i=0; i<myJobs.length; i++) {
			//2. �� ���� ������ �� �ִ� �۾��� �ּ� ���� �ִ´�.
			addNodeToServer(server,readyQueue);
			//2-1 ���� ������ �۾��� �ִٸ�, ù�� ° �۾��� �����Ѵ�. 
			if(!server.isEmpty()) {
				server.OperateServer();
			}
			//2-2 ���� ������ �۾��� ���ٸ�, ���� ù��°�� ��û�� ������ �۾��� �����Ѵ�. 
			else {
				if(readyQueue.isEmpty()) break;
				server.OperateSpecificNode(readyQueue.poll());
			}
		}
		//3. ��� ���� ����Ѵ�.
		System.out.println(server.totalTime/myJobs.length);

	}
	
	private static void addNodeToReadyQueue(PriorityQueue<Node> readyQueue) {
		for(int i=0; i<myJobs.length; i++) {
			readyQueue.add(new Node(myJobs[i]));
		}
	}
	
	private static void addNodeToServer(Server server, PriorityQueue<Node> readyQueue) {
		int length = readyQueue.size();
		for(int i=0; i<length; i++) {
			Node node = readyQueue.peek();
			if(server.quitTime >= node.requestTime) {
				server.addNode(node);
				readyQueue.remove(node);
			}
		}
	}
}

class Server {
	int quitTime = 0;
	int totalTime = 0;
	PriorityQueue<Node> queue = new PriorityQueue<>(
			(Node n1, Node n2) -> n1.consumeTime >= n2.consumeTime ? 1 :  -1);
	
	void addNode(Node node) {
		queue.add(node);
	}
	
	void OperateSpecificNode(Node node) {
		if(quitTime > node.requestTime) 
			quitTime += node.requestTime;
		else 
			quitTime = node.requestTime + node.consumeTime;	
		totalTime += (quitTime - node.requestTime);
	}
	
	void OperateServer() {
		Node node = queue.poll();
		if(quitTime > node.requestTime) 
			quitTime += node.consumeTime;
		else 
			quitTime = node.requestTime + node.consumeTime;	
		totalTime += (quitTime - node.requestTime);
	}
	
	boolean isEmpty() {
		return queue.isEmpty();
	}
}

class Node {
	int consumeTime = 0;
	int requestTime = 0;
	
	Node(int[] time) {
		requestTime = time[0];
		consumeTime = time[1]; 
	}
	
	@Override
	public String toString() {
		return requestTime +"," + consumeTime;
	}
}
