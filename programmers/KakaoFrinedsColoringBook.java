package programmers;
/*
 * https://programmers.co.kr/learn/courses/30/lessons/1829#qna
 * 프로그래머스 카카오프렌즈 컬러링북 
 */
public class KakaoFrinedsColoringBook {
	
	static int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static boolean[][] isMarking; 
    static int numberOfArea, maxSizeOfOneArea, tempSizeOfOneArea;

	public static void main(String[] args) {
		int[][] picture = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
		int m = 6;
		int n = 4;
		solution(6, 4, picture);
	}
    
    private static int[] solution(int m, int n, int[][] picture) {
        isMarking = new boolean[m][n]; 
        numberOfArea = 0; 
        maxSizeOfOneArea = 0; 
        tempSizeOfOneArea = 0;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!isMarking[i][j] && picture[i][j] > 0) {
                    DFS(i, j, picture); 
                    numberOfArea++; 
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, tempSizeOfOneArea);
                    tempSizeOfOneArea = 0;
                }
            }
        }
        
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    private static void DFS(int startLeftIdx, int startRightIdx, int[][] picture) {
        // Marking
        isMarking[startLeftIdx][startRightIdx] = true; 
        tempSizeOfOneArea++; 
        
        // recursion-case
        for(int i=0; i<directions.length; i++) {
            int nextLeftIdx = startLeftIdx + directions[i][0];
            int nextRightIdx = startRightIdx + directions[i][1]; 
            
            if(nextLeftIdx < 0 || nextRightIdx < 0 || nextLeftIdx >= isMarking.length || nextRightIdx >= isMarking[0].length)
                continue; 
            
            if(!isMarking[nextLeftIdx][nextRightIdx] && (picture[startLeftIdx][startRightIdx] == picture[nextLeftIdx][nextRightIdx])) 
                DFS(nextLeftIdx, nextRightIdx, picture); 
        }
        
    }

}
