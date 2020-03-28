package tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GetPreOrder {
	static int[] inOrder; 
	static int[] postOrder; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		inOrder = new int[N]; 
		postOrder = new int[N];
		String[] line = br.readLine().split(" ");
		for(int j=0; j<line.length; j++) 
			inOrder[j] = Integer.parseInt(line[j]);
		
		line = br.readLine().split(" "); 
		for(int j=0; j<line.length; j++) 
			postOrder[j] = Integer.parseInt(line[j]);
		
		printPreOrder(inOrder, postOrder);
		br.close();
	}
	
	private static void printPreOrder(int[] inOrder,int[] postOrder) {
		int N = postOrder.length;
		
		if(postOrder.length == 0 && inOrder.length == 0) { 
			return;
		}
		
		int root = postOrder[N-1];
	
		//1. root�� inOrder���� ��ġ�� ã�´�, �� ���� ������ �� ���ʿ� ��ġ�� ��� ���̸� ������ ������ �� �����ʿ� ��ġ�� �����̴�. 
		int rootIndex = 0;
		for(int i=0; i<N; i++) {
			if(root == inOrder[i]) {
				rootIndex = i;
				break;
			}
		}
		
		int leftLastIndex = rootIndex;
		
		System.out.print(root + " "); //1. �θ� ����Ѵ�.
		printPreOrder(slice(inOrder,0,leftLastIndex),slice(postOrder,0,leftLastIndex)); //2. ���� �ڽ��� ����Ѵ�.
		printPreOrder(slice(inOrder,leftLastIndex+1,N), slice(postOrder,leftLastIndex,N-1)); //3. ������ �ڽ��� ����Ѵ�. 
	}
	
	private static int[] slice(int[] array, int start, int end) {
		return Arrays.copyOfRange(array, start, end);
	}

}