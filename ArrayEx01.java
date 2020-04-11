package array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * ���л� ��������� 90%�� �ڽ��� �ݿ��� ����� �Ѵ´ٰ� �����Ѵ�. ����� �׵鿡�� ���� ������ �˷���� �Ѵ�.
 * ù° �ٿ��� �׽�Ʈ ���̽��� ���� C�� �־�����.
 * ��° �ٺ��� �� �׽�Ʈ ���̽����� �л��� �� N(1 �� N �� 1000, N�� ����)�� ù ���� �־�����, 
 * �̾ N���� ������ �־�����. ������ 0���� ũ�ų� ����, 100���� �۰ų� ���� �����̴�.
 * �� ���̽����� �� �پ� ����� �Ѵ� �л����� ������ �ݿø��Ͽ� �Ҽ��� ��° �ڸ����� ����Ѵ�.
 */
public class ArrayEx01 {
	static int[] nList;
	static double[] averageList;
	static LinkedList<ArrayList<Integer>> scoreLists = new LinkedList<>();
	static LinkedList<Double> resultList = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		nList = new int[N];
		averageList = new double[N];

		for(int i=0; i<N; i++) {
			String buffer = br.readLine(); //������ �о�´�.
			String[] parser = buffer.split(" "); //parser.
			nList[i] = Integer.parseInt(parser[0]); //�� ������ ���� ������ �޾ƿ���.
			ArrayList<Integer> scoreList = new ArrayList<>();//���� ������ ���� ArrayList ���� 
			int total = 0;	 // ���� ������ ���� ����
			for(int j=0; j<nList[i]; j++) {
				int score = Integer.parseInt(parser[j+1]);
				scoreList.add(score);
				total += score;
			}
			scoreLists.add(scoreList);
			averageList[i] = total/nList[i];
		} //��� �� ���� 
		
		for(int i=0; i<N; i++) {
			ArrayList<Integer> scoreList = scoreLists.get(i);
			int cnt = 0;
			for(int j=0; j<nList[i]; j++) {
				if(scoreList.get(j) > averageList[i])
					cnt++;
			}
			System.out.format("%.3f",(float)cnt/nList[i]*100);
			System.out.println("%");
		} //���� �� ����
	}
}
