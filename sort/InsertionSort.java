package sort;

import java.util.Scanner;
/*
 * stable sort 
 * 이미 정렬되어있는 경우 굉장히 효율적 
 */
public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in); 
		int N = scanner.nextInt();
		int sort_list[] = new int[N];
		for(int i=0; i<N; i++) {
			sort_list[i] = (int) (Math.random()*N);
		}
		
		for(int i=0; i<N-1; i++) { //O(n^2)
			int key = sort_list[i+1];
			int j = i;
			for(j = i; j>=0; j--) {
				if(key > sort_list[j]) {
					break;
				}
				sort_list[j+1] = sort_list[j];
			}
			sort_list[j+1] = key;
			
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(sort_list[i]+ " ");
		}
	}
}
