package programmers;

/*
 * 모든 음식의 스코빌지수를 K이상으로 만들고 싶다. 
 * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위하여, 스코빌 지수가 가장 낮은 음식 2개를 합함 // 정렬을 해야한다는거죠? 
 * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식 스코빌 지수 + (두번째 *2) // 모델식이라고 할 수 있고
 * 모든 음식의 스코빌 지수가 k 이상이 될때까지 계속 섞어. // 반복적으로 확인을 해줘야겠네? 
 * scoville : 음식들의 스코빌 지수, k : 원하는 최소 스코빌 지수 
 * 섞어야 하는 최소 횟수를 return 해라.
 */

public class Heap {
	
	static final int INFINITE = 99;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] data = {INFINITE,1,2,3,9,10,12};
		build_min_heap(data);
		
		System.out.print(solution(data, 7));

	}
	static final int Parent(int i) {return i/2;}
	static final int Left(int i) {return 2*i;}
	static final int Right(int i) {return (2*i)+1;}
	
	public static int solution(int[] scoville, int k ) {
		int answer = 0;
		int first;
		int second;
		
		while(!finish(scoville, k)) {
			first = delete_node(scoville);
			second = scoville[1];
			scoville[1] = first + second*2;
			min_heapify(scoville,1);
			answer = answer + 1;		
		}
		
		return answer;
	}
	
	public static boolean finish(int[] scoville, int k) {
		boolean check = false;
		int i=0;
		for(i=1; i<scoville.length; i++) {
			if(scoville[i] < k) {
				break;
			}
		}
		if(i == scoville.length) check = true;
		
		return check;
		
	}
	
	public static void build_min_heap(int[] heap) {
		int length = heap.length;
		
		for(int i = length/2; i>0; i--) {
			min_heapify(heap,i);
		}
	}
	
	public static void min_heapify(int[] heap, int i) {
		int l = Left(i);
		int r = Right(i);
		int smallest = i;
		int buffer = 0;
		if(l < heap.length && heap[smallest] > heap[l]) {
			smallest = l;
		}
		
		if(r < heap.length && heap[smallest] > heap[r]) {
			smallest = r;
		}
		
		if(smallest != i) {
			buffer = heap[i]; 
			heap[i] = heap[smallest];
			heap[smallest] = buffer;	 
			min_heapify(heap, smallest);
		}
		
		return;
		
	}
	
	public static int delete_node(int[] heap) {
		int data = heap[1];
		heap[1] = INFINITE;
		min_heapify(heap,1);
		return data;
	}
	

}
