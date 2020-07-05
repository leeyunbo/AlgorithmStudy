package function;
/*
 * https://www.acmicpc.net/problem/4673
 * 백준 4673번 셀프 넘버
 */

public class ChainFunction {
	static boolean[] isHavingConstructor = new boolean[10001]; 
	public static void main(String[] args) {
		for(int i=1; i<=10000; i++) {
			if(isHavingConstructor[i] == false) D(i, true);
		}
		
		for(int i=1; i<=10000; i++) {
			if(isHavingConstructor[i] == false) {
				System.out.println(i);
			}
		}

	}
	
	private static void D(int n, boolean isFirst) {
		if(n > 10000 || isHavingConstructor[n] == true) return;
		
		int result = n;
		if(!isFirst) isHavingConstructor[n] = true; 

		String buffer = String.valueOf(n); 
		
		for(int i=0; i<buffer.length(); i++) {
			result += (buffer.charAt(i) - '0');
		}

		D(result,false);
	}
}
