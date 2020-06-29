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
		
	}
	
	
	private static void insert(int data, Node parent) {
		if(parent == null) parent = new Node(data); 
		if(parent.data < data) {
			insert(data, parent.right);
		}
		else if(parent.data > data) {
			insert(data, parent.left); 
		}
		else {
			System.out.println("������ �ߺ�");
			return; 
		}
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
		if(deleteNode == null) {
			System.out.println("���������ʽ��ϴ�.");
			return;
		}
		
		// deleteNode�� �θ� ã�ƶ�! 
		
		if(deleteNode.left == null && deleteNode.right == null) {
			
		}
	}
}
