package string;
/*
 * https://www.acmicpc.net/problem/1316
 * 백준 1316번 그룹 단어 체커 
 * 시간 제한 2초, 메모리 제한 128MB
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GroupWordChecker {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		boolean[] isCheck = new boolean['z'-'a'+1];
		int cnt = 0;
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			char before = line.charAt(0);
			Arrays.fill(isCheck,false);
			isCheck[before-'a'] = true;
			cnt++;
			for(int j=1; j<line.length(); j++) {
				char temp = line.charAt(j);
				if(before == temp) continue; 
				else {
					if(isCheck[temp-'a']) {
						cnt-=1;
						break;
					}
					before = temp; 
					isCheck[temp-'a'] = true;
				}
			}
		}	
		System.out.println(cnt);
	}
}
