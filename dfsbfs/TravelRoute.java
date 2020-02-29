package dfsbfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 ICN 공항에서 출발합니다.
 * 항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 
 * 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
모든 공항은 알파벳 대문자 3글자로 이루어집니다.
주어진 공항 수는 3개 이상 10,000개 이하입니다.
tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
주어진 항공권은 모두 사용해야 합니다.
만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.

 * @author 윤복
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
