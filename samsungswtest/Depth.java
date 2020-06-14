import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Depth {
	static String myText = "((아디다스) 무료 (나이키 (풋살화)) 배송) 강남점 (축구)(잔디)";
	public static void main(String[] args) {
		
		List<word> wordList = new ArrayList<>();
		Stack<Character> stack = new Stack<>();
		String word = "";
		int depth = 0;
		int part = 0;
		
		for(int i=0; i<myText.length(); i++) {
			Character temp = myText.charAt(i);
			if(temp == '(' || temp == '[' || temp == '{') {
				stack.push(temp);
				if(word.length() > 0) {
					wordList.add(new word(depth, part, word));
					word="";
				}
				depth += 1;
			}
			else if(temp == ')' || temp == ']' || temp == '}') {
				stack.pop();
				if(word.length() > 0) {
					wordList.add(new word(depth, part, word));
					word="";
				}
				depth -= 1;
			}
			
			else {
				word += temp;
			}
		}
		
		Collections.sort(wordList);
		
		for(int i=0; i<wordList.size(); i++) {
			if(i == wordList.size() - 1) System.out.print(wordList.get(i).word); 
			else {
				if(wordList.get(i).part == wordList.get(i+1).part && wordList.get(i).depth == wordList.get(i+1).depth) {
					System.out.print(wordList.get(i).word + wordList.get(i+1).word+ ",");
					i++;
				}
				else {
				System.out.print(wordList.get(i).word + ",");
			
				}
			}
		}
		

	}

}


class word implements Comparable<word>{
	int depth; 
	String word; 
	int part;
	public word(int _depth, int _part, String _word) {
		depth = _depth;
		part = _part;
		word = _word.replace(" ", "");
	}
	
	public String toString() {
		return word + "," + depth + "," + part;
	}

	@Override
	public int compareTo(word o) {
		// TODO Auto-generated method stub
		if(this.depth > o.depth) {
			return -1;
		}
		else if(this.depth < o.depth) {
			return 1;
		}
		return 0;
	}

	
}
