package programmers;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12979
 * 프로그래머스 기지국 설치
 */

public class StationInstallation {

	public static void main(String[] args) {
		int n = 16;
		int[] stations = {9};
		int w = 1;
		int answer = solution(16, stations, w);
	}
	
	private static int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int last = 1 , start = 0, signal = ( 2 * w ) + 1; 
        
        for(int i=0; i<stations.length; i++) {
            int loc = stations[i]; 
            start = loc-w;
            if(start <= 0) start = 1;
            
            int space = start - last;
            
  
            int minStationCnt = space / signal; 
            if(space % signal > 0) minStationCnt++;
            answer += minStationCnt; 
            
            last = loc+w+1; 
        }
        
        if(last <= n) {
            int space = n - last + 1; 
            int minStationCnt = space / signal; 
            if(space % signal > 0) minStationCnt++;
            answer += minStationCnt; 
        } 
        
        return answer;
    }
}
