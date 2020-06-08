package lambda;

public class LambdaPractice {

	public static void main(String[] args) {
		MaxFunction func = (a,b) -> a > b ? a : b;
		MaxFunction func1 = new MaxFunction() {
			@Override
			public int max(int a, int b) {
				return a > b ? a : b;
			}
		};
		
		System.out.println(func.max(3,4));
		System.out.println(func1.max(3, 4));

	}
}

@FunctionalInterface
interface MaxFunction {
	int max(int a, int b);
}
