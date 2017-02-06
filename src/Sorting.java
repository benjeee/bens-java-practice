
public class Sorting {

	
	public static void quicksort(int[] A, int low, int hi){
		if(low < hi){
			int p = partition(A, low, hi);
			quicksort(A, low, p-1);
			quicksort(A, p+1, hi);
		}
	}
	
	private static int partition(int[] A, int low, int hi){
		int pivot = A[hi];
		int i = low;
		for(int j = low; j < hi; j++){
			if(A[j] < pivot){
				int tmp = A[j];
				A[j] = A[i];
				A[i] = tmp;
				i++;
			}
		}
		int tmp = A[i];
		A[i] = A[hi];
		A[hi] = tmp;
		return i;
	}
	
	public static int[] mergesort(int[] list){
		if(list.length == 1) return list;

		int left_len = (int) Math.floor(list.length/2);
		int right_len = list.length - left_len;
		int[] left = new int[left_len];
		int[] right = new int[right_len];
		int i = 0;
		for(; i < left_len; i++){
			left[i] = list[i];
		}
		for(int j = 0; j < right_len; j++){
			right[j] = list[j+i];
		}
		
		left = mergesort(left);
		right = mergesort(right);
		
		return merge(left, right);
	}
		
	public static int[] merge(int[] left, int[] right){
		int[] result = new int[left.length + right.length];
		int currL = 0;
		int currR = 0;
		int i = 0;
		while(currL < left.length && currR < right.length){
			if(left[currL] < right[currR]){
				result[i] = left[currL];
				currL++;
			} else {
				result[i] = right[currR];
				currR++;
			}
			i++;
		}
		while(currL < left.length){
			result[i] = left[currL];
			currL++;
			i++;
		}
		while(currR < right.length){
			result[i] = right[currR];
			currR++;
			i++;
		}
		return result;
	}
	
	public static void printlist(int[] lst){
		for(int i = 0; i < lst.length; i++){
			System.out.print(""+ lst[i] + " ");
		}
		System.out.println();
	}
    public static String reverseString(String s) {
        char[] result = s.toCharArray();
        int j = result.length-1;
        for(int i = 0; i < j; i++){
            char tmp = result[i];
            result[i] = result[j];
            result[j] = tmp;
            j--;
        }
        return new String(result);
    }
    
    
    public int[] mergesort2(int[] arr){
    	//split arr into 2
    	
    	//call mergesort on both split arrays
    	
    	//merge the two arrrays
    	return null;
    }
    
    
    
    
    
    
    
	public static void main(String[] args){
		String s = "hello";
		System.out.println(reverseString(s));
	}
}
