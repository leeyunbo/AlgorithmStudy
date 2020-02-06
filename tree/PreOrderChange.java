package tree;
/*
 * 만약 어떠한 트리에 대해서 전위순회, 중위순회한 결과가 주어졌을 때, 후위 순회한 결과를 출력하시오 
 */
public class PreOrderChange {
	static int preOrder[] =  {27,16,9,12,54,36,72};
	static int inOrder[] = {9,12,16,27,36,54,72};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPostOrder(preOrder,inOrder);
	}
	
	private static void printPostOrder(int[] preOrder, int[] inOrder) {
		int N = preOrder.length;
		int L = 0; int R = 0;
		if(preOrder.length == 0 || inOrder.length == 0) {
			return;
		}
		int root = preOrder[0];
		int root_index = 0;
		for(int i=0; i<N; i++) {
			if(root == inOrder[i]) {
				root_index = i;
				break;
			}
		}
		L = root_index - 1; 
		R = (N-1) - root_index;
		printPostOrder(slice(preOrder,1, L+1),slice(inOrder,0,L)); 
		printPostOrder(slice(preOrder,L+2,N-1),slice(inOrder,L+2,N-1));
		System.out.print(root+" ");
	}
	
	private static int[] slice(int[] Order, int start, int end) {
		int[] list = new int[end-start+1];
		for(int i=start, j=0; i<=end; i++,j++) {
			list[j] =  Order[i];
		}
		
		return list;
	}

}
