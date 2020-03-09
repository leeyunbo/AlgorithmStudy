package priorityqueue;

import java.util.PriorityQueue;

/**
 * �ſ� ���� �����ϴ� Leo�� ��� ������ ���ں� ������ K �̻����� ����� �ͽ��ϴ�. 
 * ��� ������ ���ں� ������ K �̻����� ����� ���� Leo�� ���ں� ������ ���� ���� �� ���� ������ �Ʒ��� ���� Ư���� ������� ���� ���ο� ������ ����ϴ�.
 * ���� ������ ���ں� ���� = ���� ���� ���� ������ ���ں� ���� + (�� ��°�� ���� ���� ������ ���ں� ���� * 2)
 * Leo�� ��� ������ ���ں� ������ K �̻��� �� ������ �ݺ��Ͽ� �����ϴ�.
 * Leo�� ���� ������ ���ں� ������ ���� �迭 scoville�� ���ϴ� ���ں� ���� K�� �־��� ��, ��� ������ ���ں� ������ K �̻����� ����� ���� ����� �ϴ� �ּ� Ƚ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * ���� ����
 * scoville�� ���̴� 1 �̻� 1,000,000 �����Դϴ�.
 * K�� 0 �̻� 1,000,000,000 �����Դϴ�.
 * scoville�� ���Ҵ� ���� 0 �̻� 1,000,000 �����Դϴ�.
 * ��� ������ ���ں� ������ K �̻����� ���� �� ���� ��쿡�� -1�� return �մϴ�.
 * @author ������
 *
 */

class Food implements Comparable<Food> {
	int scoville;  
	
	public Food(int _scoville) {
		scoville = _scoville;
	}
	
	@Override
	public int compareTo(Food target) {
		if (this.scoville > target.scoville) {
			return 1;
		} else if (this.scoville < target.scoville) {
			return -1; 
		}
		return 0;
	}
}

public class ScovilleQueue {
	static int myScoville[] = {1,2};
	static int myK = 7;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = 0;
		PriorityQueue<Food> queue = getPriorityQueue();
		while(changeScoville(queue)) {
			answer++;
			if(isFinish(queue)) break;
		}
		
		if(queue.size() == 1 && !isFinish(queue))
			answer = -1;
		
		System.out.println(answer);

	}
	
	private static boolean changeScoville(PriorityQueue<Food> queue) {
		if(queue.size() >= 2) {
			int scoville = queue.poll().scoville + (queue.poll().scoville *2);
			queue.add(new Food(scoville));
			return true;
		}
		else return false;
	}
	
	private static PriorityQueue<Food> getPriorityQueue() {
		PriorityQueue<Food> queue = new PriorityQueue<Food>();
		for(int i=0; i<myScoville.length; i++) {
			queue.add(new Food(myScoville[i]));
		}
		return queue;
	}
	
	private static boolean isFinish(PriorityQueue<Food> queue) {
		if(queue.peek().scoville >= myK) {
			return true;
		}
		return false;
	}
}


