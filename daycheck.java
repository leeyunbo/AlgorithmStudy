package coupang;
import java.util.Arrays;
/*
 * deepCopy�� ���ֵ���, ���� �ΰ� �߰�(total, k_total) 
 * 
 */
public class daycheck {
	static int N;
	static int M;
	static int T;
	static int K;
	public static void main(String[] args) {
		N = 4; // �� �ϼ�
		M = 7; //�� ������
		T = 2; //�����ϼ�
		K = 4; // �����ϰ� �ִ� ����
		int[] list = new int[M];
		Arrays.fill(list, 0);
		System.out.println(Check(deepCopy(list),1));
	}
	private static int Check(int[] day_k,int day) {
		int ret = 0;
		int total = 0;
		
		if(day > N) { 
			for(int i=0; i<day_k.length; i++) {
				total += day_k[i];
			}
			if(total == M) return 1; // ��� ������ ����� ��� ����� �� �߰� 
			else return 0; // ������ ������� ���� ���
		}
		
		if(day >= T) { // day�� T���� ū ���, �� T���� ���� ��� 
			for(int i=1; i<T; i++) {
				total += day_k[day-i];
			}
		} else { // ���� T���� ������ ���� ���
			for(int i=1; i<day; i++) {
				total += day_k[day-i];
			}
		}		
		if(total > K) { //���� total�� K�� �Ѿ���� ����
			return 0;
		}
		for(int i=0; i<=K-total; i++) { // ���� ������ ����� �� �ִ� ��� ����� ��, (�� K�� �߿� ���ݱ��� ����� ���� �� ��ŭ ����) O(K-total)
			day_k[day] = i;
			ret += Check(deepCopy(day_k), day+1); //O(N) * O(N) * O(K-total) , ���� deepCopy�� ���ָ� O(N) * O(k-total)
			day_k[day] = 0;
		}
		return ret;
	}
	
	private static int[] deepCopy(int[] list) {
		int[] list2 = new int[list.length];
		for(int i=0; i<list.length; i++)
			list2[i] = list[i];
		
		return list2;
	}

}
