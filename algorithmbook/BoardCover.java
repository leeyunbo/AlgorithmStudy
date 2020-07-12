package algorithmbook;
/*
 * algospot.com 
 * ID : BOARDCOVER 풀이 
 * 이 문제는 굉장히 무난해서 수월하게 해결하였음
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BoardCover {
	
	static int[][][] coverType = {
			{{0,0}, {1,0}, {0,1}}, 
			{{0,0}, {0,1}, {1,1}}, 
			{{0,0}, {1,0}, {1,1}}, 
			{{0,0}, {1,0}, {1,-1}}};
	
	static char[][] gameBoard;
	
	static int answer = 0;
	static int aim = 0;
	static int H = 0, W = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] idxs;
		String line;
		int testCaseCnt = 0, spaceCnt = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		testCaseCnt = Integer.parseInt(br.readLine());		
		for(int i=0; i<testCaseCnt; i++) {
			idxs = br.readLine().split(" ");
			H = Integer.parseInt(idxs[0]);
			W = Integer.parseInt(idxs[1]);
			gameBoard = new char[H][W]; 
			
			for(int j=0; j<H; j++) {
				line = br.readLine(); 
				for(int k=0; k<line.length(); k++) {
					gameBoard[j][k] = line.charAt(k);
					if(gameBoard[j][k] == '.') spaceCnt++; 
				}
			}
			
			boolean isFinish = false;
			if(spaceCnt % 3 == 0) {
				aim = spaceCnt / 3;
				for(int j=0; j<H; j++) {
					for(int k=0; k<W; k++) {
						if(gameBoard[j][k] == '.') {
							cover(j,k,0);
							isFinish = true;
							break;
						}
					}
					if(isFinish) break;
				}
			}
			
			bw.write(answer + "\n");
			answer = aim = 0;
		}
		
		bw.flush();
	}
	
	private static void cover(int leftIdx, int rightIdx, int cnt) {
		//base - case
		if(cnt == aim) {
			answer++;
			return; 
		}
		
		if(leftIdx < 0 || rightIdx < 0 || leftIdx >= H || rightIdx >= W) return; 
		
		if(gameBoard[leftIdx][rightIdx] == '#') {
			if(rightIdx == W - 1) cover(leftIdx+1, 0, cnt); 
			else cover(leftIdx, rightIdx + 1, cnt); 
			return;
		}
		
		for(int i=0; i<coverType.length; i++) {
			int[] firstBlock = {leftIdx + coverType[i][0][0], rightIdx + coverType[i][0][1]}; 
			int[] secondBlock = {leftIdx + coverType[i][1][0], rightIdx + coverType[i][1][1]}; 
			int[] thirdBlock = {leftIdx + coverType[i][2][0], rightIdx + coverType[i][2][1]}; 
			
			if(firstBlock[0] < 0 || firstBlock[1] < 0 || firstBlock[0] >= H || firstBlock[1] >= W) continue;
			if(secondBlock[0] < 0 || secondBlock[1] < 0 || secondBlock[0] >= H || secondBlock[1] >= W) continue;
			if(thirdBlock[0] < 0 || thirdBlock[1] < 0 || thirdBlock[0] >= H || thirdBlock[1] >= W) continue;
			
			if(gameBoard[firstBlock[0]][firstBlock[1]] == '#' || gameBoard[secondBlock[0]][secondBlock[1]] == '#' || gameBoard[thirdBlock[0]][thirdBlock[1]] == '#') 
				continue;
			
			gameBoard[firstBlock[0]][firstBlock[1]] = gameBoard[secondBlock[0]][secondBlock[1]] = gameBoard[thirdBlock[0]][thirdBlock[1]] = '#';
			if(rightIdx == W - 1) cover(leftIdx+1, 0, cnt + 1); 
			else cover(leftIdx, rightIdx + 1, cnt + 1); 
			gameBoard[firstBlock[0]][firstBlock[1]] = gameBoard[secondBlock[0]][secondBlock[1]] = gameBoard[thirdBlock[0]][thirdBlock[1]] = '.';
		}
		
	}

}
