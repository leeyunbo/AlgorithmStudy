import java.util.*;
/*
 * https://programmers.co.kr/learn/courses/30/lessons/49994
 * 프로그래머스 방문 길이 
 */
public class DetectDistance {
	static boolean[][] map = new boolean[12][12];
	public static void main(String[] args) {
		String dirs = "LR"; 
		int answer = 0;
		
		List<Line> lines = new ArrayList<>();
		Vertex temp = new Vertex(0, 0);
		
		for(int i=0; i<dirs.length(); i++) {
			char dir = dirs.charAt(i); 
			Vertex next = move(dir, temp); 
			if(next == null) {
				continue; 
			}
			else {
				Line line = new Line(temp.x, temp.y, next.x, next.y); 
				if(!lines.contains(line)) {
					lines.add(line); 
					answer++;
				}
			}			
			temp = next; 
		}
		
		System.out.println(lines.toString());
		System.out.println(answer);
		
	}
	
	private static Vertex move(char dir, Vertex temp) {
		int x = temp.x;
		int y = temp.y; 
		//U : 위쪽 
		//D : 아래쪽
		//R : 오른쪽
		//L : 왼쪽 
		switch(dir) {
			case 'U':
				if(x + 1 > 5) return null;
				x++; 
				break;
			case 'D':
				if(x - 1 < -5) return null;
				x--;
				break;
			case 'R':
				if(y + 1 > 5) return null;
				y++;
				break;
			case 'L':
				if(y - 1 < -5) return null; 
				y--; 
		}
		
		return new Vertex(x, y);
	}

}

class Line {
	int startX, startY, endX, endY; 
	
	public Line(int _startX, int _startY, int _endX, int _endY) {
		startX = _startX;
		startY = _startY;
		endX = _endX;
		endY = _endY;
	}
	
	@Override
	public boolean equals(Object o) {
		Line target;
		if(o instanceof Line) {
			target = (Line) o;
			if(startX == target.startX && startY == target.startY && endX == target.endX && endY == target.endY)
				return true;
			
			if(startX == target.endX && startY == target.endY && endX == target.startX && endY == target.startY)
				return true; 
		}
		
		return false;
	}
	
	@Override 
	public String toString() {
		return "{("+startX+","+startY+")"+ "("+endX+","+endY+")}";
	}
}

class Vertex {
	int x, y;
	
	public Vertex(int _x, int _y) {
		x = _x;
		y = _y;
	}
}
