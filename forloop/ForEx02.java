package forloop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

/*
 * �� ���� A�� B�� �Է¹��� ����, A+B�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����.
 * �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� ������, �� �ٿ� A�� B�� �־�����. (0 < A, B < 10)
 */
public class ForEx02 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		int N = Integer.parseInt(br.readLine());
		LinkedList<String[]> list = new LinkedList<>();
		for(int i=0; i<N; i++) {
			String buffer = br.readLine();
			list.add(buffer.split(" "));
		}
		
		for(int i=0; i<N; i++) {
			String[] buffer = list.poll();
			bw.write("Case #"+(i+1)+": "+buffer[0]+" + "+buffer[1]+" = "+(Integer.parseInt(buffer[0]) + Integer.parseInt(buffer[1])+"\n"));
			bw.flush();
		}
		
	}

}
