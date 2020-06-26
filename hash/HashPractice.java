package hash;
import java.util.*;
import java.util.Map.Entry; 

/*
 * Hash - Value에 의한 정렬 
 */

public class HashPractice {
	public static void main(String[] args) {
		HashMap<Integer, User> map = new HashMap<>(); 
		map.put(1, new User("leeyunbok",99));
		map.put(2, new User("leeyunbok",999));
		map.put(9, new User("leeyunbok",9));
		map.put(3, new User("leeyunbok",99999));
		map.put(5, new User("leeyunbok",9999));
		map.put(6, new User("leeyunbok",999999));
		
		
		// value에 의해서 정렬되려면 어떻게 해야할까? Comparator를 사용하자 
		List<Integer> keySetList = new ArrayList<>(map.keySet());
		Collections.sort(keySetList, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2); 
				if(v1 instanceof Comparable && v2 instanceof Comparable) {
					Comparable c1 = (Comparable) v1;
					Comparable c2 = (Comparable) v2; 
					return c2.compareTo(c1);
				}
				return 0;
			}
		});
		
		for(int key : keySetList) {
			System.out.println(key+","+map.get(key));
		}
	}
}

class User implements Comparable<User>{
	String nickname;
	int score; 
	
	public User(String _nickname, int _score) {
		nickname = _nickname;
		score = _score; 
	}
	
	@Override
	public int compareTo(User target) {
		if(score > target.score) {
			return 1;
		}
		else if(score < target.score) {
			return -1;
		}
		else return 0; 
	}
	
	@Override 
	public String toString() {
		return nickname + "," + score;
	}
}
