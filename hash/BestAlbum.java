package hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * ��Ʈ���� ����Ʈ���� �帣 ���� ���� ���� ����� �뷡�� �� ���� ��� ����Ʈ �ٹ��� ����Ϸ� �մϴ�. 
 * �뷡�� ���� ��ȣ�� �����ϸ�, �뷡�� �����ϴ� ������ ������ �����ϴ�.
 * 1. ���� �뷡�� ���� ����� �帣�� ���� �����մϴ�.
 * 2. �帣 ������ ���� ����� �뷡�� ���� �����մϴ�.
 * 3. �帣 ������ ��� Ƚ���� ���� �뷡 �߿����� ���� ��ȣ�� ���� �뷡�� ���� �����մϴ�.
 * �뷡�� �帣�� ��Ÿ���� ���ڿ� �迭 genres�� �뷡�� ��� Ƚ���� ��Ÿ���� 
 * ���� �迭 plays�� �־��� ��, ����Ʈ �ٹ��� �� �뷡�� ���� ��ȣ�� ������� return �ϵ���
 *  solution �Լ��� �ϼ��ϼ���.
 *  
 * @author ������ 
 *
 */
public class BestAlbum {
	public static HashMap<String,HashMap<Integer,Integer>> music_list = new HashMap<>();
	public static HashMap<String,Integer> all_count_list = new HashMap<>();
	public static void main(String[] args) {
		String[] genres = {"classic","pop","classic","classic","pop"};
		int[] plays = {500,600,150,800,3500};
		List<Integer> result = new ArrayList<Integer>();
		
		for(int i=0; i<plays.length; i++) {
			String key = genres[i];
			Integer play = plays[i];
			if(all_count_list.containsKey(key)) {
				all_count_list.put(key,all_count_list.get(key)+play);
				music_list.get(key).put(i,play);
			}
			else { 
				all_count_list.put(key,play);
				music_list.put(key,new HashMap<>());
				music_list.get(key).put(i,play);
			}
		}
		List<String> GenreSortKeyList = insertCountToList();
		HashMap<String,List<Integer>> MusicSortKeyList = MusicListSort(); 
		
		for(String Genre : GenreSortKeyList) {
			int count = 2;
			for(Integer music_num : MusicSortKeyList.get(Genre)) {
				if(count == 0) break;
				result.add(music_num);
				count--;
			}
		}
		int results[] = new int[result.size()];
		for(int i=0; i<results.length; i++)
			results[i] = result.get(i);
		for(int i=0; i<results.length; i++) 
			System.out.print(results[i]);
		
	
	}
	
	static List<String> insertCountToList() {
		List<String> KeySetList = new ArrayList<>();
		KeySetList.addAll(all_count_list.keySet());
		Collections.sort(KeySetList, new Comparator<String>() {
			@Override
            public int compare(String o1, String o2) {
                return all_count_list.get(o2).compareTo(all_count_list.get(o1));
            }
		});
		
		return KeySetList;
	}
	
	static HashMap<String, List<Integer>> MusicListSort() {
		HashMap<String,List<Integer>> MusicKeySetList = new HashMap<>();
		List<String> GenreKeySetList = new ArrayList<>(all_count_list.keySet());
		for(String Genre : GenreKeySetList) {
			List<Integer> KeySetList = new ArrayList<>(music_list.get(Genre).keySet());
			Collections.sort(KeySetList);
			Collections.sort(KeySetList, new Comparator<Integer>() {
				@Override
	            public int compare(Integer o1, Integer o2) {
	                return music_list.get(Genre).get(o2).compareTo(music_list.get(Genre).get(o1));
	            }
			});
			MusicKeySetList.put(Genre, KeySetList);
		}
		
		return MusicKeySetList;
		
	}
}
