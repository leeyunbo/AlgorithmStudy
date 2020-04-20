package sort;

/**
 * https://www.acmicpc.net/status?user_id=servers1&problem_id=2750&from_mine=1
 * 백준 2750번 수 정렬하기 
 * 시간 제한 1초, 메모리 제한 128MB 
 * O(n^2)의 퍼포먼스를 나타내는 정렬 구현 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N2Sort {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		
		for(int i=0; i<n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		//1. Bubble sort 
		//bubbleSort(array)
		//2. Insertion sort
		//insertionSort(array)
		//3. Selection sort
		selectionSort(array);
		
		//4. print array 
		for(int i=0; i<n; i++) {
			bw.write(array[i]+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	private static void SWAP(int[] array, int leftIdx, int rightIdx) {
		int temp = array[leftIdx]; 
		array[leftIdx] = array[rightIdx]; 
		array[rightIdx] = temp;
	}
	
	private static void selectionSort(int[] array) { 
		int minIdx = 0; 
		for(int i=0; i<array.length-1; i++) {
			minIdx = i;
			for(int j=i+1; j<array.length; j++) {
				if(array[minIdx] > array[j]) {
					minIdx = j;
				}
			}
			SWAP(array, i, minIdx);
		}
	}
	
	private static void insertionSort(int[] array) {
		int key = 0;
		int i = 0, j = 0;
		for(i=1; i<array.length; i++) {
			key = array[i]; 
			for(j=i-1; j>=0 && array[j] > key; j--) {
				array[j+1] = array[j]; 
			}
			array[j+1] = key; 
		}
	}
	
	private static void bubbleSort(int[] array) {
		for(int i=0; i<array.length-1; i++) {
			for(int j=0; j<array.length-1; j++) {
				if(array[j] > array[j+1]) {
					SWAP(array,j,j+1);
				}
			}
		}
	}
}
