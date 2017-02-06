import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class RandomizedSet {

	Hashtable<Integer, Boolean> table;
	ArrayList<Integer> keySet;
	Random r = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        table = new Hashtable<Integer, Boolean>();
        keySet = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!table.containsKey(val)){
        	table.put(val, true);
        	keySet.add(val);
        	return true;
        } return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(table.containsKey(val)){
        	table.remove(val);
        	keySet.remove(val);
        	return true;
        } return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	int size = keySet.size();
    	int r_ind = r.nextInt(size);
    	return keySet.get(r_ind);
    }
    
    public static void main(String[] args){
    	/*
    	RandomizedSet rset = new RandomizedSet();
    	System.out.println(rset.insert(1));
    	System.out.println(rset.insert(2));
    	System.out.println(rset.insert(3));
    	System.out.println(rset.insert(4));
    	System.out.println(rset.insert(5));
    	System.out.println(rset.insert(6));

    	for(int i = 0; i < 10; i++){
    		System.out.print(rset.getRandom() + " ");
    	}
    	*/
    	String fileName = "coati.jpg";
    	String extension = "";

    	int i = fileName.lastIndexOf('.');
    	if (i > 0) {
    	    extension = fileName.substring(i+1);
    	}
    	System.out.println(extension);
    }
}