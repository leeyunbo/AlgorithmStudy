/*
 * https://www.acmicpc.net/problem/11650
 * 백준 11650번 좌표 정렬하기
 */

package backjoonChanllenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoordinateSort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = 0;
		List<Coordinate> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			String[] line = br.readLine().split(" ");
			list.add(new Coordinate(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
		}
		
		Collections.sort(list);
		
		for(Coordinate cor : list) {
			System.out.println(cor.x + " " + cor.y);
		}
		

	}

}

class Coordinate implements Comparable<Coordinate>{	
	int x,y; 
	
	public Coordinate(int _x, int _y) {
		x = _x;
		y = _y; 
	}
	
	@Override
	public int compareTo(Coordinate target) {
		// TODO Auto-generated method stub
		if(x > target.x) return 1; 
		else if(x < target.x) return -1;
		else {
			if(y > target.y) return 1;
			else if(y < target.y) return -1;
			else return 0;
		}
	}
	
}
