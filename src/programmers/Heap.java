package programmers;

/*
 * ��� ������ ���ں������� K�̻����� ����� �ʹ�. 
 * ��� ������ ���ں� ������ K �̻����� ����� ���Ͽ�, ���ں� ������ ���� ���� ���� 2���� ���� // ������ �ؾ��Ѵٴ°���? 
 * ���� ������ ���ں� ���� = ���� ���� ���� ���� ���ں� ���� + (�ι�° *2) // �𵨽��̶�� �� �� �ְ�
 * ��� ������ ���ں� ������ k �̻��� �ɶ����� ��� ����. // �ݺ������� Ȯ���� ����߰ڳ�? 
 * scoville : ���ĵ��� ���ں� ����, k : ���ϴ� �ּ� ���ں� ���� 
 * ����� �ϴ� �ּ� Ƚ���� return �ض�.
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
