package hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class hashEx01 {
	public static HashMap<String,Integer> all_count_list = new HashMap<>();
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		Collections.reverseOrder();
		for(Integer num : list) {
			System.out.println(num);
		}
	}

}
