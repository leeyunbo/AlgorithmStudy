package sort;

import java.util.Scanner;

/*
 * O(nlgn) 
 * 이미 정렬된 데이터나, 역순인 데이터에 최악의 성능을 보여줌
 * 불균형 분할일 때 최악의 성능을 보여줌 
 */
public class quickSort {
	static int sort_list[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	
	private static int partition(int left,int right) {
		int pivot = left;
		int l = left+1;
		int h = right;
		int x = sort_list[pivot];
		while(l<h) {
			while(l<=h && sort_list[l]<x) {
				l++;
			}
			while(h>=l && sort_list[h]>x) {
				h--;
			}
			if(l<h) {
				int temp = sort_list[l];
				sort_list[l] = sort_list[h];
				sort_list[h] = temp;
			}
		}
		
		int temp = sort_list[pivot];
		sort_list[pivot] = sort_list[h];
		sort_list[h] = temp; 
		
		return h;
		
	}
	
	private static void quick_sort(int left, int right) {
		if(left < right) {
			int pivot = partition(left, right);
			quick_sort(left,pivot-1); 
			quick_sort(pivot+1,right);
		}
	}

}
