package coding;

import java.util.Scanner;

public class BreakevenPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A,B,C,day; 
		Scanner scanner = new Scanner(System.in);
		
		A = scanner.nextInt();
		B = scanner.nextInt();
		C = scanner.nextInt();
		
		if(B >= C) {
			System.out.println("-1");
			return;
		}
		
		
		day = (A / (C-B)) + 1;
		
		
		
		System.out.println(day);

	}

}
