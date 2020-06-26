package programmers;

public class KakaoNavigation {
	
    static int[][] directions = {{0,1},{1,0}};
    static boolean[][] isMarking; 
    static int MOD = 20170805;
    static int answer;
    static int mM, mN;
    
	public static void main(String[] args) {
		int[][] cityMap = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
		int m = 3;
		int n = 6;
		solution(m, n, cityMap);
		
		System.out.println(answer);

	}
	
	private static int solution(int m, int n, int[][] cityMap) {
	        answer = 0;
	        mM = m;
	        mN = n; 
	        isMarking = new boolean[m][n];
	        
	        isMarking[0][0] = true;
	        DFS(0, 0, 0, cityMap);
	           
	        return answer % 20170805;
	    }
	    
	    
	private static void DFS(int leftIdx, int rightIdx, int direction, int[][] cityMap) {
	        // base-case
	        int temp = cityMap[leftIdx][rightIdx];
	        System.out.print("("+leftIdx+ "," +rightIdx+")");
	        
	        if(leftIdx == mM-1 && rightIdx == mN-1) {
	            answer++;
	            System.out.println(" 도착");
	            return; 
	        }
	        
	        int nextDirection, nextLeftIdx, nextRightIdx;
	        if(temp == 2) {
	            //방향 그대로 직진 
	         	nextLeftIdx = leftIdx + directions[direction][0];
	        	nextRightIdx = rightIdx + directions[direction][1];
	            if(nextLeftIdx >= 0 && nextRightIdx >= 0 && nextLeftIdx < mM && nextRightIdx < mN) {
	            	if(cityMap[nextLeftIdx][nextRightIdx] != 1 && !isMarking[nextLeftIdx][nextRightIdx]) {
		                isMarking[nextLeftIdx][nextRightIdx] = true;
		                DFS(nextLeftIdx, nextRightIdx, direction, cityMap);
		                isMarking[nextLeftIdx][nextRightIdx] = false; 
		            }
	            }
	        }
	        else { 
	        	// 직진 
	        	nextLeftIdx = leftIdx + directions[0][0];
	        	nextRightIdx = rightIdx + directions[0][1];
	            if(nextLeftIdx >= 0 && nextRightIdx >= 0 && nextLeftIdx < mM && nextRightIdx < mN) {
	            	if(cityMap[nextLeftIdx][nextRightIdx] != 1 && !isMarking[nextLeftIdx][nextRightIdx]) {
		                isMarking[nextLeftIdx][nextRightIdx] = true;
		                DFS(nextLeftIdx, nextRightIdx, 0, cityMap);
		                isMarking[nextLeftIdx][nextRightIdx] = false; 
		            }
	            }

	            //우회전 
	            nextLeftIdx = leftIdx + directions[1][0]; 
	            nextRightIdx = rightIdx + directions[1][1]; 
	            
	            if(nextLeftIdx >= 0 && nextRightIdx >= 0 && nextLeftIdx < mM && nextRightIdx < mN) {
	            	if(cityMap[nextLeftIdx][nextRightIdx] != 1 && !isMarking[nextLeftIdx][nextRightIdx]) {
		                isMarking[nextLeftIdx][nextRightIdx] = true;
		                DFS(nextLeftIdx, nextRightIdx, 1, cityMap);
		                isMarking[nextLeftIdx][nextRightIdx] = false; 
		            }
	            }
	        }
	    }
}
