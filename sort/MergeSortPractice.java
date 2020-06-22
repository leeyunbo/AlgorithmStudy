package sort;

import java.util.Scanner;

public class MergeSortPractice {
	static int[] sort_list;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		int N = scanner.nextInt();
		sort_list = new int[N];
		for(int i=0; i<N; i++) {
			sort_list[i] = scanner.nextInt();
		}
		
		MergeDivide(0, sort_list.length-1);
		
		for(int i=0; i<N; i++) {
			System.out.print(sort_list[i]+ " ");
		}
	}
	
	public static void MergeDivide(int left, int right) {
		//1. 왼쪽, 오른쪽으로 나눈다.
		//2. 병합한다. 
		if(left < right) {
			int mid = (left + right) / 2;
			MergeDivide(left, mid);
			MergeDivide(mid+1, right); 
			Merge(left, mid, right);
		}
	}
	
	public static void Merge(int left, int mid, int right) {
		int[] bucket_list = new int[right+1]; 
		
		//왼쪽 오른쪽을 정렬하여 병합한다. 
		int l = left; 
		int r = mid+1; 
		int m = 0; 
		
		while(l <= mid && r <= right) {
			if(sort_list[l] <= sort_list[r]) {
				bucket_list[m++] = sort_list[l++]; 
			}
			
			if(sort_list[r] < sort_list[l]) {
				bucket_list[m++] = sort_list[r++]; 
			}
		}
		
		while(l<=mid) {
			bucket_list[m++] = sort_list[l++]; 
		}
		
		while(r<=right) {
			bucket_list[m++] = sort_list[r++]; 
		}
		
		for(int i=left,k=0; i<=right; i++,k++) {
			sort_list[i] = bucket_list[k]; 
		}
	}
}
