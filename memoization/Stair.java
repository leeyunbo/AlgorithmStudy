package memoization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * ��� ������ ������ ��� �Ʒ� ���������� ��� ����⿡ ��ġ�� ���������� ���� �����̴�. 
 * ������ ��ܿ��� ������ ������ ���� �ִµ� ����� ������ �� ��ܿ� ���� �ִ� ������ ��� �ȴ�.
 *���� ��� <�׸� 2>�� ���� �������������� ù ��°, �� ��°, �� ��°, ���� ��° ����� ��� �������� 
 *�����ϸ� �� ������ 10 + 20 + 25 + 20 = 75���� �ȴ�. ��� ������ ���� ������ ���� ��Ģ�� �ִ�.

����� �� ���� �� ��ܾ� �Ǵ� �� ��ܾ� ���� �� �ִ�. ��, �� ����� �����鼭 �̾ ���� ����̳�, ���� ���� ������� ���� �� �ִ�.
���ӵ� �� ���� ����� ��� ��Ƽ��� �� �ȴ�. ��, �������� ��ܿ� ���Ե��� �ʴ´�.
������ ���� ����� �ݵ�� ��ƾ� �Ѵ�.
���� ù ��° ����� ��� �̾� �� ��° ����̳�, �� ��° ������� ���� �� �ִ�. ������, ù ��° ����� ��� �̾� �� ��° ������� �ö󰡰ų�, ù ��°, �� ��°, �� ��° ����� �����ؼ� ��� ���� ���� ����.

�� ��ܿ� ���� �ִ� ������ �־��� �� �� ���ӿ��� ���� �� �ִ� �� ������ �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
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
