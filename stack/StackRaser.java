package stack;

import java.util.Stack;

public class StackRaser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*괄호 체크 스택, "(" 만 들어감*/
		Stack<Character> inputStack = new Stack();
		Stack<Integer> rasorStack = new Stack();
		String arrangement = "()(((()())(())()))(())";	
		int result = 0; // 잘린 철근 갯수 
		int rasor = 0; // 현재 레이저 갯수 
		int bar = 0; //현재 쇠막대기 갯수
		
		for(int i=0; i<arrangement.length(); i++) {
			char data = arrangement.charAt(i);
			char before_data;
			if(data == '(') {
				inputStack.push(data);
			} 
			else { // ')' 인 경우
				before_data = arrangement.charAt(i-1);
				if(before_data == '(') { //rasor 인 경우  
					if(inputStack.size() == 1) {  // 만약 bar가 아예 없다면 계산할 필요가 없음
						inputStack.pop();
						continue;
					}
					for(int j=0; j<rasorStack.size(); j++) {
						rasorStack.set(j, rasorStack.get(j)+1);
					}
					int loopCnt = inputStack.size() - rasorStack.size() -1;
					if(inputStack.size()-1 > rasorStack.size()) {
						for(int k=0; k<loopCnt; k++) {
							rasorStack.push(1);
						}
					}
					inputStack.pop();
				}
				else { //bar인 경우 
					rasor = rasorStack.pop();
					result += rasor + 1;
					inputStack.pop();
				}
			}
		}
		
		System.out.println(result);
		// ( 넣고 바로 ) 이게 나오면, 그건 레이저, 레이저 갯수를 추가 시킨다. 
		// 그 외에는, 쇠막대기 갯수를 추가 시킨다. 
		// 철근이 레이저를 포함해야함.
		// 만약 철근에 대해 ) 이게 나오면, 레이저 갯수 + 1을 총 쇠막대기 수에 추가시킨다.
	}

}
