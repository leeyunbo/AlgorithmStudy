package programmers;


/*
 * {2,5,3} --> array중에서 2~5번째 숫자를 선택하여 정렬 생성 
 *                  해당 정렬을 정렬한 후, 3번째 숫자를 선택하여 리턴. 
 *                  [a][0] ~ [a][1] 까지의 숫자를 선택하여 정렬을 생성
 *                  해당 정렬을 정렬한 후, [a][2]번째 숫자를 선택하여 리턴. 
 * 
 */
public class Sortk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3}, 
									 {4,4,1}, 
									 {1,7,3}};
		
		int[] answer;
		
		answer = solution(array, commands);
		
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i]+",");
		}
	}
	
    static int[] solution(int [] array, int[][] commands) {
		int[] answer = new int[commands.length];
		int[] arrayBuffer;
		for(int i=0; i<commands.length; i++) {
			int length = commands[i][1] - commands[i][0];
			int start = commands[i][0]; //2
			int end = commands[i][1]; //5
			if(length == 0) {
				answer[i] = array[start-1];
			}
			else {
				arrayBuffer = new int[length+1]; // start~ end 정렬 담아줄 버퍼 
				int temp = 0;
				for(int j=start-1; j<end; j++) {
					arrayBuffer[temp] = array[j];
					temp++;
				}
				
				int data = sort(arrayBuffer,commands[i][2]);
				
				answer[i] = data;
			}
			
		}	
		
		return answer;
	}
    
    static int sort(int[] arrayBuffer, int data) {
    	int leastIndex;
    	int buffer;
    	int temp;
    	
    	for(int i =0; i<arrayBuffer.length-1; i++) {
    		leastIndex = i;
    		 for(int j=i+1; j<arrayBuffer.length; j++) {
    			 if(arrayBuffer[leastIndex] > arrayBuffer[j]) {
    				 leastIndex = j;
    			 }
    		 }
    		 
    		 if(i != leastIndex) {
    			 buffer = arrayBuffer[i];
    			 arrayBuffer[i] = arrayBuffer[leastIndex];
    			 arrayBuffer[leastIndex] = buffer;
    		 }
    	}
    	
    	
    	
    	return arrayBuffer[data-1];
    	
    	
    }
    
    static int binary_search(int[] arrayBuffer, int data, int start, int end) {
    	int position = 0;
    		if(arrayBuffer[end-start/2] == data) {
    			position =  end-start/2;
    			return position;
    		}
    		
    		if(arrayBuffer[end-start/2] > data) { // median보다 data가 작다면?
    			position = binary_search(arrayBuffer, data, start, end-start/2);
    		} else {
    			position = binary_search(arrayBuffer, data, end-start/2, end);
    		}
    		
    	
    	
    	return position;

    }
	

}
