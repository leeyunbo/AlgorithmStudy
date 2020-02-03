package sort;

import java.util.Scanner;
/*
 * stable sort, 추가적인 저장공간 필요 
 * O(nlgn)
 */
public class MergeSort {
	static int[] sort_list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in); 
		int N = scanner.nextInt();
		sort_list = new int[N];
		for(int i=0; i<N; i++) {
			sort_list[i] = (int) (Math.random()*N);
		}
		MergeDivide(0, sort_list.length-1);
		for(int i=0; i<N; i++) {
			System.out.print(sort_list[i]+ " ");
		}
	}
	
	public static void Merge(int left, int right, int mid) {
		int[] buffer_list = new int[right+1];
		int l = left;
		int r = mid+1;
		int k = 0;
		while(l <= mid && r <= right && k <= right) {
			if(sort_list[l] < sort_list[r]) {
				buffer_list[k++]  = sort_list[l++];
			}
			else {
				buffer_list[k++] = sort_list[r++];
			}
		}
		
		while(l<=mid) {
			buffer_list[k++] = sort_list[l++];
		}
		
		while(r<=right) {
			buffer_list[k++] = sort_list[r++];	
		}
		
		
		for(int i=left, j=0; i<buffer_list.length; i++) {
			sort_list[i] = buffer_list[j++];
		}
		
	}
	
	public static void MergeDivide(int left, int right) {
		if(left < right) {
			int mid = (left+right)/2;
			MergeDivide(left, mid);
			MergeDivide(mid+1, right);
			Merge(left, right, mid);
		}
	}

}
