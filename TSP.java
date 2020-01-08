import java.util.LinkedList;

public class TSP {
	static int n = 5;
	static final int INF = 123456;
	static int dist[][] = {
			{0,3,4,5,6}, 
			{3,0,2,1,3}, 
			{4,2,0,4,3}, 
			{5,1,4,0,4}, 
			{6,3,3,4,0} };
		

	public static void main(String[] args) {
		LinkedList<Integer> path = new LinkedList<Integer>();
		boolean[] visited = {true,false,false,false,false};
		path.add(0);
		System.out.println(tsp(0, path, visited));
		

	}
	
	public static int tsp(int currentLength, LinkedList<Integer> path, boolean[] visited) {
		int ret = INF;
		
		if(path.size() == n) { // 다시 출발지로 복귀
			return currentLength + dist[path.peekFirst()][path.peekLast()];  
		}
		
		for(int i=0; i<n; i++) {
			if(visited[i]) {
				continue;
			}
			int here = path.peekLast();
			path.add(i);
			visited[i] = true;
			int now = tsp(currentLength + dist[here][i], path, visited);
			if(ret > now) {
				ret = now;
			}
			path.pollLast();
			visited[i] = false;
		}
		
		
		return ret;
	}

}
