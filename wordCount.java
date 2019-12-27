package coding;

import java.util.Scanner;

public class wordCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();
		String[] words = word.split(" ");
		
		count = words.length;
		
		
		if(count > 0 && words[0].equals("")) {
			count--;
		}
		if(count > 0 && words[words.length-1].equals("")) {
			count--; 
		}
		System.out.println(count);
	}

}
