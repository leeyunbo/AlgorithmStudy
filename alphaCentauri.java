package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class alphaCentauri {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(bf.readLine());
		String[] split_data = new String[2];
		List<Integer> result = new ArrayList<Integer>();
		
		for(int i=0; i<count; i++) { 
			String data = bf.readLine();
			split_data = data.split(" ");
			SpaceShip spaceShip = new SpaceShip(Integer.parseInt(split_data[0]),Integer.parseInt(split_data[1]));
			result.add(spaceShip.calData(spaceShip.x,spaceShip.y));
		}
		
		
		for(int i=0; i<count; i++) {
			System.out.println(result.get(i));
		}
	}

}

class SpaceShip {
	int x,y;
	int distance;
	SpaceShip(int x, int y) {
		this.x = x;
		this.y = y;
		this.distance = y-x;
	}
	
	boolean calSigma(int k, int distance) {
		if(distance-k >= ((k-1)*(k))/2) {
			return true;
		}
		return false;
	}
	
	int calData(int x, int y) {
		int distance = this.distance - 2;
		int half_distance = distance / 2;
		int k = 2; // 이동 거리
		int d_count = 2; // 일 수 카운트
		
		if(this.distance == 4 || this.distance == 3) {
			return 3;
		}
		if(this.distance == 2) {
			return 2;
		} 
		
		if(this.distance == 1) {
			return 1;
		}
		
		
		while(true) {
			if(half_distance == 0 || half_distance < k) {
				break;
			}
			
			half_distance -= k;
			k++;
			d_count++;
		}
		
		half_distance = half_distance + distance / 2 + distance % 2;
		while(true) {
			if(calSigma(k,half_distance)) {
				half_distance -= k;
			}
			d_count++;
			
			if(half_distance == 0) {
				return d_count;
			}
			
			k--;
			
			if(k == 1) {
				d_count += half_distance;
				return d_count;
			}
			
		}
		
	}
}
