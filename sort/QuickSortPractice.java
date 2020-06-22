package sort;

import java.util.Scanner;

public class QuickSortPractice {
	static int[] sort_list; 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		int N = scanner.nextInt();
		sort_list = new int[N];
		for(int i=0; i<N; i++) {
			sort_list[i] = (int) (Math.random()*N);
		}
		quick_sort(0,sort_list.length-1);
		for(int i=0; i<N; i++) {
			System.out.print(sort_list[i]+" ");
		}

	}
	
	private static void quick_sort(int left, int right) {
		if(left < right) {
			int pivot = partition(left, right);
			quick_sort(left, pivot-1);
			quick_sort(pivot+1, right);
		}
	}
	
	//pivot은 맨 왼쪽 데이터로 한다. 
	private static int partition(int left, int right) {
		int pivot = sort_list[left];
		int l = left + 1;
		int r = right; 
		
		while(l < r) {
			while(l < r && sort_list[r] > pivot) {
				r--;
			}
			
			while(l < r && sort_list[l] <= pivot) {
				l++;
			}
			
			if(l < r) {
				int temp = sort_list[l];
				sort_list[l] = sort_list[r]; 
				sort_list[r] = temp;
			}
		}
		
		sort_list[left] = sort_list[r]; 
		sort_list[r] = pivot; 

		return r; 
	}

}
