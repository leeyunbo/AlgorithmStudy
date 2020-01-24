package memoization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * 계단 오르기 게임은 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임이다. 
 * 각각의 계단에는 일정한 점수가 쓰여 있는데 계단을 밟으면 그 계단에 쓰여 있는 점수를 얻게 된다.
 *예를 들어 <그림 2>와 같이 시작점에서부터 첫 번째, 두 번째, 네 번째, 여섯 번째 계단을 밟아 도착점에 
 *도달하면 총 점수는 10 + 20 + 25 + 20 = 75점이 된다. 계단 오르는 데는 다음과 같은 규칙이 있다.

계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
마지막 도착 계단은 반드시 밟아야 한다.
따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.

각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.
 */
public class Stair {
	static final int UNINF = -123456;
	static int[] stair_list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int cache[][] = new int[N][3];
		for(int i=0; i<cache.length; i++) {
			Arrays.fill(cache[i], -1);
		}
		stair_list = new int[N];
		for(int i=0; i<N; i++) {
			stair_list[i] = Integer.parseInt(bf.readLine());
		}
		
		System.out.println(Math.max(stair(0,1,cache), stair(1,1,cache)));

	}
	
	private static int stair(int index, int seq, int[][] cache) {
		int ret = 0;
		if(seq == 3) return UNINF;
		if(index >= stair_list.length) return UNINF;
		
		ret = stair_list[index];
		if(index == stair_list.length-1) return ret;      //base case
		
		if(cache[index][seq] != -1) return cache[index][seq]; //check cache

		ret += Math.max(stair(index+1,seq+1,cache), stair(index+2,1,cache)); 
		return cache[index][seq] = ret;
	}

}
