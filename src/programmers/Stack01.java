package programmers;
import java.util.*;
import java.lang.Math;

public class Stack01 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer_list = new ArrayList<Integer>(); // 정답 
        Queue<Integer> queue = new LinkedList<Integer>(); // 남은 일 수를 담을 queue 
        
        for(int i=0; i<progresses.length; i++) {
            queue.add(((100 - progresses[i])/speeds[i]));
        }
        
        int temp = queue.poll();
        int count = 1;
        int buffer = 0;
        int index = 0;
        
        while(true) {
            buffer = queue.poll();
            if(temp >= buffer) {
                count++;
            }
            else {
                temp = buffer;
                answer_list.add(count);
                index++;
                count = 1;           
            }
            if(queue.size() == 0) {
                answer_list.add(count);
                break;            
            }
        }
        
        
        int[] answer = new int[answer_list.size()]; 
        
        for(int i=0; i<answer_list.size(); i++) {
            answer[i] = answer_list.get(i);
        }

        return answer;
    }
}


