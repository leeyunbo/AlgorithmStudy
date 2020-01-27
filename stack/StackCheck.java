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
 * 스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 
 * 스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.
 * 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
 *  이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 
 *  있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.
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
			if(count==0 && (minus_count != plus_count)) { // push, pop 횟수가 같아야 정답.
				return false;
			}
			if(count==0) {
				break;
			}
			if(!stack.isEmpty() && stack.peek() == collect_list[collect_n]) { //pop 해야 하는 경우
				stack.pop();
				list.add("-");
				minus_count++;
				collect_n++;
			}
			else if(push_n < push_list.length){  //push 해야 하는 경우
				stack.push(push_list[push_n++]);
				list.add("+");
				plus_count++;
			}
			count--;
		}
		
		return true;
	}
}
