/*
 * https://programmers.co.kr/learn/courses/30/lessons/12977
 * 프로그래머스 소수 만들기 
 */
public class CreatePrime {

	public static void main(String[] args) {
		int[] nums = {1,2,7,6,4};
        int answer = 0;
        
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k]; 
                    if(isPrimeNumber(num)) answer++;
                }
            }
        }
	}
	
    private static boolean isPrimeNumber(int num) {
        for(int i = num/2; i>1; i--) {
            if(num % i == 0) return false;
        }
        
        return true;
    }

}
