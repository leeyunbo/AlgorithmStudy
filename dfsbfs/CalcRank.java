package dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * n명의 권투선수가 권투 대회에 참여했고 각각 1번부터 n번까지 번호를 받았습니다. 
 * 권투 경기는 1대1 방식으로 진행이 되고, 만약 A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이깁니다.
 *  심판은 주어진 경기 결과를 가지고 선수들의 순위를 매기려 합니다. 하지만 몇몇 경기 결과를 분실하여 정확하게 순위를 매길 수 없습니다.
 *  선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때 
 *  정확하게 순위를 매길 수 있는 선수의 수를 return 하도록 solution 함수를 작성해주세요.
 *  
 *  제한사항
 *  선수의 수는 1명 이상 100명 이하입니다.
 *  경기 결과는 1개 이상 4,500개 이하입니다.
 *  results 배열 각 행 [A, B]는 A 선수가 B 선수를 이겼다는 의미입니다.
 *  모든 경기 결과에는 모순이 없습니다.
 *  
 * @author 이윤복
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
		
		
		//1. 인접 리스트를 만든다. 
		for(int i=0; i<myN; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i=0; i<myResults.length; i++) {
			adjList.get(myResults[i][0]-1).add(myResults[i][1]-1);
		}
		
		//2. 패배를 계산한다.
		for(int i=0; i<myN; i++) {
			CalcLose(i,i);
			isVisited = new boolean[myN];
		}

		//3. 승리를 계산한다.
		for(int i=0; i<myN; i++) {
			CalcWin(i,i);
			isVisited = new boolean[myN];
		}
		
		
		//3. 승리와 패배를 더해서 n-1이 나오면 찾기 성공한 케이스, 승리는 연결된 노드 갯수!   
		//System.out.print(i+1  + "번 노드 : ");
		//System.out.println("승리 : " + winCount[i] + " 패배 : " + loseCount[i]);
		for(int i=0; i<myN; i++) {
			if(loseCount[i] + winCount[i] == (myN-1)) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	private static void CalcLose(int startNode, int rootNode) {
		if(adjList.get(startNode).size() == 0) return;
		// 1. 인접 노드에 접근한다.
		for(int endNode : adjList.get(startNode)) {
			//2. 만약 현재 노드가 들리지 않은 곳이라면 패배 추가 
			if(!isVisited[endNode]) {
				loseCount[endNode]++;
				isVisited[endNode] = true;
			}
			CalcLose(endNode, rootNode);
		}
	}
	
	private static void CalcWin(int startNode,int rootNode) {
		if(adjList.get(startNode).size() == 0) return; 
		// 1. 인접 노드에 접근한다.
		for(int endNode: adjList.get(startNode)) {
			// 2. 만약 현재 노드가 들리지 않은 곳이였다면 승리 추가
			if(!isVisited[endNode]) { 
				winCount[rootNode]++;
				isVisited[endNode] = true;
			}
			CalcWin(endNode,rootNode);
		}
		return;
	}

}
