package algorithmbook;

import java.util.ArrayList;

/*
 * n���� ���ڰ� ���� ��, x���� �����͸� pick�ϴ� ����� ���� ����Ͻÿ�. 
 * ���� : ��� ȣ���� ����� �� 
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
