import java.util.*;

public class SetOfStacks {

	class Node {
		Node next = null;
		int data;
		Node(int d){
			data = d;
		}
	}
	
	ArrayList<Stack> stackList;
	int max;
	int numStacks;
	int lastStack;
	public SetOfStacks(int max){
		this.stackList = new ArrayList<Stack>();
		this.max = max;
		this.numStacks = 0;
		this.lastStack = -1;
	}
	public Stack getLastStack(){
		if(stackList.size() == 0) return null;
		return stackList.get(lastStack);
	}
	public void push(int val){
		if(lastStack == -1){
			Stack newStack = new Stack();
			newStack.push(val);
			stackList.add(newStack);
			lastStack++;
			return;
		}
		Stack last = stackList.get(lastStack);
		if(last != null && last.size < max){
			last.push(val);
		} else {
			Stack newStack = new Stack();
			newStack.push(val);
			stackList.add(newStack);
			lastStack++;
		}
	}
	public int pop(){
		System.out.println(lastStack);
		Stack last = stackList.get(lastStack);
		if(last == null) return -1;
		int v = last.pop().data;
		if(last.size == 0){
			stackList.remove(stackList.size() - 1);
			lastStack--;
		}
		return v;
	}
	public void print(){
		int v = lastStack;
		for(; v>=0; v--){
			Stack currStack = stackList.get(v);
			currStack.print();
		}
	}
	
	public static void main(String[] args){
		SetOfStacks sos = new SetOfStacks(3);
		sos.push(1);
		sos.push(2);
		sos.push(3);
		sos.push(4);
		sos.push(5);
		sos.push(6);
		sos.push(7);
		sos.push(8);
		sos.pop();
		sos.pop();
		sos.pop();
		sos.print();
	}
}
