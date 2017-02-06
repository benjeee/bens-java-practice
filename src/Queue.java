
public class Queue {

	class Node {
		Node next = null;
		int data;
		Node(int d){
			data = d;
		}
	}
	Node head, tail;
	public Queue(){
		head = null;
		tail = null;
	}
	
	public void enqueue(int data){
		Node to_add = new Node(data);
		if(head == null){
			head = to_add;
			tail = to_add;
		} else {
			tail.next = to_add;
			tail = to_add;
		}
	}
	
	public Node dequeue() {
		if(head == null) return null;
		Node tmp = head;
		head = head.next;
		return tmp;
	}
	
	public void print(){
		Node n = head;
		while(n != null){
			System.out.println(n.data);
			n = n.next;
		}
	}
	
	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		
		Node n = q.dequeue();
		//System.out.println(n.data);
		q.print();
		
	}

}
