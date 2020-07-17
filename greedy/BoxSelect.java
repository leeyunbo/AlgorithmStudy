package nds;

import java.util.Arrays;

public class BoxSelect {

	public static void main(String[] args) {
		int[] goods = {5,3,7};
		int[] boxes = {3,7,6}; 
		int answer = 0;
		
		Arrays.sort(boxes);
		Arrays.sort(goods); 
		
		
		int i = 0, j = 0;
		while(i < boxes.length && j < goods.length) {
			if(boxes[i] < goods[j]) {
				i++;
			}
			else {
				i++;
				j++;
				answer++;
			}
		}
		
		System.out.println(answer);
	}

}
