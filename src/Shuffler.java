import java.util.Random;

public class Shuffler {

    int[] original;
    int[] current; 
    Random r;
    public Shuffler(int[] nums) {
        this.original = nums.clone();
        this.current = nums.clone();
        r = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        this.current = original.clone();
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int size = original.length;
        if(size == 1) return original;
        for(int i = size-1; i > 0; i--){
            int index = r.nextInt(i);
            int tmp = current[i];
            current[i] = current[index];
            current[index] = tmp;
        }
        return current;
    }
    public static void main(String[] args){
    	int[] r = {1, 2, 3, 4};
     	Shuffler s = new Shuffler(r);
     	for(int j = 0; j < 10; j++){
	     	int[] g = s.shuffle();
	     	for(int i = 0; i < g.length; i++){
	     		System.out.print(g[i] + " ");
	     	}
	     	System.out.println();
     	}
     	int[] rst = s.reset();
     	for(int i = 0; i < rst.length; i++){
     		System.out.print(rst[i] + " ");
     	}
    }
}