package bforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class RollDice {
	static LinkedList<Integer> directions = new LinkedList<>();
	static final int left = 0, right = 1, top = 2, bottom = 3, front = 4, back = 5;
	static int[] dice = new int[6]; 
	static int[][] map; 
	static int x = 0, y = 0, n = 0, m = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int k = 0; 
		
		String[] line = br.readLine().split(" ");  
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		x = Integer.parseInt(line[2]);
		y = Integer.parseInt(line[3]);
		k = Integer.parseInt(line[4]);
		
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			line = br.readLine().split(" "); 
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		line = br.readLine().split(" ");
		for(int i=0; i<k; i++) {
			directions.add(Integer.parseInt(line[i]));
		}
		
		paint();
		while(!directions.isEmpty()) {
			int[] buffer;
			buffer = moveDice(directions.pollFirst());
			if(buffer != null) {
				dice = buffer; 
				paint();
				bw.write(dice[top]+"\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	private static void paint() {
		if(map[x][y] == 0) {
			map[x][y] = dice[bottom]; 
			
		}
		else {
			dice[bottom] = map[x][y];
			map[x][y] = 0;
		}
	}
	
	private static int[] moveDice(int direction) {
		int[] newDice = new int[6]; 
		switch (direction) {
		case 1: //오른쪽
			if(y + 1 >= m) return null; 
			moveLeft(newDice);
			y += 1;
			break;
		case 2: // 왼쪽
			if(y - 1 < 0) return null;
			moveRight(newDice);
			y -= 1;
			break;
		case 3: // 앞
			if(x - 1 < 0) return null;
			moveFront(newDice);
			x -= 1;
			break;
		case 4: // 뒤
			if(x + 1 >= n) return null;
			moveBack(newDice);
			x += 1;
		}
		
		return newDice; 
		
	}
	
	private static void moveLeft(int[] newDice) {
		newDice[top] = dice[right]; 
		newDice[bottom] = dice[left]; 
		newDice[right] = dice[bottom]; 
		newDice[left] = dice[top];
		newDice[front] = dice[front];
		newDice[back] = dice[back];
	}
	
	private static void moveRight(int[] newDice) {
		newDice[top] = dice[left]; 
		newDice[bottom] = dice[right]; 
		newDice[right] = dice[top]; 
		newDice[left] = dice[bottom];
		newDice[front] = dice[front];
		newDice[back] = dice[back];
	}
	
	private static void moveFront(int[] newDice) {
		newDice[top] = dice[back]; 
		newDice[bottom] = dice[front]; 
		newDice[right] = dice[right]; 
		newDice[left] = dice[left];
		newDice[front] = dice[top]; 
		newDice[back] = dice[bottom]; 
	}
	
	private static void moveBack(int[] newDice) {
		newDice[top] = dice[front]; 
		newDice[bottom] = dice[back]; 
		newDice[right] = dice[right]; 
		newDice[left] = dice[left];
		newDice[back] = dice[top]; 
		newDice[front] = dice[bottom];
	}
}
