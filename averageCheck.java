package coding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class averageCheck {

	public static void main(String[] args) {
		
		int N,n,average,buffer = 0;
		int total = 0;
		int count = 0;
		List<Double> list = new ArrayList<Double>();
		List<Integer> score_list = new ArrayList<Integer>();
		
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		
		for(int i=0; i<N; i++) {
			total = 0;
			count = 0;
			score_list.clear();
			n = scanner.nextInt();
			for(int j=0; j<n; j++) {
				buffer = scanner.nextInt();
				total += buffer;
				score_list.add(buffer);
			}
			average = total / n; 
			
			for(int k=0; k<n; k++) {
				if(score_list.get(k)>average) {
					count ++;
				}
			}	
			list.add((double)count/n);
		}
		
		for(int idx=0; idx<N; idx++) {
			System.out.println(String.format("%.3f", list.get(idx) * 100) + "%");
		}
	}

}
