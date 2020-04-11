package array;

/**
 * https://www.acmicpc.net/problem/8958
 * ���� 8958�� OX����
 * �ð� ���� 1��, �޸� ���� 128MB 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OXQuiz {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String OX = ""; 
		char temp;
		int score = 0;
		int[] totals = new int[N];
		for(int i=0; i<N; i++) {
			OX = br.readLine(); 
			totals[i] = 0;
			score = 0;
			for(int j=0; j<OX.length(); j++) {
				temp = OX.charAt(j);
				if(temp == 'O') {
					score++;
					totals[i] += score;
				}
				else {
					score = 0;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			System.out.println(totals[i]);
		}
	}
}
