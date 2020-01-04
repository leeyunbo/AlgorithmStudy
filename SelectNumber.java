import java.util.*;

public class SelectNumber {

	public static void main(String[] args) {
			Stack<Integer> stack = new Stack<Integer>();
			Scanner scanner = new Scanner(System.in);
			int n = scanner.nextInt();
			pick(stack, n, 4);
				

	}
			
	public static void pick(Stack<Integer> stack, int n, int pick ) {
			if(pick == 0) {
				System.out.print("( ");
				for(int i=0; i<stack.size(); i++) {
					System.out.print(stack.get(i)+ " ");
				}
				System.out.print(")");
				System.out.println();
				return;
			}
			
			int smallest = stack.isEmpty() ? 0 : stack.peek() + 1;
				
			for(int i=smallest; i<n; i++) {
					stack.push(i);
					pick(stack, n, pick-1);
					stack.pop();
			}
	}
}
