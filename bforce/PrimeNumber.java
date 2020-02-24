package bforce;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 
 * 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 
 * 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 * @author serve
 *
 */
public class PrimeNumber {
	static String input_numbers="1010";
	static boolean[] selected;
	static ArrayList<String> prime_number = new ArrayList<>(10000);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = 0;
		selected = new boolean[input_numbers.length()];
		Arrays.fill(selected,false);
		answer = searchPrimeNumber("");
		System.out.println(answer);
	}
	
	private static int searchPrimeNumber(String tempNumber) {
		int ret = 0;
		boolean isPrimeNumber = true;
		if(prime_number.contains(tempNumber)) return 0;
		if(tempNumber.length() != 0)  {
			if(tempNumber.charAt(0) == '0') return 0;
			int number = Integer.parseInt(tempNumber); //number type converts
			
			for(int i=2; i<=number/2; i++) {    // prime Check 
				if(number%i == 0) {
					isPrimeNumber = false;
					break;
				}
			}
			
			if(isPrimeNumber == true && number >= 2)  {     //prime Check 
				prime_number.add(tempNumber);
				System.out.println(tempNumber);
				ret = 1;
			}
			if(tempNumber.length() == input_numbers.length()) {   //base-case
				return ret;
			}
		}
		
		for(int i=0; i<input_numbers.length(); i++) {
			if(selected[i] == false) {
				selected[i] = true;
				ret += searchPrimeNumber(tempNumber+input_numbers.charAt(i));
				selected[i] = false;
			}
		}
		return ret;
	}

}
