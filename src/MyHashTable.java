import java.util.*;
public class MyHashTable {

	int size;
	ArrayList<ArrayList<String>> table;
	
	public MyHashTable(int size){
		this.size = size;
		table = new ArrayList<ArrayList<String>>(size);
		for(int i = 0; i < size; i++){
			table.add(new ArrayList<String>());
		}
	}
	
	public int hash(String s){
		int hashVal = 0;
		for(int i = 0; i < s.length(); i++){
			int c = s.charAt(i);
			hashVal = hashVal^c;
		}
		return hashVal%size;
	}
	
	public boolean insert(String s){
		ArrayList<String> list = table.get(hash(s));
		if(list.contains(s)){
			System.out.println("Item already exists");
			return false;
		}
		list.add(s);
		System.out.println("Inserted "+ s);
		return true;
	}
	
	public String get(String s){
		ArrayList<String> list = table.get(hash(s));
		if(list.size() == 1){
			System.out.println("Got " + list.get(0));
			return list.get(0);
		}
		else{
			for(String str : list){
				if(str.compareTo(s) == 0){
					System.out.println("Got " + str);
					return str;
				}
			}
		}
		System.out.println("DNE");
		return null;
	}
	
	public void print(){
		for(int i = 0; i < size; i++){
			ArrayList<String> list = table.get(i);
			System.out.print("Bucket "+i+": ");
			for(String s : list){
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		MyHashTable ht = new MyHashTable(3);
		ht.insert("Howdy");
		ht.get("Howdy");
		ht.insert("hey");
		ht.get("hey");
		ht.insert("a");
		ht.insert("b");
		ht.insert("c");
		ht.insert("d");
		ht.insert("e");
		ht.insert("f");
		ht.insert("g");
		ht.insert("b");
		ht.print();
		

	}

}
