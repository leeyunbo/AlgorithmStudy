package coding;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class starPrint {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = scanner.nextInt();
		String[][] list = new String[N][N];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(list[i]," ");
			for(int j=0; j<=i; j++) {
				list[i][N-j-1] = "*";
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				bw.write(list[i][j]);
			}
			bw.write("\n");
		}
		
		bw.close();

	}

}
