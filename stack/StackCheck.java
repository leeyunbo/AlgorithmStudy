package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * ���� (stack)�� �⺻���� �ڷᱸ�� �� �ϳ���, ��ǻ�� ���α׷��� �ۼ��� �� ���� �̿�Ǵ� �����̴�. 
 * ������ �ڷḦ �ִ� (push) �Ա��� �ڷḦ �̴� (pop) �Ա��� ���� ���� ���߿� �� �ڷᰡ ���� ���� ������ (LIFO, Last in First out) Ư���� ������ �ִ�.
 * 1���� n������ ���� ���ÿ� �־��ٰ� �̾� �þ�������ν�, �ϳ��� ������ ���� �� �ִ�.
 *  �̶�, ���ÿ� push�ϴ� ������ �ݵ�� ���������� ��Ű���� �Ѵٰ� ����. ������ ������ �־����� �� ������ �̿��� �� ������ ���� �� �ִ��� ������, 
 *  �ִٸ� � ������ push�� pop ������ �����ؾ� �ϴ����� �˾Ƴ� �� �ִ�. �̸� ����ϴ� ���α׷��� �ۼ��϶�.
 */
public class StackCheck {
		static Stack<Integer> stack;
		static List<String> list = new ArrayList<String>();
		static int[] push_list;
		static int[] collect_list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		collect_list = new int[n];
		push_list = new int[n];
		
		for(int i=0; i<n; i++) {
			int data = Integer.parseInt(br.readLine());
			collect_list[i] = data; 
			push_list[i] = data;
		}
		Arrays.sort(push_list);
		stack = new Stack<Integer>();
		
		if(stackCheck()) {
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i));
			}
		} else System.out.println("NO");
	}
	private static boolean stackCheck() {
		int count = push_list.length*2-1;
		int plus_count = 0;
		int minus_count = 0;
		int push_n = 1;
		int collect_n = 0;
		stack.push(push_list[0]);
		list.add("+");
		plus_count++;
		while(true) {
			if(count==0 && (minus_count != plus_count)) { // push, pop Ƚ���� ���ƾ� ����.
				return false;
			}
			if(count==0) {
				break;
			}
			if(!stack.isEmpty() && stack.peek() == collect_list[collect_n]) { //pop �ؾ� �ϴ� ���
				stack.pop();
				list.add("-");
				minus_count++;
				collect_n++;
			}
			else if(push_n < push_list.length){  //push �ؾ� �ϴ� ���
				stack.push(push_list[push_n++]);
				list.add("+");
				plus_count++;
			}
			count--;
		}
		
		return true;
	}
}
