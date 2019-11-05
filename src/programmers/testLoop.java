package programmers;

public class testLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] List = {"1"};
		String[] List2;
		
		List2 = List;
		
		System.out.println(List.length);
		
		for(int i = 0; i < 1; i++) {
			System.out.println(i);
		}
		
		List[0] = "2";
		
		System.out.println(List2[0]);
		
		

	}

}
