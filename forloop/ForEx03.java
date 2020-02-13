package forloop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
 * 첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.
 */
public class ForEx03 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println((n*(n+1)) / 2);
	}

}
