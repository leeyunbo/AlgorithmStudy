package datastructure;

import java.util.LinkedList;

/**
 * Ʈ�� ���� �밡 ���� ���������� �� ���� �ٸ��� ������ ������ �ǳʷ� �մϴ�. 
 * ��� Ʈ���� �ٸ��� �ǳʷ��� �ּ� �� �ʰ� �ɸ����� �˾Ƴ��� �մϴ�. 
 * Ʈ���� 1�ʿ� 1��ŭ �����̸�, �ٸ� ���̴� bridge_length�̰� 
 * �ٸ��� ���� weight���� �ߵ��ϴ�.
 * �� Ʈ���� �ٸ��� ������ ������ ���� ���, �� Ʈ���� ���Դ� ������� �ʽ��ϴ�.
 * @author ������
 *
 */
public class BridgeQueue {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bridge_length = 100; 
		int weight = 100; 
		int[] truck_weights= {10,10,10,10,10,10,10,10,10,10};
		int answer = 0;
		
		System.out.println(solution(bridge_length,weight,truck_weights));
	}
	
	static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		int current_weight = 0;
		Bridge bridge = new Bridge(bridge_length,weight);
		LinkedList<Truck> waitQueue = new LinkedList<Truck>();
		for(int i=0; i<truck_weights.length; i++) {
			waitQueue.add(new Truck(bridge_length,truck_weights[i]));
		}
		bridge.waitQueue = waitQueue;
		Truck firstTruck = bridge.waitQueue.poll();
		bridge.bridgeQueue.add(firstTruck);
		bridge.current_weight += firstTruck.weight;//1�� �� 
		bridge.consume_time++;
		while(!bridge.waitQueue.isEmpty() || !bridge.bridgeQueue.isEmpty()) {
			System.out.print(bridge.consume_time+ " : ");
			for(Truck truck : bridge.bridgeQueue) {
				System.out.print(truck.weight+ " ");
			}
			System.out.println();
			bridge.addMove();
			if(!bridge.isFull() && !waitQueue.isEmpty()) {
				bridge.addTruck();
			}
		}                                                    
		return bridge.consume_time;             
	}

}

class Truck {
	int remain_time; 
	int weight; 
	public Truck(int remain_time, int weight) {
		this.remain_time = remain_time;
		this.weight = weight; 
	}
}

class Bridge {
	int length; 
	int bridge_weight;
	int current_weight;
	int consume_time;
	LinkedList<Truck> bridgeQueue = new LinkedList<Truck>();
	LinkedList<Truck> waitQueue = new LinkedList<Truck>();
	public Bridge(int length, int bridge_weight) {
		this.length = length;
		this.bridge_weight = bridge_weight;
		this.current_weight = 0;
		this.consume_time = 0;
	}
	void addTruck() {
		Truck truck = waitQueue.poll();
		bridgeQueue.add(truck);
		current_weight = current_weight +  truck.weight;
	}
	void exitTruck() {
		Truck truck = bridgeQueue.poll();
		current_weight = current_weight - truck.weight;
		this.consume_time = this.consume_time +  truck.remain_time;
		exitMove(truck.remain_time);
	}
	boolean isFull() {
		int nextWeight = 0;
		if(waitQueue.size() != 0) {
			nextWeight = waitQueue.peek().weight;
		}
		if(current_weight + nextWeight > bridge_weight) {
			return true;
		}
		return false;
	}
	void exitMove(int time) {
		for(Truck truck : bridgeQueue) {
			truck.remain_time = truck.remain_time - time;
		}
	}
	void addMove() {
		for(Truck truck : bridgeQueue) {
			truck.remain_time--;
		}
		this.consume_time++;
		if(!bridgeQueue.isEmpty() && bridgeQueue.peek().remain_time==0) {
			Truck truck = bridgeQueue.poll();
			current_weight = current_weight - truck.weight;
		}
	}
	boolean isEmpty() {
		if(bridgeQueue.isEmpty()) {
			return true;
		}
		return false;
	}
}
