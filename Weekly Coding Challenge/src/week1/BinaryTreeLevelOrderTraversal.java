package week1;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	
	public static void main(String[] args) {
		// create some Nodes to demonstrate
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);
		Node n11 = new Node(11);
		Node n12 = new Node(12);
		Node n13 = new Node(13);
		Node n14 = new Node(14);
		Node n15 = new Node(15);
		
		// layer 1 is n1
		// layer 2 is n2, n3
		n1.setChild1(n2);
		n1.setChild2(n3);
		// layer 3 is n4,n5,n6,n7
		n2.setChild1(n4);
		n2.setChild2(n5);
		n3.setChild1(n6);
		n3.setChild2(n7);
		// layer 4 is n8,9,10,11,12,13,14,15
		n4.setChild1(n8);
		n4.setChild2(n9);
		n5.setChild1(n10);
		n5.setChild2(n11);
		n6.setChild1(n12);
		n6.setChild2(n13);
		n7.setChild1(n14);
		n7.setChild2(n15);
		
		// now show that our method goes through the binary tree correctly
		useBinaryTree(n1);
	}
	
	// method for going through a binary tree in level order
	public static void useBinaryTree(Node firstNode) {
		Queue<Node> queue = new LinkedList<>(); // queue for adding nodes as we come across them
		queue.add(firstNode); // add starting node to queue
		
		while(!queue.isEmpty()) { // continue operation till queue is empty
			Node tempNode = queue.remove(); // grab node at head of queue for using
			System.out.println(tempNode.getId()); // use the node, in our case just print id
			if(tempNode.getChild1() != null) { // add child 1 to queue if not null
				queue.add(tempNode.getChild1());
			}
			if(tempNode.getChild2() != null) { // add child 2 to queue if not null
				queue.add(tempNode.getChild2());
			}
		}
	}
	
	
}

// Node class for acting as nodes of binary tree
class Node implements BinaryTree{
	private int id;
	private Node child1;
	private Node child2;

	@Override
	public Node getChild1() {
		return child1;
	}

	@Override
	public Node getChild2() {
		return child2;
	}

	@Override
	public void setChild1(Node node) {
		this.child1 = node;		
	}

	@Override
	public void setChild2(Node node) {
		this.child2 = node;		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Node(int id, Node child1, Node child2) {
		super();
		this.id = id;
		this.child1 = child1;
		this.child2 = child2;
	}

	public Node(int id) {
		super();
		this.id = id;
	}
	
	
	
	
}

// interface to define a node for binary tree
interface BinaryTree {
	public Node getChild1();
	public Node getChild2();
	
	public void setChild1(Node node);
	public void setChild2(Node node);
}
