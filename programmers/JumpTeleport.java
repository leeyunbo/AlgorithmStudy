package programmers;

import java.util.Scanner;
/*
 * https://programmers.co.kr/learn/courses/30/lessons/12980
 * 프로그래머스 점프와 순간 이동 
 */
public class JumpTeleport {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		solution(n);

	}
	
    private static int solution(int n) {
        int ans = 0;
        
        while(n != 0) {
            ans += n % 2;
            n = n - (n % 2);
            n = n / 2;
        }
        
        return ans;
    }

}
