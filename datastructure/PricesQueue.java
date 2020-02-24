package datastructure;

import java.util.LinkedList;
import java.util.Stack;

public class PricesQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {0,4,1,2,1};
		int[] result = new int[prices.length];
		int temp = 0;
		int beforeTemp = 0;
		int tempCnt = 0;
		int resultIdx = prices.length-1;
		Stack<Integer> stack = new Stack<>();
		LinkedList<Integer> reversePrices = new LinkedList<>(); 
		
		for(int i=0; i<prices.length; i++) 
			stack.add(prices[i]);
		
		for(int i=0; i<prices.length; i++) {
			reversePrices.add(stack.pop());
		}
		                                                     
		while(!reversePrices.isEmpty()) { //0,4,1,2,1 => 0,0,1,1,2                    
			temp = reversePrices.poll();        
			if(resultIdx == 0) {
				result[resultIdx] = tempCnt;
				break;
			}
				if(resultIdx == prices.length-1) {
					result[resultIdx--] = 0;
					if(temp > reversePrices.peek())
						tempCnt++;
					else 
						tempCnt = 1;
				}
				else {
					if(temp > reversePrices.peek()) {
						result[resultIdx--] = tempCnt;
						tempCnt += reversePrices.peek();
					}
					else {
						result[resultIdx--] = tempCnt;
						tempCnt = 1;
					}
				}
			}
		
		for(int i=0; i<result.length; i++)
			System.out.println(result[i]);
		
	}

}
