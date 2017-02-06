import java.util.ArrayList;
import java.util.HashMap;


public class Recursion {

	public static int fibonacci(int n){
		if(n == 0) return 0;
		if(n == 1) return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public static void fib_iter(int n){
		int twoback = 0;
		int oneback = 1;
		for(int i = 1; i <= n; i++){
			System.out.println(twoback + oneback);
			int tmp = oneback;
			oneback+=twoback;
			twoback = tmp;
		}
	}
	
	public static long fib_itera(int n){
		if(n <= 2) return 1;
		long twoback = 1;
		long oneback = 1;
		for(int i = 3; i < n; i++){
			long tmp = oneback;
			oneback+=twoback;
			twoback = tmp;
		}
		return oneback+twoback;
	}

	static int fibDP(int n){
        /* Declare an array to store Fibonacci numbers. */
	    int f[] = new int[n+1];
	    int i;
	      
	    /* 0th and 1st number of the series are 0 and 1*/
	    f[0] = 0;
	    f[1] = 1;
	     
	    for (i = 2; i <= n; i++)
	    {
	       /* Add the previous 2 numbers in the series
	         and store it */
	        f[i] = f[i-1] + f[i-2];
	    }
	      
	    return f[n];
    }
	
	public static int makeChange(int n, int denom){
		if(n == 0) return 1;
		int next_denom = 0;
		switch(denom) {
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}
		int ways = 0;
		for(int i = 0; i * denom <=n; i++){
			ways+= makeChange(n - (i*denom), next_denom);
		}
		return ways;
	}
	
	public static ArrayList<ArrayList<Integer>> getAllSubsets(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> allSubsets;
		if(set.size() == index){
			allSubsets = new ArrayList<ArrayList<Integer>>();
			allSubsets.add(new ArrayList<Integer>()); 
		} else {
			allSubsets = getAllSubsets(set, index+1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset : allSubsets){
				ArrayList<Integer> newSubset = new ArrayList<Integer>();
				newSubset.addAll(subset);
				newSubset.add(item);
				moreSubsets.add(newSubset);
			}
			allSubsets.addAll(moreSubsets);
		}
		return allSubsets;
	}
	
	public static ArrayList<ArrayList<Integer>> getAllSubsets2(ArrayList<Integer> set){
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1<<set.size();
		for(int i = 0; i < max; i++){
			ArrayList<Integer> subset = new ArrayList<Integer>();
			int k = i;
			int index = 0;
			while(k > 0){
				if((k & 1) > 0){
					subset.add(set.get(index));
				}
				k >>= 1;
				index++;
			}
			allSubsets.add(subset);
		}
		return allSubsets;
	}
	
	public static ArrayList<String> getPerms(String s){
		ArrayList<String> permutations = new ArrayList<String>();
		if(s == null) return null;
		if(s.length() == 0){
			permutations.add("");
			return permutations;
		}
		char first = s.charAt(0);
		String rest = s.substring(1);
		ArrayList<String> words = getPerms(rest);
		for(String word : words){
			for(int i = 0; i <= word.length(); i++){
				String toAdd = word.substring(0, i) + first + word.substring(i);
				permutations.add(toAdd);
			}
		}
		return permutations;
	}
	
	public static void permutationStr(String str) { 
	    permutationStr("", str); 
	}
	
	private static void permutationStr(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutationStr(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	
	
	public static void printParens(int n){
		printParens("", n, n);
	}
	private static void printParens(String curr, int l, int r){
		if(l < 0 || r < 0) return;
		else if(l == 0 && r == 0){
			System.out.println(curr);
		} else {
			if(l > 0){
				printParens(curr + '(', l-1, r);
			}
			if(r > l){
				printParens(curr + ')', l, r-1);
			}
		}
	}
	
	
	enum Color{
		Black, White, Red, Yellow, Green
	}
	public static boolean paintFill(Color[][] screen, int x, int y, Color ncolor){
		return paintFill(screen, x, y, screen[y][x], ncolor);
	}
	private static boolean paintFill(Color[][] screen, int x, int y, Color ocolor, Color ncolor){
		if(y < 0 || x < 0 || x >= screen[0].length || y >= screen.length){
			return false;
		}
		
		if(screen[y][x] == ocolor){
			screen[y][x] = ncolor;
			System.out.println(screen[y][x]);
			paintFill(screen, x+1, y, ocolor, ncolor);
			paintFill(screen, x-1, y, ocolor, ncolor);
			paintFill(screen, x, y+1, ocolor, ncolor);
			paintFill(screen, x, y-1, ocolor, ncolor);
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(fib_itera(100000));
	}

}
