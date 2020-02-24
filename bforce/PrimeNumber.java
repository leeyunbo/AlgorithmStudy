package bforce;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * ���ڸ� ���ڰ� ���� ���� ������ ������ֽ��ϴ�. 
 * ����� ���� ������ �ٿ� �Ҽ��� �� �� ���� �� �ִ��� �˾Ƴ��� �մϴ�.
 * �� ���� ������ ���� ���ڰ� ���� ���ڿ� numbers�� �־����� ��, 
 * ���� �������� ���� �� �ִ� �Ҽ��� �� ������ return �ϵ��� solution �Լ��� �ϼ����ּ���.
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
