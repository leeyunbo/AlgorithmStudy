package forloop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * n�� �־����� ��, 1���� n���� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * ù° �ٿ� n (1 �� n �� 10,000)�� �־�����.
 */
public class ForEx03 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println((n*(n+1)) / 2);
	}

}
