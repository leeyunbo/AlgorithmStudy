package mathematical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ACMHotel {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		int X = 0;
		int Y = 0;
		for(int i=0; i<n; i++) {
			String[] line = br.readLine().split(" "); 
			int H = Integer.parseInt(line[0]); //층 
			int W = Integer.parseInt(line[1]); //한층에 몇개
			int N = Integer.parseInt(line[2]); //몇번째 
			
			//1.몇 번째 방인지 구한다.
			Y = N / H;
			if(N % H > 0) Y +=1; 
			
			
			//2. 몇 층인지 구한다. 
			int start = H * (Y-1) + 1; 
			X = (N - start) + 1; 
			
			bw.write(String.format("%d%02d\n", X,Y));
		}
		
		bw.flush();
		bw.close();
	}
}
