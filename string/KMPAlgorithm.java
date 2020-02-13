package string;
import java.util.*;
public class KMPAlgorithm {
	static char N[] = {'a'};
	static char H[] = {'a','a','b','a','a','b','a','c'};
	static int pi[];
	static List list = new ArrayList();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pi = new int[N.length];
		KMP();
		System.out.println(list.toString());
	}
	
	private static void KMP() {
		int ret = 0;
		int n = H.length; int m = N.length;
		P();
		int begin = 0; int matched = 0;
		while(begin <= n-m) { //�ݺ��Ѵ�. 
			if(matched < m && H[begin + matched] == N[matched]) { //���� ������ 
				matched++;  //matched ++
				if(matched == m) { //��� ������ ������ġ �߰�
					list.add(begin);
				}
			} else { //�ٸ��� 
				begin += matched - pi[matched - 1]; //������ġ�� �������ش�. 
				matched  = pi[matched -1]; //
			}
		}
	}
	
	private static void P() {
		int m = N.length;
		for(int begin =1; begin < m; begin++) {
			for(int i=0; i+begin<m; i++) {
				if(N[begin+i] != N[i]) break;
				pi[begin+i] = Math.max(pi[begin + i], i+1);
			}
		}
		return;
	}

}
