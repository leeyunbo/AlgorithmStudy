package priorityqueue;

import java.util.LinkedList;
import java.util.PriorityQueue;
/**
 * ��� ���忡���� �Ϸ翡 �а��縦 1�澿 ����մϴ�. ���� �а��縦 ���޹޴� ������ �������� ������ k�� ���Ŀ��� �а��縦 ���޹��� �� �ֱ� ������ �ؿ� ���忡�� �а��縦 �����ؾ� �մϴ�.
 * �ؿ� ���忡���� ���� �а��縦 ������ �� �ִ� ��¥�� ������ �˷��־���, ��� ���忡���� ��ۺ� ���̱� ���� �ּ����� Ƚ���� �а��縦 ���޹ް� �ͽ��ϴ�.
 * ���� ���忡 �����ִ� �а��� ���� stock, �а��� ���� ����(dates)�� �ش� ������ ���� ������ �а��� ����(supplies), ���� �������κ��� ���޹��� �� �ִ� ���� k�� �־��� ��, �а��簡 �������� �ʰ� ������ ��ϱ� ���ؼ� �ּ��� �� �� �ؿ� �������κ��� �а��縦 ���޹޾ƾ� �ϴ����� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
 * dates[i]���� i��° ���� �������� ���������, supplies[i]���� dates[i] ��¥�� ���� ������ �а��� ������ ��� �ֽ��ϴ�.
 * 
 * ���ѻ���
 * stock�� �ִ� �а���� ����(0�� ����)���� ���˴ϴ�.
 * stock�� k�� 2 �̻� 100,000 �����Դϴ�.
 * dates�� �� ���Ҵ� 1 �̻� k �����Դϴ�.
 * supplies�� �� ���Ҵ� 1 �̻� 1,000 �����Դϴ�.
 * dates�� supplies�� ���̴� 1 �̻� 20,000 �����Դϴ�.
 * k�� °���� �а��簡 ����� ���޵Ǳ� ������ k-1�Ͽ� ����� ���������� Ȯ���ϸ� �˴ϴ�.
 * dates�� ����ִ� ��¥�� �������� ���ĵǾ� �ֽ��ϴ�.
 * dates�� ����ִ� ��¥�� ���޵Ǵ� �а���� �۾� ���� �� ������ ���޵Ǵ� ���� �������� �մϴ�. ���� ��� 9��°�� �а��簡 �ٴڳ�����, 10��°�� ���޹����� 10��°���� ������ ��� �� �ֽ��ϴ�.
 * �а��簡 �ٴڳ��� ���� �־����� �ʽ��ϴ�.
 * 
 * @author ������
 *
 */
class Supply implements Comparable<Supply> {
	int supply;
	int date;
	
	public Supply(int _supply , int _date) {
		supply = _supply;
		date = _date;
	}
	
	@Override
	public int compareTo(Supply target) {
		if (this.supply > target.supply) {
			return -1;
		} else if (this.supply < target.supply) {
			return 1; 
		}
		return 0;
	}
}
public class FoodFactoryQueue {
	static int[] myDates = {4,10,15};
	static int[] mySupplies = {20,5,10};
	static int myK = 30; 
	static int myStock = 4;
	static LinkedList<Supply> supplyList;
	public static void main(String[] args) {
		int answer = 0;
		supplyList = new LinkedList<>();
		for(int i=0; i<myDates.length; i++) { 
			supplyList.add(new Supply(mySupplies[i],myDates[i]));
		}
		answer = getSupply();
		
		System.out.println(answer);
	}
	
	private static PriorityQueue<Supply> getPriorityQueue() {
		PriorityQueue<Supply> queue = new PriorityQueue<>();		
		return queue;
	}
	
	private static int getSupply() {
		LinkedList<Supply> bufferList = new LinkedList<>();
		PriorityQueue<Supply> queue = getPriorityQueue();
		int answer = 0;
	
		while(myStock < (myK)) {
			while(!supplyList.isEmpty()) {
				Supply tempSupply = supplyList.peek();
				if(myStock >= tempSupply.date) {
					queue.add(supplyList.poll());
				}
				else break;
			}
			
			myStock += queue.poll().supply;
			answer++;
			System.out.println(myStock);
		}
		
		return answer;

	}

}
