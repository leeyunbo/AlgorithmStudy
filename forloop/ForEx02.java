package forloop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

/*
 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
 * 각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
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
