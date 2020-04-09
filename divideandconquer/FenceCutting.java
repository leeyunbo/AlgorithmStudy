import java.util.Scanner;

public class FenceCutting {
	    static int height[];
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		height = new int[N];
		for(int i=0; i<N; i++) {
			height[i] = scanner.nextInt();
		}
		
		System.out.println(solve(0,height.length-1)); // 분할 정복 
		System.out.println(bruteForce()); // bruteForce
	}
	
	private static int bruteForce() {
		int result = 0;
		int max = 0;
		for(int i=0; i<height.length; i++) {
			int minheight = height[i];
			for(int j=i; j<height.length; j++) {
				if(minheight > height[j]) {
					minheight = height[j];
				}
				int sub = minheight * (j-i+1);
				if(result < sub) {
					result = sub;
				}
			}
		}
		
		return result;
	}
	
	private static int solve(int left, int right) {
		int middle=0,ret=0,low=0,high=0,min_height=0;
		//base-case
		if(left == right) {
			return height[left];
		}
		//왼쪽,오른쪽
		middle = (left+right)/2;
		ret = Math.max(solve(left,middle),solve(middle+1,right));
		//겹치는 부분 
	    low = middle;
		high = middle+1;
		min_height = Math.min(height[low], height[high]); 
		ret = Math.max(ret, min_height*2); //딱 두개만 계산할 경우.
		while(low > left || high < right) {  //그 이상 
			if(low > left && (high == right || height[low-1] > height[high+1])) {
				low--; 
				min_height = Math.min(height[low], min_height);
			}
			else {
				high++;
				min_height = Math.min(height[high], min_height);
			}
			
			ret =  Math.max(ret, min_height*(high-low+1));	
		}
		
		return ret;
	}

}
