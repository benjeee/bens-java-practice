import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;


public class MyGraph {
	
	class Vertex{
		int value;
		HashSet<Vertex> adjacent;
		public Vertex(int val){
			this.value = val;
			this.adjacent = new HashSet<Vertex>();
		}
	}
	
	HashMap<Integer, Vertex> vertexes;
	Vertex head;
	public MyGraph(){
		this.head = null;
		this.vertexes = new HashMap<Integer, Vertex>();
	}
	
	public void addVertex(int val){
		Vertex v = new Vertex(val);
		vertexes.put(val, v);
		if(head == null) head = v;
	}
	
	public boolean addEdge(int s, int e){
		Vertex start = vertexes.get(s);
		Vertex end = vertexes.get(e);
		if(start == null || end == null){
			System.out.println("invalid input");
			return false;
		} else {
			return start.adjacent.add(end);
		}
	}
	
	public void bfs(){
		HashMap<Vertex, Boolean> visited = new HashMap<Vertex,Boolean>();
		for(Vertex v : vertexes.values()){
			visited.put(v, false);
		}
		LinkedList<Vertex> queue = new LinkedList<Vertex>();
		queue.addFirst(head);
		visited.put(head, true);
		while(!queue.isEmpty()){
			Vertex curr = queue.removeLast();
			System.out.println(curr.value);
			for(Vertex v: curr.adjacent){
				if(!visited.get(v)){
					//System.out.println(v.value);
					visited.put(v, true);
					queue.addFirst(v);
				}
			}
		}
	}
	
	public void dfs(){
		HashMap<Vertex, Boolean> visited = new HashMap<Vertex,Boolean>();
		for(Vertex v : vertexes.values()){
			visited.put(v, false);
		}
		LinkedList<Vertex> stack = new LinkedList<Vertex>();
		stack.push(head);
		visited.put(head, true);
		while(!stack.isEmpty()){
			Vertex curr = stack.pop();
			System.out.println(curr.value);
			for(Vertex v: curr.adjacent){
				if(!visited.get(v)){
					visited.put(v, true);
					stack.push(v);
				}
			}
		}
	}
	
	public void dfsd(){
		HashMap<Vertex, Boolean> visited = new HashMap<Vertex, Boolean>();
		for(Vertex v : vertexes.values()){
			visited.put(v, false);
		}
		LinkedList<Vertex> stack = new LinkedList<Vertex>();
		stack.push(head);
		visited.put(head,true);
		while(!stack.isEmpty()){
			Vertex curr = stack.pop();
			System.out.println(curr.value);
			for(Vertex v: curr.adjacent){
				if(!visited.get(v)){
					visited.put(v, true);
					stack.push(v);
				}
			}
		}
	}
	
	public void dfsRecursive(){
		HashMap<Vertex, Boolean> visited = new HashMap<Vertex, Boolean>();
		for(Vertex v : vertexes.values()){
			visited.put(v, false);
		}
		dfsRecursive(head, visited);
	}
	private void dfsRecursive(Vertex curr, HashMap<Vertex, Boolean> visited){
		System.out.println(curr.value);
		for(Vertex v : curr.adjacent){
			if(!visited.get(v)){
				visited.put(v, true);
				dfsRecursive(v, visited);
			}
		}
	}
	
	public static void main(String[] args) {
		MyGraph graph = new MyGraph();
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		graph.addVertex(6);
		
		graph.addEdge(1,2);
		graph.addEdge(1,3);
		graph.addEdge(2,4);
		graph.addEdge(4,2);
		graph.addEdge(3,5);
		graph.addEdge(3,4);
		graph.addEdge(4,6);
		graph.addEdge(5,6);
		
		graph.bfs();
		System.out.println();
		graph.dfs();
		System.out.println();
		graph.dfsRecursive();
	}

}
