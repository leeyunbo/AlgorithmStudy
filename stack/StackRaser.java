package stack;

import java.util.Stack;

public class StackRaser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*��ȣ üũ ����, "(" �� ��*/
		Stack<Character> inputStack = new Stack();
		Stack<Integer> rasorStack = new Stack();
		String arrangement = "()(((()())(())()))(())";	
		int result = 0; // �߸� ö�� ���� 
		int rasor = 0; // ���� ������ ���� 
		int bar = 0; //���� �踷��� ����
		
		for(int i=0; i<arrangement.length(); i++) {
			char data = arrangement.charAt(i);
			char before_data;
			if(data == '(') {
				inputStack.push(data);
			} 
			else { // ')' �� ���
				before_data = arrangement.charAt(i-1);
				if(before_data == '(') { //rasor �� ���  
					if(inputStack.size() == 1) {  // ���� bar�� �ƿ� ���ٸ� ����� �ʿ䰡 ����
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
				else { //bar�� ��� 
					rasor = rasorStack.pop();
					result += rasor + 1;
					inputStack.pop();
				}
			}
		}
		
		System.out.println(result);
		// ( �ְ� �ٷ� ) �̰� ������, �װ� ������, ������ ������ �߰� ��Ų��. 
		// �� �ܿ���, �踷��� ������ �߰� ��Ų��. 
		// ö���� �������� �����ؾ���.
		// ���� ö�ٿ� ���� ) �̰� ������, ������ ���� + 1�� �� �踷��� ���� �߰���Ų��.
	}

}
