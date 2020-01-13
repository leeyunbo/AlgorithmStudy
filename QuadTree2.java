import java.util.Scanner;

public class QuadTree2 {
	static String compressed;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		compressed = scanner.nextLine();
		System.out.println(reverse());
	}
	
	private static String reverse() {
		char head = compressed.charAt(0);
		if(head =='w' || head =='b') {
			return String.valueOf(head);
		}
			
		compressed = compressed.substring(1);
		String upperLeft = reverse();
		compressed = compressed.substring(1);
		String upperRight = reverse();
		compressed = compressed.substring(1);
		String lowerLeft = reverse();
		compressed = compressed.substring(1);
		String lowerRight = reverse();
		
		return "x" + lowerLeft + lowerRight + upperLeft + upperRight;
		
		
		
	}

}
