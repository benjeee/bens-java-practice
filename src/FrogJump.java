import java.util.Arrays;


public class FrogJump {


	public static int frogjump(int x, int d, int[] A){
		
		//if we can jump from side to side w/o leaves, return 0 seconds
		if(d>=x) return 0;
		
		//keep track of positions reached
		boolean pos_reached[] = new boolean[x+1];
		pos_reached[0] = true;
		int currPos = 0;
		
		for(int i = 0; i < A.length; i++){

			int nextPos = A[i];
			
			//if we have a new time, update pos_reached and consider moving
			if(!pos_reached[nextPos]) pos_reached[nextPos] = true;
				
			//only consider jumping if the frog is moving forward
			//if in range of next position, update current to next
			if(nextPos > currPos && currPos + d >= nextPos){
				currPos = nextPos;
				//if we updated position, check if any leaves are in range d, move there if so
				for(int j = 1; j <= d; j++){
					//break when we run out of room to check
					if(currPos + j >= pos_reached.length) break;
					//if any of the D closest points has a leaf, move to that leaf.
					else{
						if(pos_reached[currPos + j]) currPos = currPos + j;
					}
				}
			}	
			//if in range of end, return time taken to get to current position
			if(currPos + d >= x) return i;
		
		}
		
		return -1;
	
	}
	
	
	 public int frog(int X, int[] A) {
	        int steps = X;
	        boolean[] bitmap = new boolean[steps+1];
	        for(int i = 0; i < A.length; i++){
	            if(!bitmap[A[i]]){
	                bitmap[A[i]] = true;
	                steps--;
	            }
	            if(steps == 0) return i;
	        }
	        return -1;
	    }
	
	
	
	
	
 public static int solution(int[] A, int D) {
        //if we can reach the end in one jump, can be done in 0 seconds.
        if(-1 + D >= A.length) return 0;
        
        //going for different approach after clue from complexity requirements
        //get maximum time
        int maxTime = findMax(A);
        
        //if all values were -1, impossible
        if(maxTime <= -1) return -1;
        
        //new array where time is index, position is value
        int posAtTime[] = new int[maxTime + 1];
        Arrays.fill(posAtTime, -1);
        for(int i = 0; i < A.length; i++){
            int timeAtPos = A[i];
            if(timeAtPos != -1) posAtTime[timeAtPos] = i;
        }
        
        
       //keep track of positions reached
  		boolean pos_reached[] = new boolean[posAtTime.length+1];
  		pos_reached[0] = true;
  		int currPos = 0;
  		
  		for(int i = 0; i < posAtTime.length; i++){

  			int nextPos = posAtTime[i];
  			if(nextPos != -1){
	  			//if we have a new time, update pos_reached and consider moving
	  			if(!pos_reached[nextPos]) pos_reached[nextPos] = true;
	  				
	  			//only consider jumping if the frog is moving forward
	  			//if in range of next position, update current to next
	  			if(nextPos > currPos && currPos + D >= nextPos){
	  				currPos = nextPos;
	  				//if we updated position, check if any leaves are in range d, move there if so
	  				for(int j = 1; j <= D; j++){
	  					//break when we run out of room to check
	  					if(currPos + j >= pos_reached.length) break;
	  					//if any of the D closest points has a leaf, move to that leaf.
	  					else{
	  						if(pos_reached[currPos + j]) currPos = currPos + j;
	  					}
	  				}
	  			}	
	  			//if in range of end, return time taken to get to current position
	  			if(currPos + D >= posAtTime.length) return i;
  			}
  		
  		}
        
        
        return -1;
    }

    public static int findMax(int[] A){
        int max = -2; 
        for(int i = 0; i < A.length; i++){
            max = Math.max(max, A[i]);
        }
        return max;
    }
	
	public static void main(String[] args) {
		int A[] = {1,3,1,4,2,5}; //pass
		//0 1
		//1 3
		//2 1
		//3 4
		//4 2
		//5 5
		int B[] = {1,4,1,2,1,4}; //pass
		
		int D[] = {1,2,3,4};
		int x = 7;
		int d = 3;
		
		
		int C[] = {1,-1,0,2,3,5};
		int fjr = solution(C, d);
		System.out.println(fjr);
	}

}
