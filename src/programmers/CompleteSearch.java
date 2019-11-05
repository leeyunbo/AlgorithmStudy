package programmers;

import java.util.Arrays;

/*
 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

 */
public class CompleteSearch {

	public static void main(String[] args) {
		                                     //5          //3            //1
		int[][] students = {{1,2,3,4,5}, {1,2,3,4,5}, {1,2,3,4,5}};
		int[] student = {0,1,2};
		int[] answers = {1,2,3,4,5};
		int[] studentss = new int[students.length];	
		// TODO Auto-generated method stub
		
		studentss = solution(students, answers);
		
		for(int i=0; i<studentss.length; i++) {
			System.out.print(studentss[i]+",");
		}
		
	

	}
	
	
	public static int[] solution(int[][] students, int[] answers) {
		int[] correctInfo = new int[students.length];// 맞춘 정보 
		int[] answer = new int[students.length]; // 결과 
		int[] buffer;
		int buffers;
		int[] student = {0,1,2};
		int smallest = 0; // 최소 
		// student {0,1,2} 학생 번호 
		
		for(int i=0; i<students.length; i++) {
			correctInfo[i] = countCorrect(students[i],answers);
		}
		
		for(int i=0; i<students.length-1; i++) {
			smallest = i;
			for(int j=i; j<students.length; j++) {
				if(countCorrect(students[smallest], answers) > countCorrect(students[j],answers)) {
					smallest = j;
				}
				
			}
			if(smallest != i) {
				buffer = students[i];
				students[i] = students[smallest];
				students[smallest] = buffer;
				
				buffers = student[i];
				student[i]  = student[smallest];
				student[smallest] = buffers;
				
				buffers = correctInfo[i];
				correctInfo[i] = correctInfo[smallest];
				correctInfo[smallest] = buffers;
			}
			
			
			
			
		}
		

		
		answer = selectBestStudents(student, correctInfo);
		
	
		
		
		return answer;
	}
	
	
	public static int countCorrect(int[] student,int[] answers) {
		int correct = 0;
		for(int i=0; i<answers.length; i++) {
			if(student[i] == answers[i]) {
				correct = correct+1;
			}
		}
		
		return correct;
		
	}
	
	public static int[] selectBestStudents(int[] bestStudent, int[] correctInfo) {
		int[] bestStudents = new int[bestStudent.length];
		int j=1;
		int biggest = correctInfo[bestStudent[bestStudent.length-1]];
		bestStudents[0] = bestStudent[bestStudent.length-1]+1;
		for(int i=bestStudent.length-2; i>=0; i--) {
			if(biggest == correctInfo[i]) {
				bestStudents[j] = bestStudent[i]+1;
				j++;
			}
		}
		
		return bestStudents;
		
	}

}
