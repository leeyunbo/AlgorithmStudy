package programmers;
import java.util.*;

public class CuttingBar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p = {0,1,5,8,9,10,17,17,20,24,30};
		
		CutRod cutRod = new CutRod(5, p);
		CutRodMemorize cutRodMemorize = new CutRodMemorize(5, p);
		CutRodBottomUp cutRodBottomUp = new CutRodBottomUp(5,p);
		System.out.println(cutRod.Cutting(cutRod.n));
		System.out.println(cutRodMemorize.Memorize());
		System.out.println(cutRodBottomUp.Cutting(cutRodBottomUp.n));
	}

}

class CutRod {
	int n; 
	int[] p; 
	
	CutRod(int n, int[] p) {
		this.n = n;
		this.p = p;
	}
	
	public int Cutting(int n) {
		int q = 0;
		if(n == 0) return 0;
		for(int i = 1; i <= n; i++) {
			q = Math.max(q, p[i] + Cutting(n-i));
		}
		
		return q;
	}
	
}

class CutRodMemorize {
	int n;
	int[] p;
	int[] r;
	
	CutRodMemorize(int n, int[] p) {
		this.n = n;
		this.p = p;
		this.r = new int[n + 1];
	}
	
	public int Memorize() {
		
		for(int i = 0; i <= n; i++) {
			r[i] = 0;
		} // 초기화
		return Cutting(n);
	}
	
	public int Cutting(int n) {
		int q = 0;
		if(r[n] != 0) return r[n]; //이미 계산이 완료된 부분이다.
		if(n == 0) return 0; // n == 0이면 계산이 완전히 종료
		else {
			for(int i = 1; i <= n; i++) {
				q = Math.max(q,p[i] +  Cutting(n-i));
			}
		}
		r[n] = q; // r[9], 계산이 완료된 값을 넣어주는것. 
		return q;
	}
	
}

class CutRodBottomUp {
	
	int n;
	int[] r;
	int[] p;
	
	CutRodBottomUp(int n, int[] p) {
		this.n = n;
		this.p = p;
		this.r = new int[n+1];
	}
	
	public int Cutting(int n) {
		int q = 0;
		r[0] = 0;
		
		for(int j = 1; j <= n; j++) { 
			for(int i = 1; i <= j; i++) {
				q = Math.max(q,  p[i] + r[j - i]); 
			}
			r[j] = q;
		}
		
		return r[n];
		
	}
	
	
	
}
