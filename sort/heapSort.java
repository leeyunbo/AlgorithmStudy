package sort;

import java.util.Scanner;
/*
 * 힙 정렬을 일관된 성능을 나타냄 
 * unstable sort 
 * 데이터를 힙으로 변환 해야하는 오버헤드가 존재 
 */
public class heapSort {
	public static int[] sort_list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in); 
		int N = scanner.nextInt();
		sort_list = new int[N+1];
		for(int i=1; i<N+1; i++) {
			sort_list[i] = (int) (Math.random()*N);
		}
		Max_Heap maxHeap = new Max_Heap();
		max_heap_sort(maxHeap);
		System.out.println();
		Min_Heap minHeap = new Min_Heap();
		min_heap_sort(minHeap);
		/*
		for(int i=1; i<sort_list.length; i++) {
			if(p == 0) {
				System.out.println();
				level = level * 2;
				p = level;
			}
			System.out.print(sort_list[i]+ " ");
			p--;
		}*/
	}

	public static void max_heap_sort(Max_Heap maxHeap) {
		maxHeap.build_max_heap();
		for(int i = sort_list.length-1; i>=1; i--) {
			int temp = sort_list[1];
			sort_list[1] = sort_list[i]; 
			sort_list[i] = temp;
			System.out.print(temp + " ");
			maxHeap.heap_size--;
			maxHeap.max_heapify(1);
		}
}
	public static void min_heap_sort(Min_Heap minHeap) {
		minHeap.build_min_heap();
		for(int i = sort_list.length-1; i>=1; i--) {
			int temp = sort_list[1];
			sort_list[1] = sort_list[i]; 
			sort_list[i] = temp;
			System.out.print(temp + " ");
			minHeap.heap_size--;
			minHeap.min_heapify(1);
		}
}
}

class Heap {
	int heap_size; 
	Heap(int heap_size) {
		this.heap_size = heap_size;
	}
	public int left(int idx) {
		return idx*2;
	}
	public int right(int idx) {
		return (idx*2)+1;
	}
}


class Max_Heap extends Heap{ 
	Max_Heap() {
		super(heapSort.sort_list.length-1);
	}
	public void max_heapify(int idx) {
		int left = left(idx);
		int right = right(idx);
		int max = idx;
		if(left <= heap_size-1 && heapSort.sort_list[max] < heapSort.sort_list[left])
			max = left;
		if(right <= heap_size-1 && heapSort.sort_list[max] < heapSort.sort_list[right]) 
			max = right;
		
		if(max != idx) {
			int temp = heapSort.sort_list[idx];
			heapSort.sort_list[idx] = heapSort.sort_list[max]; 
			heapSort.sort_list[max] = temp;
			max_heapify(max);
		}
	}
	
	public void build_max_heap() {
		for(int i=heap_size/2; i>=1;  i--) {
			max_heapify(i);
		}
	}
}

class Min_Heap extends Heap{
	Min_Heap() {
		super(heapSort.sort_list.length-1);
	}
	public void min_heapify(int idx) {
		int left = left(idx);
		int right = right(idx);
		int min = idx;
		if(left <= heap_size-1 && heapSort.sort_list[min] > heapSort.sort_list[left])
			min = left;
		if(right <= heap_size-1 && heapSort.sort_list[min] > heapSort.sort_list[right]) 
			min = right;
		
		if(min != idx) {
			int temp = heapSort.sort_list[idx];
			heapSort.sort_list[idx] = heapSort.sort_list[min]; 
			heapSort.sort_list[min] = temp;
			min_heapify(min);
		}
	}
	
	public void build_min_heap() {
		for(int i=heap_size/2; i>=1;  i--) {
			min_heapify(i);
		}
	}
}
