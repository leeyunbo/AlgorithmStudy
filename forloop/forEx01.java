package forloop;

import java.util.Scanner;

/*
 * N�� �Է¹��� ��, ������ N���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. ��� ���Ŀ� ���缭 ����ϸ� �ȴ�.
 * ���� 2 * 1 = 2\n 2 * 2 = 4......
 */
public class forEx01 {
	public static void main(String ars[]) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		for(int i=1; i<=9; i++) {
			System.out.println(N+" * "+i+" = "+N*i);
		}
	}
}
