package datastructure;
import java.util.*;

class Prisoner implements Comparable<Prisoner> {
	String name;
	int weight;  // Çü·® 
	
	public Prisoner(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	@Override
	public int compareTo(Prisoner target) {
		if (this.weight > target.weight) {
			return -1;
		} else if (this.weight < target.weight) {
			return 1; 
		}
		return 0;
	}
}
public class pqueue {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Prisoner> queue = getPriorityQueue();
		while(!queue.isEmpty()) {
			System.out.println(queue.poll().weight);
		}

	}
	
	private static PriorityQueue<Prisoner> getPriorityQueue() {
		Prisoner prisoner1 = new Prisoner("james", 5);
		Prisoner prisoner2 = new Prisoner("a", 99);
		Prisoner prisoner3 = new Prisoner("b", 14);
		Prisoner prisoner4 = new Prisoner("c", 10);
		Prisoner prisoner5 = new Prisoner("d", 51);
		
		PriorityQueue<Prisoner> queue = new PriorityQueue<Prisoner>();
		
		queue.offer(prisoner1);
		queue.offer(prisoner2);
		queue.offer(prisoner3);
		queue.offer(prisoner4);
		queue.offer(prisoner5);
		return queue;
		
	}
}
