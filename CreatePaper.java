package divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// blue : 1, white : 0 
// https://www.acmicpc.net/problem/2630
public class CreatePaper {
	private static final int WHITE = 0;
	private static final int BLUE = 1;
	private static final int NONECOLOR = 2;
	private static int[][] paper;
	private static int blueCnt = 0;
	private static int whiteCnt = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for(int i=0; i<N; i++) {
			String[] buffer = br.readLine().split(" "); 
			for(int j=0; j<buffer.length; j++) {
				paper[i][j] = Integer.parseInt(buffer[j]);
			}
		}

		
		createFunc(0, 0, N);
		System.out.println(whiteCnt);
		System.out.println(blueCnt);

	}
	
	
	private static void createFunc(int HorStartIdx, int VerStartIdx, int length) {
		//Base - case
		int color = checkFinish(HorStartIdx,VerStartIdx,length);
		if(color != NONECOLOR) {
			checkColor(color);
			return;
		}
		
		// Recursion - case
		int HorEndIdx = HorStartIdx + length/2;
		int VerEndIdx = VerStartIdx + length/2;
		
		//1. 왼쪽위
		createFunc(HorStartIdx,VerStartIdx,length/2);
		//2. 오른쪽위
		createFunc(HorEndIdx,VerStartIdx,length/2);
		//3. 왼쪽아래
		createFunc(HorStartIdx,VerEndIdx,length/2);
		//4. 오른쪽아래
		createFunc(HorEndIdx,VerEndIdx,length/2);
	}
	
	private static int checkFinish(int HorStartIdx, int VerStartIdx, int length) {
		int expectColor = paper[VerStartIdx][HorStartIdx];

		if(length == 1) {
			return expectColor;
		}
		
		for(int i=VerStartIdx; i<VerStartIdx+length; i++) {
			for(int j=HorStartIdx; j<HorStartIdx+length; j++) {
				if(!(paper[i][j] == expectColor)) {
					return NONECOLOR;
				}
			}
		}

		return expectColor;
	}
	
	private static void checkColor(int color) {
		switch(color) {
			case BLUE :
				blueCnt++;
				break;
			case WHITE :
				whiteCnt++;
				break;
		}
	}

}
