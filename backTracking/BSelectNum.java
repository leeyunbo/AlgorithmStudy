import java.util.LinkedList;
import java.util.Scanner;

public class BSelectNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		
		LinkedList<Integer> pick_list = new LinkedList<Integer>();
		boolean[] isSelect = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			isSelect[i] = false;
		}
		
		pick(N, isSelect, M, pick_list);
		
	}
	
	public static void pick(int N,boolean[] isSelect, int pick, LinkedList<Integer> pick_list) {
		if(pick == 0) {
			for(int i=0; i<pick_list.size(); i++) {
				if(i < pick_list.size()-1) {
					System.out.print(pick_list.get(i)+ " ");
				} else {
					System.out.print(pick_list.get(i));
				}
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(isSelect[i]) continue;
			pick_list.add(i);
			isSelect[i] = true;
			pick(N,isSelect,pick-1,pick_list);
			pick_list.pollLast();
			isSelect[i] = false;		
		}
	}

}
