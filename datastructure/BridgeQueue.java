package datastructure;

import java.util.LinkedList;

/**
 * 트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 
 * 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 
 * 트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 
 * 다리는 무게 weight까지 견딥니다.
 * ※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.
 * @author 이윤복
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
		bridge.current_weight += firstTruck.weight;//1대 들어감 
		bridge.consume_time++;
		while(!bridge.waitQueue.isEmpty() || !bridge.bridgeQueue.isEmpty()) {
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
}
