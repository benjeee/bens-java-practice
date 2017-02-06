import java.util.Hashtable;


public class MyLinkedList {

	class Node {
		Node next = null;
		int data;
		Node(int d){
			data = d;
		}
	}
	
	Node head;
	Node tail;
	
	public MyLinkedList(){
		head = null;
		tail = null;
	}
	
	public void appendToEnd(int d){
		Node to_add = new Node(d);
		if(head == null){
			head = to_add;
			return;
		}
		Node n = head;
		while(n.next != null){
			n = n.next;
		}
		n.next = to_add;
		tail = to_add;
	}
	
	public void print(){
		Node n = head;
		while(n != null){
			System.out.println(n.data);
			n = n.next;
		}
	}
	
	public Node delete(int d){
		Node n = head;
		if(n.data == d){
			Node tmp = head;
			head = head.next;
			return tmp;
		}
		while(n.next != null){
			if(n.next.data == d){
				Node tmp = n.next;
				n.next = n.next.next;
				return tmp;
			}
			n = n.next;
		}
		return null;
	}
	
	public void removeDup(){
		if(head == null || head.next == null) return;
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		Node prev = null;
		Node curr = head;
		while(curr != null){
			if(table.containsKey(curr.data)){
				prev.next = curr.next;
			}
			else{
				table.put(curr.data, true);
				prev = curr;
			}
			curr = curr.next;
		}
	}
	
	public void removeDup2(){
		if(head == null || head.next == null) return;
		Node prev = head;
		Node curr = head.next;
		while(curr != null){
			Node runner = head;
			while(runner != curr){
				if(runner.data == curr.data){
					prev.next = curr.next;
					curr = prev.next;
					break;
				}
				runner = runner.next;
			}
			if(runner == curr){
				prev = curr;
				curr = curr.next;
			}
		}
	}
	
	public static int i = 1;  
	public Node findnthToLastRecursion(Node node, int pos) {
	    Node result = node;
	    if(node != null) {
	        result = findnthToLastRecursion(node.next, pos);
	        if(i++ == pos){
	            result = node;
	        }
	    }
	    return result;
	}
	
	public Node findnthToLast(int pos){
		if(head == null) return null;
		Node nth = head;
		Node tail = nth;
		while(pos > 0){
			if(tail.next == null) return null;
			tail = tail.next;
			pos--;
		}
		while(tail != null){
			tail = tail.next;
			nth = nth.next;
		}
		return nth;
	}
	
	public static void add(MyLinkedList list, Node l1, Node l2, int carry){
		if(l1 == null && l2 == null){
			if(carry != 0){
				list.appendToEnd(carry);
			}
			return;
		}
		System.out.println("carry:" + carry);
		int val = carry;
		if(l1 != null){
			val += l1.data;
			l1 = l1.next;
		}
		if(l2 != null){
			val += l2.data;
			l2 = l2.next;
		}
		
		int new_carry = 0;
		if(val >= 10) new_carry = 1;
		list.appendToEnd(val%10);
		add(list, l1, l2, new_carry);
	}
	
	public void reverse(){
		if(head == null || head.next == null) return;
		Node curr = head;
		Node prev = null;
		Node tmp;
		while(curr != null){
			tmp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmp;
		}
		head = prev;
	}
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.appendToEnd(1);
		list.appendToEnd(2);
		list.appendToEnd(2);
		list.appendToEnd(3);
		list.appendToEnd(3);
		list.appendToEnd(4);
		list.removeDup();

		//list.print();
		list.reverse();
		list.print();
	}

}
