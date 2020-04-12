package string;
/*
 * https://www.acmicpc.net/problem/2908
 * 백준 2908번 상수 
 * 시간 제한 1초, 메모리 제한 128MB
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class StringReverse {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    String[] line = br.readLine().split(" ");
	    String first = line[0]; 
	    String second = line[1];
	    	    
	    for(int i=first.length()-1; i>=0; i--) {
	    	int firstTemp = Character.getNumericValue(first.charAt(i));
	    	int secondTemp = Character.getNumericValue(second.charAt(i));
	    	if(firstTemp > secondTemp) {
	    		bw.append(reverse(first)); 
	    		break;
	    	}
	    	else if(firstTemp < secondTemp) {
	    		bw.append(reverse(second));
	    		break;
	    	}
	    	else continue;
	    }
	    
	    bw.flush();
	    bw.close();
	}
	
	private static String reverse(String word) {
		Stack<Character> stack = new Stack<>();
		String result = "";
		for(int i=0; i<word.length(); i++) {
			stack.push(word.charAt(i));
		}
		
		for(int j=0; j<word.length(); j++) {
			result+=stack.pop();
		}
		return result;
	}
}
