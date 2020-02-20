package hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 
 * 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 * 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 
 * 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록
 *  solution 함수를 완성하세요.
 *  
 * @author 이윤복 
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
