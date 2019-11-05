package programmers;

/* 일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄, 중요한 문서가 나중에 인쇄가 되는 문제가 발생할 수 있음 
 * 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발하였음 
 * 1. 인쇄 대기목록의 가장 앞에 있는 문서를 대기목록에서 꺼냄  ->> FO 
 * 2. 나머지 인쇄 대기목록에서 이 문서보다 중요도가 높은 문서가 한개라도 존재하면 꺼낸 문서를 다시 가장 마지막에 넣음 >> LI 
 * 3. 만약 중요도가 높은 문서가 존재하지 않는다면 그냥 그대로 인쇄
 * 4. Input : 우선순위 리스트, 내가 인쇄하고 싶은 문서의 위치 Output : 인쇄하고 싶은 문서가 인쇄된 순서  
 * LIFO --> Stack을 이용하여 구현 
 */
public class StackPrinter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int buffer = 0;
		int[] priorities = {2,1,3,2};
		int location = 2;
		int cnt = 0;
		

		
		Stack stack = new Stack(priorities);
		while(stack.size > 0) {
		
	    buffer = stack.pop(); // 1322-> 3222
	    
		if(stack.check(buffer)) {
			System.out.println(buffer);
		}
		else {
			stack.push(buffer);
		}
		System.out.println(priorities[0] +" " + priorities[1] +" " +  priorities[2] +" " + priorities[3]);
	}
		
	
	}
}

class Stack {
	private int[] stackbuffer;
	int top;
	int bottom;
	int size;
	
	public Stack(int[] stackbuffer) {
		this.stackbuffer = stackbuffer;
		this.top = stackbuffer.length-1;
		this.size = stackbuffer.length;
		this.bottom = 0;
	}
	public void push(int buffer) {
		stackbuffer[top] = buffer;
		size = size + 1;
	}
	
	public int pop() {
		int data = 0;
		data = stackbuffer[bottom]; // data = 1
		delete(); // 1 3 2 2
		return data; // return 1
		
	}
	
	public void delete() {
		for (int i = 0; i < size - 1; i++) {
			stackbuffer[i] = stackbuffer[i+1];
		}
		stackbuffer[size-1] = 0;
		size = size - 1;
	}
	
	public int getLocation() {
		int location = 0;
		
		return location;
		
	}
	
	public boolean check(int buffer) {
		boolean isPrint = true;
		int cnt = 0;
		for(int i = 0; i < size; i++) {
			if(buffer < stackbuffer[i]) {
				cnt = cnt + 1;
			}
	}
		if(cnt > 0) {
			isPrint = false;
		}
		return isPrint;
	}
	
}
