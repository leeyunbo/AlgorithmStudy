package recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
 * 첫째 줄에 정수 N(0 ≤ N ≤ 12)가 주어진다.
 * 첫째 줄에 N!을 출력한다.
 */
public class RecursionEx01 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		bw.write((String.valueOf(factorial(n)))+"\n");
		bw.flush();

	}
	private static int factorial(int n) {
		if(n <= 1) return 1;
		return n * factorial(n-1);
	}
}
