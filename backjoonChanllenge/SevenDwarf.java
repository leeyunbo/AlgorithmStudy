package backjoonChanllenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Stack;

public class SevenDwarf {
	
	static boolean[] check = new boolean[9]; 
	static int[] height = new int[9]; 
	static boolean isFinish = false;
	static Stack<Integer> select = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}
		
		SearchDwarf(0);
		

	}
	
	static void SearchDwarf(int total) {
		int size = select.size();
		if(isFinish) return;
		if(select.size() > 7) return; 
		if(total > 100) return; 
		
		if(total == 100 && size == 7) {
			Collections.sort(select);
			for(int height : select) {
				System.out.println(height);
			}
			isFinish = true;
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(!check[i] && !isFinish) {
				check[i] = true;
				select.push(height[i]);
				SearchDwarf(total+height[i]);
				select.pop();
				check[i] = false;
			}
		}
		
	}

}
