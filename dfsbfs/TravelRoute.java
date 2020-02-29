package dfsbfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * �־��� �װ����� ��� �̿��Ͽ� �����θ� ¥���� �մϴ�. �׻� ICN ���׿��� ����մϴ�.
 * �װ��� ������ ��� 2���� �迭 tickets�� �Ű������� �־��� ��, 
 * �湮�ϴ� ���� ��θ� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
��� ������ ���ĺ� �빮�� 3���ڷ� �̷�����ϴ�.
�־��� ���� ���� 3�� �̻� 10,000�� �����Դϴ�.
tickets�� �� �� [a, b]�� a ���׿��� b �������� ���� �װ����� �ִٴ� �ǹ��Դϴ�.
�־��� �װ����� ��� ����ؾ� �մϴ�.
���� ������ ��ΰ� 2�� �̻��� ��� ���ĺ� ������ �ռ��� ��θ� return �մϴ�.
��� ���ø� �湮�� �� ���� ���� �־����� �ʽ��ϴ�.

 * @author ����
 *
 */
public class TravelRoute {
	static String[][] ticket = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"},{"ATL","ICN"},{"ATL","SFO"}};
	static LinkedList<List<String>> routes = new LinkedList<>();
	static Stack<String> route = new Stack<>();
	static HashMap<String,ArrayList<String>> ticketMap = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<ticket.length; i++) {
			String start = ticket[i][0];
			String end = ticket[i][1];
			if(ticketMap.containsKey(start)) {
				ticketMap.get(ticket[i][0]).add(ticket[i][1]);
			}
			else {
				ticketMap.put(ticket[i][0], new ArrayList<>());
				ticketMap.get(ticket[i][0]).add(ticket[i][1]);
			}
		}
		route.add("ICN");
		makeRoute("ICN");
		List<String> result = routes.get(0);
		for(int i=1; i<routes.size(); i++) {
			List<String> temp = routes.get(i);
			result = selectRoute(result,temp);
		}
		System.out.println(result.toString());
	}
	
	private static void makeRoute(String start) {
		if(route.size() == (ticket.length+1)) {
			routes.add(deepCopy());
			return;
		}
		
		if(route.size() != ticket.length) {
			if(!ticketMap.containsKey(start)) {
				return;
			}
		}
		
		for(int i=ticketMap.get(start).size()-1; i>=0; i--) {
			String node = ticketMap.get(start).get(i);
			route.push(node);
			ticketMap.get(start).remove(node);
			makeRoute(node);
			ticketMap.get(start).add(node);
			route.pop();
		}
	}
	
	private static List<String> deepCopy() {
		List<String> realRoute = new ArrayList<>();
		for(int i=0; i<route.size(); i++) {
			realRoute.add(route.get(i));
		}
		return realRoute;
	}
	
	private static List<String> selectRoute(List<String> a, List<String> b) {
		for(int i=0; i<a.size(); i++) {
			String aWord = a.get(i);
			String bWord = b.get(i);
			int result = aWord.compareTo(bWord);
			if(result < 0) return a; 
			if(result > 0) return b;
			if(result == 0) continue;
		}
		return a;
	}
	


}
