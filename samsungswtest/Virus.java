import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Virus {
	static int mapN = 9, mapM = 6;
	static String[] map = {"*****Z", "******", "HH-I*A", "**IH*B", "C*-***", "C**---", "CAZBBA", "ZZ****", "***F**"};
	static char[][] realMap;
	static boolean[][] isChecked;
	static HashMap<Character, Integer> hashMap = new HashMap<>();
	static int[] resultList = new int[26];
	static boolean[] alphabet = new boolean[26];
	public static void main(String[] args) {
		realMap = new char[mapN][mapM];
		isChecked = new boolean[mapN][mapM];
		
		//OK
		for(int i=0; i<map.length; i++) {
			String line = map[i]; 
			for(int j=0; j<line.length(); j++) {
				realMap[i][j] = line.charAt(j);
			}
		}
		
		for(int i=0; i<mapN; i++) {
			for(int j=0; j<mapM; j++) {
				if(realMap[i][j] == '-' || realMap[i][j] == '*') continue;
				if(!isChecked[i][j]) {
					DFS(i,j);
					List<Character> KeySetList = sortHashMap();
					for(Character key : KeySetList) {
						resultList[key-65] += hashMap.get(key);
						break;
					}
					hashMap.clear();
				}
			}
		}
		
		System.out.println(printResult());

	}
	
	private static String printResult() {
		String result = "";
		
		for(int i=0; i<alphabet.length; i++) {
			if(alphabet[i]) {
				result = result + (char)(i+65) + "" + resultList[i]; 
			}
		}
		
		return result;
	}
	
	private static List<Character> sortHashMap() {
		List<Character> keySetList = new ArrayList<>();
		keySetList.addAll(hashMap.keySet());
		Collections.sort(keySetList, (o1,o2) -> (hashMap.get(o2).compareTo(hashMap.get(o1))));
		return keySetList;
	}
	
	private static void DFS(int leftIdx, int rightIdx) {
		
		// base-case
		if(leftIdx < 0 || rightIdx < 0 || leftIdx >= mapN || rightIdx >= mapM) return;
		if(realMap[leftIdx][rightIdx] == '*') return;
		if(isChecked[leftIdx][rightIdx]) return;
		
		// recursion-case
		isChecked[leftIdx][rightIdx] = true;
		char temp = realMap[leftIdx][rightIdx];
		
		if(temp != '-') {
			if(!alphabet[temp-65]) alphabet[temp-65] = true;
			if(hashMap.containsKey(temp)) hashMap.put(temp, hashMap.get(temp) );
			else hashMap.put(temp, 1);
		}
		
		// 사방면으로 체크
		DFS(leftIdx + 1, rightIdx);
		DFS(leftIdx - 1, rightIdx);
		DFS(leftIdx, rightIdx + 1);
		DFS(leftIdx, rightIdx - 1);
	}
}
