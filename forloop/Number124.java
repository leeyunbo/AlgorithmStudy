// https://programmers.co.kr/learn/courses/30/lessons/12899
// 프로그래머스 124 나라의 숫자 

public class Number124 {
	static String[] numbers = {"4", "1", "2"};
	public static void main(String[] args) {
		int n = 4;
        String answer = "";
        int remainder = 0;
        
        while(n != 0) {
            remainder = n % 3;
            n = n / 3;
            if(remainder == 0) n--; 
            answer = numbers[remainder] + answer; 
        }
 
        System.out.println(answer);
	}
}
