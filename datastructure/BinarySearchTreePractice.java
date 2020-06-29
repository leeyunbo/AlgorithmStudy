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
			System.out.println("데이터 중복");
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
			System.out.println("존재하지않습니다.");
			return;
		}
		
		// deleteNode의 부모를 찾아라! 
		
		if(deleteNode.left == null && deleteNode.right == null) {
			
		}
	}
}
