package dfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CalcRankBFS {
	static int[][] myResults = {{4,3},{4,2},{3,2},{1,2},{2,5}};
	static int myN = 5;
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
					CalcLose(i);
					isVisited = new boolean[myN];
				}

				//3. �¸��� ����Ѵ�.
				for(int i=0; i<myN; i++) {
					CalcWin(i,i);
					isVisited = new boolean[myN];
				}
	
		
		
		//3. �¸��� �й踦 ���ؼ� n-1�� ������ ã�� ������ ���̽�, �¸��� ����� ��� ����!   
		for(int i=0; i<myN; i++) {
			System.out.print(i+1  + "�� ��� : ");
			System.out.println("�¸� : " + winCount[i] + " �й� : " + loseCount[i]);
			if(loseCount[i] + winCount[i] == (myN-1)) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	private static void CalcLose(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		while(!queue.isEmpty()) {
			int startNode = queue.poll();
			for(int endNode : adjList.get(startNode)) {
				queue.add(endNode);
				if(!isVisited[endNode]) {
					loseCount[endNode]++;
					isVisited[endNode] = true;
				}
			}
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
