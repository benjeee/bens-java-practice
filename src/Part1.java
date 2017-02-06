import java.text.DecimalFormat;
import java.util.*;


public class Part1 {
	
	
	boolean unique(String s){
		boolean[] char_set = new boolean[256];
		for(int i = 0; i < s.length(); i++){
			int c = s.charAt(i);
			if(char_set[c]){
				return false;
			}else char_set[c] = true;
		}
		return true;
	}
	
	boolean unique_nds(String s){
		
		return true;
	}
	
	static char[] reversed(char[] ca){
		int i = 0;
		int j = ca.length -1;
		while(i < j){
			char tmp = ca[i];
			ca[i] = ca[j];
			ca[j] = tmp;
			i++;
			j--;
		}
		return ca;
	}
	
	static boolean anagrams(char[] str1, char[] str2){
		if(str1 == null || str2 == null) return false;
		if(str1.length != str2.length) return false;
		
		int[] hits = new int[256];
		System.out.println(hits[200]);
		for(int i = 0; i < str1.length; i++){
			hits[str1[i]] += 1;
			hits[str2[i]] -= 1;
		}
		for(int i = 0; i < 256; i++){
			if(hits[i] != 0) return false;
		}
		return true;
	}
	
	static int fibonacci(int n){
		if(n == 0) return 0;
		if(n == 1) return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	static void fib_iter(int n){
		int twoback = 0;
		int oneback = 1;
		for(int i = 0; i < n; i++){
			System.out.println(twoback + oneback);
			int tmp = oneback;
			oneback+=twoback;
			twoback = tmp;
		}
	}
    public static boolean isAnagram(String str1, String str2){
        if(str1 == null || str2 == null) return false;
		if(str1.length() != str2.length()) return false;
		
		int[] hits = new int[256];
		for(int i = 0; i < str1.length(); i++){
			hits[str1.charAt(i)] += 1;
			hits[str2.charAt(i)] -= 1;
		}
		for(int i = 0; i < 256; i++){
			if(hits[i] != 0) return false;
		}
		return true;
    }
    
    public static List<List<String>> groupAnagrams(String[] strs) {
    	
    	if(strs.length == 0) return null;
    	
        List<List<String>> result = new ArrayList<List<String>>();

    	List<String> firstList = new ArrayList<String>();
    	firstList.add(strs[0]);
        result.add(firstList);
        
        for(int i = 1; i < strs.length; i++){
            String curr = strs[i];
            boolean added = false;
            for(List<String> strList : result){
            	if(Tanagram(strList.get(0), curr)){
            		strList.add(curr);
            		added = true;
            	}
            }
            if(!added){
            	List<String> newList = new ArrayList<String>();
            	newList.add(curr);
                result.add(newList);
            }
        }
        return result;
    }
    
    public static boolean Tanagram(String s, String t) {
    	if(s.length() == 0 && t.length() == 0) return true;
    	if (s.length() != t.length()) return false;
    	int[] letters = new int[256];
    	int num_unique_chars = 0;
    	int num_completed_t = 0;
    	char[] s_array = s.toCharArray();
    	for (char c : s_array) {
    		if (letters[c] == 0) ++num_unique_chars;
    		++letters[c];
    	} 
    	for (int i = 0; i < t.length(); ++i) {
    		int c = (int) t.charAt(i);
    		if (letters[c] == 0) {
    			return false;
    		}
    		--letters[c];
    		if (letters[c] == 0) {
    			++num_completed_t;
    			if (num_completed_t == num_unique_chars) {
    				return i == t.length() - 1;
    			}
    		} 
    	}
    	return false;
    	
    }
    
    public static List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
     
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(String str: strs){
            char[] arr = new char[26];
            for(int i=0; i<str.length(); i++){
                arr[str.charAt(i)-'a']++;
            }
            String ns = new String(arr);
            if(map.containsKey(ns)){
                map.get(ns).add(str);
            }else{
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                map.put(ns, al);
            }
        }
     
        result.addAll(map.values());
     
        return result;
    }
    public static boolean isAnagram2(String str1, String str2) {
        if(str1 == null || str2 == null) return false;
		if(str1.length() != str2.length()) return false;
		
		int[] hits = new int[26];
		for(int i = 0; i < str1.length(); i++){
			hits[str1.charAt(i)-'a'] += 1;
			hits[str2.charAt(i)-'a'] -= 1;
		}
		for(int i = 0; i < 26; i++){
			if(hits[i] != 0) return false;
		}
		return true;
    }
    
    public static int hammingWeight(int n) {
        int ct = 0;
        while(n > 0){
            if(n % 2 == 1) ct++;
            n = n>>1;
        }
        return ct;
    }
    
	
	public static void permutation(String str) { 
	    permutation("", str); 
	}
	
	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	
	public static Set<Set<Integer>> powerSet(Set<Integer> originalSet) {
        Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<Integer>());
            return sets;
        }
        List<Integer> list = new ArrayList<Integer>(originalSet);
        Integer head = list.get(0);
        Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size()));
        for (Set<Integer> set : powerSet(rest)) {
            Set<Integer> newSet = new HashSet<Integer>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }

	
	public static void printparens(int l, int r, int count, char[] str){
		if(l < 0 || r < 0){
			return;
		}
		if(l == 0 && r == 0){
			System.out.println(str);
		}
		else {
			if(l > 0){
				str[count] = '(';
				printparens(l-1, r, count+1, str);
			}
			if(r > l){
				str[count] = ')';
				printparens(l, r-1, count+1, str);
			}
		}
	}
    public static int[] intersection(int[] nums1, int[] nums2) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i: nums1){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }
     
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i: nums2){
            if(map.containsKey(i)){
                if(map.get(i)>1){
                    map.put(i, map.get(i)-1);
                }else{
                    map.remove(i);
                }
                list.add(i);
            }
        }
     
        int[] result = new int[list.size()];
        int i =0;
        while(i<list.size()){
            result[i]=list.get(i);
            i++;
        }
     
        return result;
    }
    
    public int maxSubArrayAddDP(int[] A) {
        int newsum=A[0];
        int max=A[0];
        for(int i=1;i<A.length;i++){
            newsum=Math.max(newsum+A[i],A[i]);
            max= Math.max(max, newsum);
        }
        return max;
     }
    
    public int maxProductDP(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
     
        max[0] = min[0] = nums[0];
        int result = nums[0];
     
        for(int i=1; i<nums.length; i++){
            if(nums[i]>0){
                max[i]=Math.max(nums[i], max[i-1]*nums[i]);
                min[i]=Math.min(nums[i], min[i-1]*nums[i]);
            }else{
                max[i]=Math.max(nums[i], min[i-1]*nums[i]);
                min[i]=Math.min(nums[i], max[i-1]*nums[i]);
            }
     
            result = Math.max(result, max[i]);
        }
     
        return result;
    }
    
    
    
    
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
        	for(int j = i; j < nums.length; j++){
        		int currp = getProduct(nums, i, j);
        		if(currp > max){
        			max = currp;
        		}
        	}
        }
        return max;
    }
    
    public static int getProduct(int[] nums, int r, int l){
        int product = 1;
        while(r <= l){
            product = product * nums[r];
            r++;
        }
        return product;
    }
    
    public static int[] to_rc(int val, int rows, int cols){
    	int row = val/rows;
    	int col = val%cols;
    	return new int[]{row,col};
    }
    
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i: nums){
            q.offer(i);
     
            if(q.size()>k){
                q.poll();
            }
        }
     
        return q.peek();
    }
    
    /*
     * PriorityQueue<Patient> patientQueue = new PriorityQueue<Patient>(10, new Comparator<Patient>() {
        public int compare(Patient patient1, Patient patient2) {
            return (patient1.age - patient1.age);
        }
    });
     */
    
    public void rotate(int[] nums, int k) {
        if(k > nums.length) 
            k=k%nums.length;
     
        int[] result = new int[nums.length];
     
        for(int i=0; i < k; i++){
            result[i] = nums[nums.length-k+i];
        }
     
        int j=0;
        for(int i=k; i<nums.length; i++){
            result[i] = nums[j];
            j++;
        }
     
        System.arraycopy( result, 0, nums, 0, nums.length );
    }
    
    public static void rotateWRev(int[] arr, int order) {	
    	if (arr == null || arr.length==0 || order < 0) {
    		throw new IllegalArgumentException("Illegal argument!");
    	}
     
    	if(order > arr.length){
    		order = order %arr.length;
    	}
     
    	//length of first part
    	int a = arr.length - order; 
     
    	reverse(arr, 0, a-1);
    	reverse(arr, a, arr.length-1);
    	reverse(arr, 0, arr.length-1);
     
    }
     
    public static void reverse(int[] arr, int left, int right){
    	if(arr == null || arr.length == 1) 
    		return;
     
    	while(left < right){
    		int temp = arr[left];
    		arr[left] = arr[right];
    		arr[right] = temp;
    		left++;
    		right--;
    	}	
    }
    
    public static boolean isReverse(String s1, String s2){
    	int end = s1.length();
    	if(end != s2.length()){
    		return false;
    	}
    	end--;
    	int start = 0;
    	while(start <= end){
    		if(s1.charAt(start) != s2.charAt(end)){
    			return false;
    		}
    		start++;
    		end--;
    	}
    	return true;
    }

	public static void main(String[] args){
		System.out.println(isReverse("Hello", "olleH"));
		
		int[] list = new int[5];
		System.out.println(list.length);
		String lol = "lol";
		System.out.println(lol.length());
		ArrayList<Integer> lisst = new ArrayList<Integer>();
		lisst.size();
	}

}
