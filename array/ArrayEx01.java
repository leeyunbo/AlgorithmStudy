package array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * 대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.
 * 첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
 * 둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 
 * 이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
 * 각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
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
			String buffer = br.readLine(); //한줄을 읽어온다.
			String[] parser = buffer.split(" "); //parser.
			nList[i] = Integer.parseInt(parser[0]); //한 라인의 점수 갯수를 받아오고.
			ArrayList<Integer> scoreList = new ArrayList<>();//한줄 점수를 받을 ArrayList 선언 
			int total = 0;	 // 한줄 총점을 담을 변수
			for(int j=0; j<nList[i]; j++) {
				int score = Integer.parseInt(parser[j+1]);
				scoreList.add(score);
				total += score;
			}
			scoreLists.add(scoreList);
			averageList[i] = total/nList[i];
		} //평균 다 구함 
		
		for(int i=0; i<N; i++) {
			ArrayList<Integer> scoreList = scoreLists.get(i);
			int cnt = 0;
			for(int j=0; j<nList[i]; j++) {
				if(scoreList.get(j) > averageList[i])
					cnt++;
			}
			System.out.format("%.3f",(float)cnt/nList[i]*100);
			System.out.println("%");
		} //비율 다 구함
	}
}
