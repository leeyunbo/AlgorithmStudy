package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Backjoon 14888�� 
 * ���� ���� �̷���� ���� A1, A2, ..., AN�� �־�����. 
 * ��, ���� �� ���̿� �������� �� �ִ� N-1���� �����ڰ� �־�����. 
 * �����ڴ� ����(+), ����(-), ����(��), ������(��)���θ� �̷���� �ִ�.
 * �츮�� ���� �� ���̿� �����ڸ� �ϳ��� �־, ������ �ϳ� ���� �� �ִ�. 
 * �̶�, �־��� ���� ������ �ٲٸ� �� �ȴ�.
 * 
 * ���� ���, 6���� ���� �̷���� ������ 1, 2, 3, 4, 5, 6�̰�, �־��� �����ڰ� ����(+) 2��, ����(-) 1��, ����(��) 1��, ������(��) 1���� ��쿡�� �� 60������ ���� ���� �� �ִ�. 
 * ���� ���, �Ʒ��� ���� ���� ���� �� �ִ�.
 * 
 * 1+2+3-4��5��6
 * 1��2+3+4-5��6
 * 1+2��3��4-5+6
 * 1��2��3-4+5+6
 * 
 * ���� ����� ������ �켱 ������ �����ϰ� �տ������� �����ؾ� �Ѵ�. 
 * ��, �������� ���� ���������� �� ���Ѵ�. 
 * ������ ����� ���� ���� C++14�� ������ ������. 
 * ��, ����� �ٲ� �� ���� ���ϰ�, �� ���� ������ �ٲ� �Ͱ� ����. 
 * �̿� ����, ���� �� 4���� ����� ����غ��� �Ʒ��� ����.
 * 
 * 1+2+3-4��5��6 = 1
 * 1��2+3+4-5��6 = 12
 * 1+2��3��4-5+6 = 5
 * 1��2��3-4+5+6 = 7
 * 
 * N���� ���� N-1���� �����ڰ� �־����� ��, ���� �� �ִ� ���� ����� �ִ��� �Ͱ� �ּ��� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * @author serve
 *
 */
public class InsertOperator {
	static final int MAX = 1000000000;
	static final int MIN = -1000000000;
	static int[] numbers;
	static int[] operandCount = new int[4];
	static int N;
	static int maxResult = MIN;
	static int minResult = MAX;
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
			
			numbers = new int[N]; 
			String[] numbersBuffer = br.readLine().split(" ");
			for(int i=0; i<numbersBuffer.length; i++) {
				numbers[i] = Integer.parseInt(numbersBuffer[i]);
			}
			
			String[] operandBuffer = br.readLine().split(" ");
			for(int i=0; i<operandBuffer.length; i++) {
				operandCount[i] = Integer.parseInt(operandBuffer[i]);
			}
		} catch(IOException e) {
			System.out.println("�Է� ����");
			e.printStackTrace();
		} finally {
			br.close();
		}
		
		InsertOperatorFunc(new StringBuilder());
		System.out.println(maxResult);
		System.out.println(minResult);
		
	}
	
	private static void InsertOperatorFunc(StringBuilder operands) {
		//1. ���� numberIndex == N-1, ������ ���ڸ� �ְ� ���� ��� => base-case
		if(operands.length() == N-1) {
			CalcStringExpression(operands);
			return;
		}
		
		//2. ������ operand�� ���� ��� ����� ���� �����Ѵ�. => recursion-case 
		for(int i=0; i<operandCount.length; i++) {
			if(operandCount[i] > 0) {
				operandCount[i]--;
				InsertOperatorFunc(operands.append(ReturnOperand(i)));
				operandCount[i]++;
			}	
		}
	}
	
	private static String ReturnOperand(int index) {
		switch(index) {
			case 0:
				return "+";
			case 1:
				return "-";
			case 2:
				return "*";
			case 3:
				return "/";
			default:
				return "";
		}
	}
	
	private static void CalcStringExpression(StringBuilder operands) {
		int result = 0;
		char operand = 0;
		// ������ ����Ѵ�. 
		result = numbers[0]; 
		for(int i=0; i<operands.length(); i++) {
				operand = operands.charAt(i); 
				result = Calc(result, numbers[i+1],operand);
		}
		
		if(maxResult < result)
			maxResult = result;
		if(minResult > result)
			minResult = result;
	}
	
	private static int Calc(int result, int number, char op) {
		switch(op) {
			case '+' :
				return result + number;
			case '-' :
				return result - number;
			case '*' :
				return result * number;
			case '/' :
				return result / number;
			default :
				return 0;
		}
	}

}
