package coupang;
import java.util.Arrays;
/*
 * deepCopy를 없애도됨, 인자 두개 추가(total, k_total) 
 * 
 */
public class daycheck {
	static int N;
	static int M;
	static int T;
	static int K;
	public static void main(String[] args) {
		N = 4; // 총 일수
		M = 7; //총 소포수
		T = 2; //연속일수
		K = 4; // 연속일간 최대 소포
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
			if(total == M) return 1; // 모든 소포를 배송한 경우 경우의 수 추가 
			else return 0; // 소포를 배송하지 못한 경우
		}
		
		if(day >= T) { // day가 T보다 큰 경우, 즉 T일을 지난 경우 
			for(int i=1; i<T; i++) {
				total += day_k[day-i];
			}
		} else { // 아직 T일이 지나지 않은 경우
			for(int i=1; i<day; i++) {
				total += day_k[day-i];
			}
		}		
		if(total > K) { //만약 total이 K를 넘어섰으면 종료
			return 0;
		}
		for(int i=0; i<=K-total; i++) { // 오늘 소포를 배달할 수 있는 모든 경우의 수, (총 K개 중에 지금까지 배송한 수를 뺀 만큼 가능) O(K-total)
			day_k[day] = i;
			ret += Check(deepCopy(day_k), day+1); //O(N) * O(N) * O(K-total) , 만약 deepCopy를 없애면 O(N) * O(k-total)
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
