package Logic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class problem_02 {
	public static void main(String[] args) {
		//System.out.println(loneSum(1,2,2));
		//System.out.println(luckySum(1, 13, 3));
		
		//System.out.println(noTeenSum(2, 1, 14));
		//System.out.println(evenlySpaced(4, 6, 3));
		System.out.println(makeChocolate(6, 1, 10));
		
	}
	
	public static int makeChocolate(int small, int big, int goal) {
		/*
		 We want make a package of goal kilos of chocolate. We have small bars (1 kilo each) and big bars (5 kilos each).
		 Return the number of small bars to use, assuming we always use big bars before small bars. Return -1 if it can't be done.  
		 */
		 if((goal%5)==0){
	         if((goal/5)<=big ){
	           return 0;
	         }
	         else{
	           goal = goal-(5*big);
	           if(goal<=small){
	              return goal;
	           }
	           else {
	              return -1;
	           }
	         }
	      }
	      else {
	         if((goal/5)<=big){
	           goal = goal - ( 5* ( goal/5));
	           if(goal<=small){
	             return goal;
	           }
	           else{
	             return -1;
	           }
	         }
	         else {
	           goal = goal - (5 * big);
	            if(goal<=small){
	             return goal;
	           }
	           else{
	             return -1;
	           }
	         }
	     }
	}
	
	
	public static boolean evenlySpaced(int a, int b, int c) {
		int arr[]= new int[3];
		arr[0]=a;
		arr[1]=b;
		arr[2]=c;
		Arrays.sort(arr);
		if((arr[2]-arr[1]) == (arr[1]-arr[0] )) {
			return true;
		}
		else{
			return false;
		}
	}

	
	public static boolean closeFar(int a, int b, int c) {
	      if(Math.abs(a-b)<=1) {
	        if((Math.abs(a-c)>=2) && (Math.abs(b-c)>=2)){
	          return true;
	        }
	        else{
	          return false;
	        }
	      }
	      if((Math.abs(a-c)<=1)){
	           if( (Math.abs(a-b)>=2) && (Math.abs(c-b)>=2)) {
	              return true;
	           }else{
	             return false;
	           }
	      }
	      return false;
	}
	
	
	public static int luckySum(int a, int b, int c) {
		 /*
		  Given 3 int values, a b c, return their sum. However, if one of the values is 13 then it does 
		  not count towards the sum and values to its right do not count. So for example, if b is 13,
		  then both b and c do not count. 
		  */
		if(c==13) {
			if(b==13) {
				if(a==13) {
					return 0;
				}
				else {
					return a;
				}
			}
			else {
				if(a==13) {
					return 0;
				}
				else {
					return a+b;
				}				 
			}
		}		 
		else if(b==13) {
			if(a==13) {
				return 0;
			}
			else {
				return a;
			}
		}
		else if(a==13) {
				if(c==13) {
					return 0;
				}
				else {
					return c;
				}
		}
		return a+b+c;
	}

	
	public static int loneSum(int a, int b, int c) {
	    int sum=0;
	    if(a==b) {
	    	if(b==c) {
	    		return 0;
	    	}
	    	else {
	    		return c;
	    	}	    	
	    }
	    else {
	    	if(b==c) {
	    		return a;
	    	}
	    	else if(a==c){
	    		return b;
	    	}
	    	else {
	    		return a+b+c;
	    	}
	    	
	    }	   
	}

	

}
