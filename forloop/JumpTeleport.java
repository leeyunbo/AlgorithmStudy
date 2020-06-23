package programmers;

import java.util.Scanner;

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
