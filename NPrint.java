package coding;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class NPrint {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = scanner.nextInt();
		
		for(int i=1; i<=N; i++) {
			bw.write(i+"\n");
		}
		
		bw.close();
		
	}

}
