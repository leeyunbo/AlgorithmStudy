package datastructure;

class Node {
	int data;
	Node right;
	Node left;
	Node(int data) {
		this.data = data;
		this.right = null;
		this.left = null;
	}
}

public class BinarySearchTree {
	Node root = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private Node insert(Node parent, int data) {
		if(parent == null) {
			return new Node(data);
		}
		else if(parent.data > data) {
			parent.left = insert(parent.left,data);
			return parent;
		}
		else if(parent.data < data) {
			parent.right = insert(parent.right, data);
			return parent;
		}
		else {
			System.out.println("데이터 삽입 불가");
			return null;
		}
	}
	
	private boolean search(int data) {
		Node p = root; 
		while(p != null) {
			if(p.data > data) {
				p = p.left;
			}
			else if(p.data < data) {
				p = p.right;
			}
			else return true;
		}
		return false;
	}
	
	private void delete(int data) {
		Node current = root;
		Node parent = null;
		boolean isLeft = false;
		
		if(!search(data)) {
			System.out.println("data가 존재하지 않습니다. 삭제 불가");
			return;
		}
		
		while(current != null) {
			parent = current;
			if(current.data > data) current = current.left;
			else if(current.data < data) current = current.right;
			else break;
		}
		
		if(parent.data > current.data) isLeft = true; 
		
		//노드의 자식이 없는 경우
		if(current.left == null && current.right == null) {
			if(current==root) root = null;
			if(isLeft) parent.left = null; 
			else parent.right = null;
		}
		
		//노드의 자식이 한쪽만 있는 경우
		else if((current.left == null && current.right != null) || (current.left != null && current.right == null)) {
			if(current.right != null) {
				if(current==root) root = current.right;
				else if(isLeft) parent.left = current.right;
				else parent.right = current.right;
			} 
			else {
				if(current==root) root = current.left;
				else if(isLeft) parent.left = current.left;
				else parent.right = current.left;
			}
		}
		//노드의 자식이 둘다 있는 경우 
		else {
			Node node = null;
			Node node_p = null;
			node_p = current;
			node = current.right;
			while(true) {
				if(node.left == null) 
					break;
				node_p = node;
				node = node.left;
			}
			if(node == current.right) { // current의 오른쪽 자식이 왼쪽 자식이 없는 경우
				if(isLeft) parent.left = node;
				else parent.right = node;
			}
			else {
				if(node.right != null) node_p.left = node.right; //옮겨줄 node의 오른쪽 자식이 없는 경우
				if(isLeft) parent.left = node;
				else parent.right = node;
				node.left = current.left;
				node.right = current.right;
			}
			
		}
		
		
	}

}
