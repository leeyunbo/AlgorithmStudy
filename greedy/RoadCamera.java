package greedy;
/*
 * https://programmers.co.kr/learn/courses/30/lessons/42884
 * 프로그래머스 레벨3 단속카메라 
 */
import java.util.PriorityQueue;

public class RoadCamera {
	static int[][] mRoutes = {{-20,15},{-14,-5},{-18,-13},{-5,-3}};
	public static void main(String[] args) {
		int answer = 1; 
		PriorityQueue<Car> pq = new PriorityQueue<>();
		
		for(int i=0; i<mRoutes.length; i++) {
			pq.add(new Car(mRoutes[i][0], mRoutes[i][1]));
		}
		
		Car before = pq.poll();
		while(!pq.isEmpty()) {
			Car temp = pq.poll();
			if(before.end >= temp.start) {
				//겹침 
				if(before.end > temp.end) {
					before = temp;
				}
			}
			else {
				before = temp; 
				answer++;
			}
		}
		
		System.out.println(answer);
	}

}

class Car implements Comparable<Car>{
	public int start; 
	public int end;
	public Car(int _start, int _end) {
		start = _start;
		end = _end; 
	}
	@Override
	public int compareTo(Car target) {
		if(this.start < target.start) {
			return -1;
		}
		else if(this.start > target.start) {
			return 1; 
		}
		return 0;
	}
}
