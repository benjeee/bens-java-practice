public class Stack {

	class Node {
		Node next = null;
		int data;
		Node(int d){
			data = d;
		}
	}
	public int size;
	Node top;
	public Stack(){
		top = null;
		size = 0;
	}
	public void push(int val){
		Node to_add = new Node(val);
		to_add.next = top;
		top = to_add;
		size++;
	}
	public Node pop(){
		if(top == null) return null;
		Node tmp = top;
		top = top.next;
		return tmp;
	}
	
	public void print(){
		Node n = top;
		while(n != null){
			System.out.println(n.data);
			n = n.next;
		}
	}
	public static void main(String[] args) {
		Stack rod1 = new Stack();
		Stack rod2 = new Stack();
		Stack rod3 = new Stack();
		rod1.push(3);
		rod1.push(2);
		rod1.push(1);
	}

}
