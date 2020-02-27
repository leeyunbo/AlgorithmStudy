package dfsbfs;

public class TargetNumber {
	static int[] nums = {1,1,1,1,1};
	static int targetNumber = 3;
	public static void main(String[] args) {
		int answer = targetNumber(0, 0);
		System.out.println(answer);
	}
	
	private static int targetNumber(int num, int count) {
		int ret = 0;
		
		if(count == nums.length) {
			if(num == targetNumber) 
				return 1;
			else 
				return 0;
		}
		
		ret += targetNumber(num + nums[count], count + 1);
		ret += targetNumber(num - nums[count], count + 1);
		
		return ret;
	}

}
