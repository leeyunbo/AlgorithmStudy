package dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * n���� ��尡 �ִ� �׷����� �ֽ��ϴ�. �� ���� 1���� n���� ��ȣ�� �����ֽ��ϴ�. 
 * 1�� ��忡�� ���� �ָ� ������ ����� ������ ���Ϸ��� �մϴ�. ���� �ָ� ������ ���� �ִܰ�η� �̵����� �� ������ ������ ���� ���� ������ �ǹ��մϴ�.
 * ����� ���� n, ������ ���� ������ ��� 2���� �迭 vertex�� �Ű������� �־��� ��, 
 * 1�� ���κ��� ���� �ָ� ������ ��尡 �� �������� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * ���ѻ���
 * ����� ���� n�� 2 �̻� 20,000 �����Դϴ�.
 * ������ ������̸� �� 1�� �̻� 50,000�� ������ ������ �ֽ��ϴ�.
 * vertex �迭 �� �� [a, b]�� a�� ���� b�� ��� ���̿� ������ �ִٴ� �ǹ��Դϴ�.
 * 
 * ���� ��ü�� ������ ������ ���������� �޸� �����÷ο� ������ ������ ����� �����̴�.
 * ó������ �ܼ��� ������ķ� ������ Ǯ�����, 8��,9���� ������ �׽�Ʈ �����Ϳ� ���ؼ��� ������ �ߴ�.
 * ������ 8��,9���� �뷫 20000�� ������ �׽�Ʈ �����Ͱ� �Է��� �ǰ� �Ǵµ� �� ���� �޸𸮰� ������ ��Ȳ�� �߻��ߴ�.
 * �׸��� ���� �����غ� ���, programmers���� C++ ���� ���� �ε����� 20000������ �ֵ� �޸� �����÷ο찡 ������ �ʾ�����
 * JAVA�� �ε����� 20000���� �ʱ�ȭ �ϴ� ���� �޸� �����÷ο찡 ������ ���� Ȯ���ߴ�.
 * ���� ���� ������ �����Ͱ� ���´ٴ� ���ѻ����� �����Ѵٸ� ������ ��������Ʈ�� ������ �ذ��ؾ߰ڴ�.
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
