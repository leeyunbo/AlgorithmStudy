package dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다. 
 * 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다. 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.
 * 노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때, 
 * 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한사항
 * 노드의 개수 n은 2 이상 20,000 이하입니다.
 * 간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
 * vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.
 * 
 * 문제 자체의 로직은 굉장히 간단하지만 메모리 오버플로우 때문에 굉장히 고생한 문제이다.
 * 처음에는 단순히 인접행렬로 문제를 풀어나갔고, 8번,9번을 제외한 테스트 데이터에 대해서는 성공을 했다.
 * 하지만 8번,9번이 대략 20000개 정도의 테스트 데이터가 입력이 되게 되는데 그 순간 메모리가 터지는 상황이 발생했다.
 * 그리고 직접 실험해본 결과, programmers에서 C++ 같은 경우는 인덱스를 20000정도로 둬도 메모리 오버플로우가 터지지 않았지만
 * JAVA는 인덱스를 20000으로 초기화 하는 순간 메모리 오버플로우가 터지는 것을 확인했다.
 * 다음 부터 수많은 데이터가 들어온다는 제한사항이 존재한다면 무조건 인접리스트로 문제를 해결해야겠다.
 * 
 * @author yunbok
 *
 */
public class FarNodeCount {
	static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static int[] distanceList;
    static boolean[] isVisited;
    static int nodeCount;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int n = 6;
		 int edge[][] = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		 int answer = 0;
	     int max = 0;
	     int ch = 0;
	     nodeCount = n;
	     distanceList = new int[n];
	     isVisited = new boolean[n];
	     Arrays.fill(isVisited, false);
	     
	     for(int i=0; i<edge.length; i++) 
	            adjList.add(new ArrayList<>());

	     for(int i=0; i<edge.length; i++) {
	          adjList.get(edge[i][0]-1).add(edge[i][1]-1);
	          adjList.get(edge[i][1]-1).add(edge[i][0]-1);
	     }

	     max = calcDistance();
	        
	     for(int i=1; i<distanceList.length; i++) {
	           if(max == distanceList[i]) {
	               answer++;
	           }
	           if(distanceList[i] == 0) {
	               ch++;
	           }
	     }
	        
	     if(ch != 0) System.out.println(ch);
	     else System.out.println(answer);
	
	}
	
	  private static int calcDistance() {
	        Queue<Integer> queue = new LinkedList<>();
	        queue.add(0);
	        isVisited[0] = true;
	        distanceList[0] = 0;
	        int max = 0;
	        while(!queue.isEmpty()) {
	            int startNode = queue.poll();
	            for(int i : adjList.get(startNode)) {
	                if(!isVisited[i]) {
	                    queue.add(i);
	                    isVisited[i] = true;
	                    distanceList[i] = distanceList[startNode]+1;
	                    if(distanceList[i] > max) 
	                        max = distanceList[i];
	                }
	            }               
	        }
	        return max;
	    }
}
