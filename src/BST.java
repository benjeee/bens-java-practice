import java.util.*;



	class Node{
		Node left;
		Node right;
		int value;
		public Node(int val){
			this.value = val;
		}
	}
	
public class BST {


	
	Node head;
	public BST(){
		this.head = null;
	}
	
	public void add(int val){
		if(head == null) {
			head = new Node(val);
			return;
		}
		add(head, val);
	}
	
	private boolean add(Node curr, int val){
		if(curr.value == val){
			return false;
		}
		else if(curr.value > val){
			if(curr.left == null){
				curr.left = new Node(val);
				return true;
			} else return add(curr.left, val);
		}
		else {
			if(curr.right == null){
				curr.right = new Node(val);
				return true;
			} else return add(curr.right, val);
		}
	}
	
	public void inorder(){
		inorder(head);
	}
	private void inorder(Node curr){
		if(curr == null) return;
		inorder(curr.left);
		System.out.println(curr.value);
		inorder(curr.right);
	}
	
	public void preorder(){
		preorder(head);
	}
	private void preorder(Node curr){
		if(curr == null) return;
		System.out.println(curr.value);
		preorder(curr.left);
		preorder(curr.right);
	}
	
	public void postorder(){
		postorder(head);
	}
	private void postorder(Node curr){
		if(curr == null) return;
		postorder(curr.left);
		postorder(curr.right);
		System.out.println(curr.value);
	}
	
	public int height(){
		return height(head);
	}
	private int height(Node curr){
		if(curr == null) return 0;
		return 1 + max(height(curr.left), height(curr.right));
	}
	
	private int max(int num1, int num2) {
		if(num1 > num2) return num1;
		return num2;
	}
	
	public static BST minHeightTree(int[] sortedArray){
		if(sortedArray.length == 0) return null;
		Node head = null;
		mhtHelper(head, sortedArray, 0, sortedArray.length-1);
		BST tree = new BST();
		tree.head = head;
		return tree;
	}
	private static void mhtHelper(Node curr, int[] sortedArray, int start, int end){
		System.out.print("Start: " + start + ", End: "+end);
		if(start > end){
			System.out.println();
		}
		else if(start == end){
			System.out.print(", Inserting value "+sortedArray[start]);
			curr = new Node(sortedArray[start]);
			System.out.println();
		} else {
			int median = (start+end)/2;
			System.out.print(", Median: " + median);
			System.out.println(", Inserting value "+sortedArray[median]);
			curr = new Node(sortedArray[median]);
			mhtHelper(curr.left, sortedArray, start, median - 1);
			mhtHelper(curr.right, sortedArray, median + 1, end);
		}
	}
	
	public static BST mht(int[] sortedArray){
		if(sortedArray.length == 0) return null;
		BST tree = new BST();
		mht(tree, sortedArray, 0, sortedArray.length-1);
		return tree;
	}
	
	private static void mht(BST tree, int[] sortedArray, int start, int end){
		if(start>end) return;
		else {
			int middle = (start + end)/2; 
			tree.add(sortedArray[middle]);
			mht(tree, sortedArray, start, middle-1);
			mht(tree, sortedArray, middle+1, end);
		}
	}
	//Given a binary search tree, design an algorithm which creates a 
	//linked list of all the nodes at each depth 
	//(i e , if you have a tree with depth D, you’ll have D linked lists) 
	public ArrayList<LinkedList<Node>> depthlevels(){
		if(head == null) return null;
		
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		int level = 0;
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(head);
		result.add(level, list);
		while(true){
			list = new LinkedList<Node>();
			for(int i = 0; i < result.get(level).size(); i++){
				Node n = result.get(level).get(i);
				if(n != null){
					if(n.right != null) list.add(n.right);
					if(n.left != null) list.add(n.left);
				}
			}
			if(list.size() > 0){
				result.add(level + 1, list);
			} else {
				break;
			}
			level++;
		}
		return result;
	}
	
	public void printLevels(){
		if(head == null) return;
		ArrayList<Node> prev = new ArrayList<Node>();
		ArrayList<Node> curr;
		prev.add(head);
		while(true){
			curr = new ArrayList<Node>();
			for(Node n : prev){
				System.out.print(n.value + " ");
				if(n.left != null) curr.add(n.left);
				if(n.right != null) curr.add(n.right);
			}
			System.out.println();
			if(curr.size() == 0) break;
			prev = curr;
		}
	}
	
	public void invert(){
		invert(head);
	}
	private void invert(Node n){
		if(n.left == null && n.right == null) return;
		
		Node tmp = n.left;
		n.left = n.right;
		n.right = tmp;
		invert(n.left);
		invert(n.right);
	}
	

	public static void main(String[] args) {

		int[] sorted = {1,2,3,4,5,6,7};
		BST tree2 = mht(sorted);

		//tree2.invert();
		//tree2.inorder();
		tree2.printLevels();

	}

}
