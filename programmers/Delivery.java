package programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12978#qna
 * 프로그래머스 배달
 */

import java.util.*;

public class Delivery {
	
	 static boolean[] isChecked;
	 static Vertex[] vertexs;
	 static List<List<Edge>> adjList;
	 static final int INF = 654321;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 private static int solution(int N, int[][] road, int K) {
	        int answer = 0;
	        
	        isChecked = new boolean[N+1]; 
	        vertexs = new Vertex[N+1]; 
	        adjList = new ArrayList<>();
	        
	        for(int i=1; i<=N; i++) {
	            if(i == 1) vertexs[i] = new Vertex(i, 0);
	            else vertexs[i] = new Vertex(i, INF);
	        }
	        
	        for(int i=0; i<=N; i++) {
	            adjList.add(new ArrayList<>());
	        }
	        
	        for(int i=0; i<road.length; i++) {
	            List<Edge> tempList = adjList.get(road[i][0]);
	            tempList.add(new Edge(road[i][2], road[i][1]));
	            adjList.get(road[i][1]).add(new Edge(road[i][2], road[i][0]));
	        }
	        
	        dijkstra(1);
	        
	        for(int i=1; i<=N; i++) {
	            if(vertexs[i].weight <= K) {
	                answer++;
	            } 
	        }
	    
	        return answer;
	    }
	    
	 private static void dijkstra(int start) {
	        PriorityQueue<Vertex> queue = new PriorityQueue<>();
	      
	        queue.add(vertexs[start]); 
	        
	        while(!queue.isEmpty()) {
	            // 가장 가까운 노드를 가져온다.
	            Vertex startVertex = queue.poll();
	            isChecked[startVertex.num] = true;
	            
	            // 가져온 노드와 이어진 노드들의 weight이 갱신 시켜줄 값보다 크다면 최신화 시켜준다.
	            List<Edge> tempList = adjList.get(startVertex.num); 
	            
	            for(Edge edge : tempList) {
	                System.out.println("start : " + startVertex.num + "," +edge.toString());
	                int newWeight = startVertex.weight + edge.weight;
	                int oldWeight = vertexs[edge.aim].weight; 
	                vertexs[edge.aim].weight = Math.min(newWeight, oldWeight);
	                
	                
	                 // 이어진 노드들을 queue에 추가한다. (이미 기점이 되었던 노드는 추가하지 않는다)
	                if(vertexs[edge.aim].weight != oldWeight && !isChecked[edge.aim]) {
	                    queue.remove(vertexs[edge.aim]);
	                    queue.add(vertexs[edge.aim]);
	                }
	            }
	        }
	    }
}


class Edge {
    int weight; 
    int aim; 
    
    public Edge(int _weight,int _aim) {
        weight = _weight;
        aim = _aim; 
    }
    
    public String toString() {
        return "[ weight : "+weight+", aim : "+aim+"]";
    }
}


class Vertex implements Comparable<Vertex> {
    int num; 
    int weight; 
    
    public Vertex(int _num, int _weight) {
        num = _num;
        weight = _weight; 
    }
    
    @Override
    public String toString() {
        return "[ num : " + num + ", weight : " + weight + "]";
    }
    
    @Override
    public int compareTo(Vertex o1) {
        if(o1 instanceof Vertex) {
            if(weight < o1.weight) return -1;
            else if(weight > o1.weight) return 1;
            else return 0;
        }
        
        return 0;
    }
}
