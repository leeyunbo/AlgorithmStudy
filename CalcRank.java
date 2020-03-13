package dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * n���� ���������� ���� ��ȸ�� �����߰� ���� 1������ n������ ��ȣ�� �޾ҽ��ϴ�. 
 * ���� ���� 1��1 ������� ������ �ǰ�, ���� A ������ B �������� �Ƿ��� ���ٸ� A ������ B ������ �׻� �̱�ϴ�.
 *  ������ �־��� ��� ����� ������ �������� ������ �ű�� �մϴ�. ������ ��� ��� ����� �н��Ͽ� ��Ȯ�ϰ� ������ �ű� �� �����ϴ�.
 *  ������ �� n, ��� ����� ���� 2���� �迭 results�� �Ű������� �־��� �� 
 *  ��Ȯ�ϰ� ������ �ű� �� �ִ� ������ ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 *  
 *  ���ѻ���
 *  ������ ���� 1�� �̻� 100�� �����Դϴ�.
 *  ��� ����� 1�� �̻� 4,500�� �����Դϴ�.
 *  results �迭 �� �� [A, B]�� A ������ B ������ �̰�ٴ� �ǹ��Դϴ�.
 *  ��� ��� ������� ����� �����ϴ�.
 *  
 * @author ������
 *
 */
public class CalcRank {
	static int[][] myResults = {{1,2},{2,3},{3,4},{5,6},{6,7},{7,8},{4,5}};
	static int myN = 8;
	static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
	static int[] loseCount;
	static int[] winCount;
	static boolean[] isVisited; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = 0;
		loseCount = new int[myN];
		winCount = new int[myN];
		isVisited = new boolean[myN];
		if(myResults.length == 0) return;
		
		
		//1. ���� ����Ʈ�� �����. 
		for(int i=0; i<myN; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i=0; i<myResults.length; i++) {
			adjList.get(myResults[i][0]-1).add(myResults[i][1]-1);
		}
		
		//2. �й踦 ����Ѵ�.
		for(int i=0; i<myN; i++) {
			CalcLose(i,i);
			isVisited = new boolean[myN];
		}

		//3. �¸��� ����Ѵ�.
		for(int i=0; i<myN; i++) {
			CalcWin(i,i);
			isVisited = new boolean[myN];
		}
		
		
		//3. �¸��� �й踦 ���ؼ� n-1�� ������ ã�� ������ ���̽�, �¸��� ����� ��� ����!   
		//System.out.print(i+1  + "�� ��� : ");
		//System.out.println("�¸� : " + winCount[i] + " �й� : " + loseCount[i]);
		for(int i=0; i<myN; i++) {
			if(loseCount[i] + winCount[i] == (myN-1)) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	private static void CalcLose(int startNode, int rootNode) {
		if(adjList.get(startNode).size() == 0) return;
		// 1. ���� ��忡 �����Ѵ�.
		for(int endNode : adjList.get(startNode)) {
			//2. ���� ���� ��尡 �鸮�� ���� ���̶�� �й� �߰� 
			if(!isVisited[endNode]) {
				loseCount[endNode]++;
				isVisited[endNode] = true;
			}
			CalcLose(endNode, rootNode);
		}
	}
	
	private static void CalcWin(int startNode,int rootNode) {
		if(adjList.get(startNode).size() == 0) return; 
		// 1. ���� ��忡 �����Ѵ�.
		for(int endNode: adjList.get(startNode)) {
			// 2. ���� ���� ��尡 �鸮�� ���� ���̿��ٸ� �¸� �߰�
			if(!isVisited[endNode]) { 
				winCount[rootNode]++;
				isVisited[endNode] = true;
			}
			CalcWin(endNode,rootNode);
		}
		return;
	}

}
