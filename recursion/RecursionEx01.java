package recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 0���� ũ�ų� ���� ���� N�� �־�����. �̶�, N!�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * ù° �ٿ� ���� N(0 �� N �� 12)�� �־�����.
 * ù° �ٿ� N!�� ����Ѵ�.
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
