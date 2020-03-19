package priorityqueue;

import java.util.PriorityQueue;

/**
 * 각 작업이 [작업이 요청되는 시점, 작업의 소요시점]으로 들어올 때,
 * 작업들을 다양한 순서로 처리한다고 가정했을 때, 
 * 작업들의 (종료시간 - 요청되는 시점)에 대한 평균의 최솟값을 리턴해주세요.
 * 
 * !!!!제한 사항!!!!! 
 * (소수점 이하의 수는 버립니다.) 
 * 작업의 갯수는 1이상 500이하 입니다. 
 * 시간은 0~1000, 소요시간은 1~1000입니다. 
 * 하드디스크가 작업을 수행하지 않고 있을 경우에는 먼저 요청이 들어온 작업부터 처리합니다.  
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
			//2. 그 다음 수행할 수 있는 작업을 최소 힙에 넣는다.
			addNodeToServer(server,readyQueue);
			//2-1 만약 수행할 작업이 있다면, 첫번 째 작업을 수행한다. 
			if(!server.isEmpty()) {
				server.OperateServer();
			}
			//2-2 만약 수행할 작업이 없다면, 가장 첫번째로 요청이 들어오는 작업을 수행한다. 
			else {
				if(readyQueue.isEmpty()) break;
				server.OperateSpecificNode(readyQueue.poll());
			}
		}
		//3. 평균 값을 계산한다.
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
