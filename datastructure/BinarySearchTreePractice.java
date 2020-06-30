package datastructure;

class Node {
	Node left; 
	Node right; 
	int data; 
	
	public Node(int data) {
		this.data = data;
	}
	
}


public class BinarySearchTreePractice {
	static Node root = null;
	public static void main(String[] args) {
		root = new Node(3);
		insert(5, root);
		insert(4, root);
		insert(6, root);
		delete(4); 
		printNode(root);
		
	}
	
	private static void printNode(Node current) {
		if(current == null) return;
		System.out.print(current.data + " ");
		printNode(current.left);
		printNode(current.right);
	}
	
	
	private static void insert(int data, Node parent) {
		Node current = null;
		while(parent != null) {
			if(parent.data > data) {
				current = parent;
				parent = parent.left; 
			}
			else if(parent.data < data) {
				current = parent;
				parent = parent.right; 
			}
			else {
				System.out.println("데이터 중복"); 
				return; 
			}
		}
		
		if(current.data < data) current.right = new Node(data);
		else current.left = new Node(data);
	}
	
	private static void contain(int data) {
		Node parent = root; 
		
		while(parent != null) {
			if(parent.data < data) {
				parent = parent.right;
			}
			else if(parent.data > data) {
				parent = parent.left; 
			}
			else {
				System.out.println(parent.data+ "is Contain"); 
				return; 
			}
		}
		
		System.out.println("not Contain"); 
	}
	
	private static Node search(int data) {
		Node parent = root; 
		
		while(parent != null) {
			if(parent.data < data) {
				parent = parent.right;
			}
			else if(parent.data > data) {
				parent = parent.left; 
			}
			else {
				System.out.println(parent.data+ "is Contain"); 
				return parent; 
			}
		}
		
		System.out.println("not Contain"); 
		return null; 
	}
	
	private static void delete(int data) {
		Node deleteNode = search(data); 
		Node parent = null;
		boolean isLeft = false; 
		
		if(deleteNode == null) {
			System.out.println("존재하지않습니다.");
			return;
		}
		
		// deleteNode의 부모를 찾아라!
		Node current = root; 
		while(current != null) {
			if(deleteNode.data < parent.data) {
				current = current.left; 
			}
			else if(deleteNode.data > parent.data) {
				current = current.right;
			}
			else break; 
		}

		if(parent.data > deleteNode.data) isLeft = true; 
		
		
		// 삭제할 노드의 자식이 없으면 그냥 삭제하면 됨 
		if(deleteNode.left == null && deleteNode.right == null) {
			if(isLeft) parent.left = null; 
			else parent.right = null; 
		}
		else {
			// 왼쪽에 자식이 없거나, 오른쪽 자식이 없거나, 둘 다 있거나!
			Node before = null;  
			if(deleteNode.right == null) {
				before = deleteNode.left; 
				while(before.right != null) {
					before = before.right; 
				}
			}
			else {
				before = deleteNode.right; 
				while(before.left != null) {
					before = before.left; 
				}
			}
			
			before.right = deleteNode.right;
			before.left = deleteNode.left; 
			if(isLeft) parent.left = before; 
			else parent.right = before; 
		}
		
		deleteNode = null;
	}
}
