package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class CRA {
	static int [][] time_list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		time_list = new int[N][2];
		for(int i=0; i<N; i++) {
			String buffer[] = br.readLine().split(" ");
			time_list[i][0] = Integer.parseInt(buffer[0]);
			time_list[i][1] = Integer.parseInt(buffer[1]);
		}
		
		Arrays.sort(time_list, new Comparator<int[]>() {
			@Override
			public int compare(final int[] entry1, final int[] entry2) {
				final Integer time1 = entry1[0];
				final Integer time2 = entry2[0];
				return Integer.compare(time1, time2);
			}
		});
		
		Arrays.sort(time_list, new Comparator<int[]>() {
			@Override
			public int compare(final int[] entry1, final int[] entry2) {
				final Integer time1 = entry1[1];
				final Integer time2 = entry2[1];
				return Integer.compare(time1, time2);
			}
		});
		
		
		for(int i=0; i<time_list.length; i++) {
			System.out.println(time_list[i][0] + " " +time_list[i][1]);
		}
		System.out.println(CRA());	
	}
	
	private static int CRA() {
		int max_count = 0;
		int first = time_list[0][1]; max_count++; 
		for(int i=1; i<time_list.length; i++) {
			if(first <= time_list[i][0]) {
				first = time_list[i][1]; max_count++;
			}
		}
		return max_count;
	}

}
