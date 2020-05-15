package bforce;
/*
 * https://www.acmicpc.net/problem/14501
 * ���� 14501�� ��� 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeaveCompany {
	static List<ArrayList<Integer>> list = new ArrayList<>();
	static int n;
	static int result = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<>());
		}
		
		//line[0] : T, line[1] : P 
		//list.get(i).get(0) : T, get(1) : P 
		String[] line;
		for(int i=1; i<=n; i++) {
			line = br.readLine().split(" ");
			list.get(i).add(Integer.parseInt(line[0]));
			list.get(i).add(Integer.parseInt(line[1]));
			
		}
		
		bestSelect(0, 1);
		System.out.println(result);
		
		
	}
	
	static void bestSelect(int beforeCost, int dayToPossible) {
		int cost = 0;
		// base-case 
		if(dayToPossible > n) return;
		
		// recursion-case
		// ���� ������ �ϼ��� ������ 
		// dayToPossible ���� ũ�ų� ���� 
		// ���õ� �ϼ� + list.get(���õ��ϼ�).get(0) �� n���� ���ų� �۾ƾ� �� 
		for(int i = dayToPossible; i <= n; i++) {
			if(i + list.get(i).get(0) > n+1) continue; 
			
			cost = beforeCost + list.get(i).get(1);
			result = Math.max(result, cost);
			bestSelect(cost, i + list.get(i).get(0));
			cost = 0;
		}
	}
}
