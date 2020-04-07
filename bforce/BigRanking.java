/**
 * https://www.acmicpc.net/problem/7568 
 */
package bforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BigRanking {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Human> humans = new ArrayList<>(N);
		int[] result = new int[N];
		
		for(int inputCnt=0; inputCnt<N; inputCnt++) {
			String[] line = br.readLine().split(" ");
			humans.add(new Human(line[0],line[1]));
		}
		
		for(int person = 0; person<N; person++) {
			Human temp = humans.get(person);
			for(int otherPerson = person+1; otherPerson<N; otherPerson++) {
				if(temp.height < humans.get(otherPerson).height 
						&& temp.weight < humans.get(otherPerson).weight) {
					result[person]++;
				}
				else if(temp.height > humans.get(otherPerson).height 
						&& temp.weight > humans.get(otherPerson).weight) {
					result[otherPerson]++;
				}
			}
		}
		
		for(int resultIdx = 0; resultIdx<N; resultIdx++) {
			System.out.print(result[resultIdx]+1 + " ");
		}
	}
}

class Human {
	int height; 
	int weight; 
	Human(String _weight, String _height) {
		height = Integer.parseInt(_height); 
		weight = Integer.parseInt(_weight); 
	}
}
