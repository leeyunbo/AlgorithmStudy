package greedy;

import java.util.Arrays;
import java.util.TreeSet;

public class Matchorder {

	public static void main(String[] args) {
		int[] russian = {3000,2700,2800,2200,2500,1900};
		int[] korean = {2800,2750,2995,1800,2600,2000};
		
		TreeSet<Integer> rating = new TreeSet<Integer>();
		Arrays.sort(korean);
		for(int i=0; i<korean.length; i++) {
			rating.add(korean[i]);
		}
		
		for(int i=0; i<russian.length; i++) {
			if(rating.tailSet(russian[i]).size()==0) {
				System.out.println(rating.pollFirst());
			}
			else {
		        int data = rating.tailSet(russian[i]).first();
		        rating.remove(data);
		        System.out.println(data);
			}
		}

	}

}
