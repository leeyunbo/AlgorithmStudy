package datastructure;

import java.util.Arrays;
import java.util.Scanner;

public class NumSearch {
	static int[] list = {1,2,3,4,5};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		
		Arrays.sort(list);
		System.out.println(binarySearchN(0,list.length-1,1));
		
		
	}
	
	public static int binarySearchN(int start, int end, int data) {
		int ret = 0;
		if(start>end) return ret = 0;
		int middle = (start+end)/2;
		if(list[middle] < data) 
			ret = binarySearchN(middle+1,end,data);
		else if(list[middle] > data) 
			ret = binarySearchN(start,middle-1,data);
		else 
			return ret = 1;
		
		return ret;
		
	}

}
