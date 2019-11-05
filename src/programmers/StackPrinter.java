package programmers;

/* �Ϲ����� �����ʹ� �μ� ��û�� ���� ������� �μ�, �߿��� ������ ���߿� �μⰡ �Ǵ� ������ �߻��� �� ���� 
 * �̷� ������ �����ϱ� ���� �߿䵵�� ���� ������ ���� �μ��ϴ� �����͸� �����Ͽ��� 
 * 1. �μ� ������� ���� �տ� �ִ� ������ ����Ͽ��� ����  ->> FO 
 * 2. ������ �μ� ����Ͽ��� �� �������� �߿䵵�� ���� ������ �Ѱ��� �����ϸ� ���� ������ �ٽ� ���� �������� ���� >> LI 
 * 3. ���� �߿䵵�� ���� ������ �������� �ʴ´ٸ� �׳� �״�� �μ�
 * 4. Input : �켱���� ����Ʈ, ���� �μ��ϰ� ���� ������ ��ġ Output : �μ��ϰ� ���� ������ �μ�� ����  
 * LIFO --> Stack�� �̿��Ͽ� ���� 
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
