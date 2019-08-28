package Array;

import java.util.ArrayList;

public class problem02 {
	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 0};		
		//System.out.println(haveThree(arr));	
		//System.out.println(twoTwo(arr));
		//System.out.println(sameEnds(arr,2));
		//System.out.println(tenRun(arr));
		//pre4(arr);
		//zeroFront(arr);
		fizzBuzz(1,6);
		
		
	}
	
	
	public static void fizzBuzz(int start, int end) {
		int len=end-start;
		String arr[]= new String[len];
		 
		    for(int i=start;i<(len+start);i++) {
		      
		    	if(i%3==0 && i%5==0) {
		    		arr[i-start]="FizzBuzz";
		    	}
		    	else if(i%3==0) {
		    		arr[i-start]="Fizz";
		    	}
		    	else if(i%5==0) {
		    		arr[i-start]="Buzz";
		    	}
		    	else {
		    		arr[i-start]=String.valueOf(i);
		    	} 
		    }
		    for(String kk:arr) {
		    	System.out.println(kk);
		    }
		  // return arr;	       
	}

	
	
	public static void zeroFront(int[] nums) {
		int len= nums.length;
		   int i=0;
		   int j=len-1;
		   while(i<j){
		    if(nums[i]!=0){
		   	 while(nums[j]!=0 && i<j){
		         j--;
		     }
		       int temp=nums[j];
		       nums[j]=nums[i];
		       nums[i]=temp;
		       j--;
		    }
		      i++;
		     // System.out.println(" i "+i+" j "+j);
		 }
		 
	}
	

	public static int[] pre4(int[] nums) {
		ArrayList<Integer> al = new ArrayList<>();
		for(int kk:nums) {
			if(kk==4) {
				break;
			}
			else {
				al.add(kk);
			}
		}
		return al.stream().mapToInt(i -> i).toArray();
			
	}

	public static int[] tenRun(int[] nums) {
	      int len=nums.length;
	      if(len==0){
	         return nums;
	      }
	      int found=0;
	      int temp=0;
	      for(int i=0;i<len;i++){
	          if(nums[i]%10==0){
	            found=1;
	            temp=nums[i];
	          }
	          else if(found==0){
	            continue;
	          }
	          else if(found==1){
	            nums[i]=temp;
	          }
	      }
	      return nums;
	}

	
	public static boolean sameEnds(int[] nums, int n) {
	       int len=nums.length;
	       if(len<2 || n==0){
	         return true;
	       }
	       if(len==2){
	         if(nums[0]==nums[len-1]){
	           return true;
	         }
	         return false;
	       }
	       
	       for(int i=0;i<n;i++){
	    	   
	    	  if(nums[i]!=nums[len-n+i]){
	    		  return false;
	          }	          
	       }
	       return true;
	}

	
	public static boolean twoTwo(int[] nums) {
	     int len=nums.length;
	     if(len==0){
	       return true;
	     }
	     if(len==1){
	       if(nums[0]==2){
	          return false;
	       }
	       return true;
	     }
	     for(int i=0;i<len;i++){
	        if(nums[i]==2){
	            if(i>0 && i<len-1 && ( nums[i-1]!=2 && nums[i+1]!=2) ){
	              return false;
	            }
	            
	            if(i==len-1 && nums[i]==2){
	              if(nums[i-1]!=2){
	                return false;
	              }
	              return true;
	            }
	        }
	     }
	     return true;
	}

	
	
	public static boolean haveThree(int[] nums) {
	    int len=nums.length;
	    if(len<3){
	      return false;
	    }
	    int count=0;
	    boolean found=false;
	    
	    for(int i=0;i<len;i++){
	      if(nums[i]!=3){
	    	  found=false;
	      }
	      if( nums[i]==3 && found==true) {
	    	  return false;
	      }
	      if(nums[i]==3 && found==false) {
	    	  found=true;
	    	  count++;
	      }	      	     
	    }
	    
	    System.out.println(count);
	    if(count==3){
	      return true;
	    }
	    return false;
	}	
}
