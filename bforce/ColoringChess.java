/**
 * https://www.acmicpc.net/problem/1018
 */
package bforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ColoringChess {
	static List<String> chess = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int vertical = Integer.parseInt(line[0]);
		int horizontal = Integer.parseInt(line[1]);
		for(int inputCnt = 0; inputCnt < vertical; inputCnt++) {
			 chess.add(br.readLine());
		}
		
		int minColoring = 654321;
		for(int leftIdx = 0; leftIdx + 7 < vertical; leftIdx++) {
			for(int rightIdx = 0; rightIdx + 7 < horizontal; rightIdx++) {
				minColoring = Math.min(minColoring,coloring(leftIdx,rightIdx));
			}
		}	
		System.out.println(minColoring);
	}
	
	private static int coloring(int leftStartIdx, int rightStartIdx) {
		int coloringCnt = 0;
		int checkleftIdx;
		int checkRightIdx;
		for(int leftIdx = leftStartIdx; leftIdx <= leftStartIdx + 7; leftIdx++) {
			for(int rightIdx = rightStartIdx; rightIdx <= rightStartIdx + 7; rightIdx++) {
				checkleftIdx = leftIdx - leftStartIdx;
				checkRightIdx = rightIdx - rightStartIdx;
				if(checkleftIdx % 2 == 0 && checkRightIdx % 2 == 0) {
					if(chess.get(leftIdx).charAt(rightIdx) != 'W') coloringCnt++;
				}
				else if(checkleftIdx % 2 == 0 && checkRightIdx % 2 != 0) {
					if(chess.get(leftIdx).charAt(rightIdx) != 'B') coloringCnt++;
				}
				else if(checkleftIdx % 2 != 0 && checkRightIdx % 2 == 0) {
					if(chess.get(leftIdx).charAt(rightIdx) != 'B') coloringCnt++;
				}
				else {
					if(chess.get(leftIdx).charAt(rightIdx) != 'W') coloringCnt++;
				}
			}
		}
		
		int secondColoringCnt = 0;
		for(int leftIdx = leftStartIdx; leftIdx <= leftStartIdx + 7; leftIdx++) {
			for(int rightIdx = rightStartIdx; rightIdx <= rightStartIdx + 7; rightIdx++) {
				checkleftIdx = leftIdx - leftStartIdx;
				checkRightIdx = rightIdx - rightStartIdx;
				if(checkleftIdx % 2 == 0 && checkRightIdx % 2 == 0) {
					if(chess.get(leftIdx).charAt(rightIdx) != 'B') secondColoringCnt++;
				}
				else if(checkleftIdx % 2 == 0 && checkRightIdx % 2 != 0) {
					if(chess.get(leftIdx).charAt(rightIdx) != 'W') secondColoringCnt++;
				}
				else if(checkleftIdx % 2 != 0 && checkRightIdx % 2 == 0) {
					if(chess.get(leftIdx).charAt(rightIdx) != 'W') secondColoringCnt++;
				}
				else {
					if(chess.get(leftIdx).charAt(rightIdx) != 'B') secondColoringCnt++;
				}
			}
		}
		return Math.min(coloringCnt, secondColoringCnt);
	}
}
