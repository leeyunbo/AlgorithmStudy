package string;
/*
 * https://www.acmicpc.net/source/19087271
 * 백준 2675번 문자열 반복 
 * 시간 제한 1초, 메모리 제한 128MB
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class StringRepeat {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		List<StringBuilder> results = new ArrayList<>(n);
		
		for(int i=0; i<n; i++) {
			String[] line = br.readLine().split(" "); 
			int repeat = Integer.parseInt(line[0]);
			StringBuilder result = new StringBuilder();
			for(int j=0; j<line[1].length(); j++) {
				for(int k=0; k<repeat; k++) {
					result.append(line[1].charAt(j));
				}
			}
			results.add(result); 
		}
		
		for(StringBuilder result : results) {
			bw.append(result+"\n");
		}
		
		bw.flush();
		bw.close();
	}

}
