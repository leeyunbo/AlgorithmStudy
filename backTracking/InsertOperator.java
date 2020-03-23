package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Backjoon 14888번 
 * 개의 수로 이루어진 수열 A1, A2, ..., AN이 주어진다. 
 * 또, 수와 수 사이에 끼워넣을 수 있는 N-1개의 연산자가 주어진다. 
 * 연산자는 덧셈(+), 뺄셈(-), 곱셈(×), 나눗셈(÷)으로만 이루어져 있다.
 * 우리는 수와 수 사이에 연산자를 하나씩 넣어서, 수식을 하나 만들 수 있다. 
 * 이때, 주어진 수의 순서를 바꾸면 안 된다.
 * 
 * 예를 들어, 6개의 수로 이루어진 수열이 1, 2, 3, 4, 5, 6이고, 주어진 연산자가 덧셈(+) 2개, 뺄셈(-) 1개, 곱셈(×) 1개, 나눗셈(÷) 1개인 경우에는 총 60가지의 식을 만들 수 있다. 
 * 예를 들어, 아래와 같은 식을 만들 수 있다.
 * 
 * 1+2+3-4×5÷6
 * 1÷2+3+4-5×6
 * 1+2÷3×4-5+6
 * 1÷2×3-4+5+6
 * 
 * 식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행해야 한다. 
 * 또, 나눗셈은 정수 나눗셈으로 몫만 취한다. 
 * 음수를 양수로 나눌 때는 C++14의 기준을 따른다. 
 * 즉, 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다. 
 * 이에 따라서, 위의 식 4개의 결과를 계산해보면 아래와 같다.
 * 
 * 1+2+3-4×5÷6 = 1
 * 1÷2+3+4-5×6 = 12
 * 1+2÷3×4-5+6 = 5
 * 1÷2×3-4+5+6 = 7
 * 
 * N개의 수와 N-1개의 연산자가 주어졌을 때, 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램을 작성하시오.
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
			System.out.println("입력 에러");
			e.printStackTrace();
		} finally {
			br.close();
		}
		
		InsertOperatorFunc(new StringBuilder());
		System.out.println(maxResult);
		System.out.println(minResult);
		
	}
	
	private static void InsertOperatorFunc(StringBuilder operands) {
		//1. 만약 numberIndex == N-1, 마지막 숫자를 넣고 값을 계산 => base-case
		if(operands.length() == N-1) {
			CalcStringExpression(operands);
			return;
		}
		
		//2. 가능한 operand에 대해 모든 경우의 수를 수행한다. => recursion-case 
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
		// 수식을 계산한다. 
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
