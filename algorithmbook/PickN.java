package algorithmbook;

import java.util.ArrayList;

/*
 * n개의 숫자가 있을 때, x개의 데이터를 pick하는 경우의 수를 출력하시오. 
 * 조건 : 재귀 호출을 사용할 것 
 */

public class PickN {
	private static int x = 4;
	private static int[] list = {1,2,3,4,5,6}; 
	public static void main(String[] args) {
		pick(0, new ArrayList<>());

	}
	
	private static void pick(int pickCnt, ArrayList<Integer> pickList) {
		if(pickCnt == x) {
			System.out.println(pickList.toString());
			return; 
		}
		
		for(int i=0; i<list.length; i++) {
			if(!pickList.contains(list[i])) {
				pickList.add(list[i]);
				pick(pickCnt+1, pickList);
				pickList.remove(pickList.size()-1);
			}
		}
	}

}
