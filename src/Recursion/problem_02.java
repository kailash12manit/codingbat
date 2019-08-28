package Recursion;

public class problem_02 {
	public static void main(String[] args) {
		
		int arr[]= {5,4, 2, 3,1,1};
		//System.out.println(groupSum(0,arr,10));
		//System.out.println(groupSum6(0,arr,12));		
		//System.out.println(groupNoAdj(0,arr,12));
		//System.out.println(groupSum5(0,arr,9));
		//System.out.println(groupSumClump(0,arr,9));
		//System.out.println(splitArray(arr));
		
		
		
		
	}
	
	public boolean split53(int[] nums) {
		/*
		Given an array of ints, is it possible to divide the ints into two groups, so that the sum 
		of the two groups is the same, with these constraints: all the values that are multiple of 5 
		must be in one group, and all the values that are a multiple of 3 (and not a multiple of 5) 
		must be in the other. (No loops needed.)
		 */
		return split53_helper(nums,0,0);
		  
	}

	
	
	private boolean split53_helper(int[] nums, int i, int balance) {
		// TODO Auto-generated method stub
		if(i == nums.length)
			return (balance == 0);
		
		if(nums[i] % 5 == 0)
			return split53_helper(nums, i + 1, balance + nums[i]);
		
		if(nums[i] % 3 == 0)
			return split53_helper(nums, i + 1, balance - nums[i]);
		
		boolean include= (split53_helper(nums, i + 1, balance + nums[i]));
		
		boolean notInclude = split53_helper(nums, i + 1, balance - nums[i]);	
		
		return ( include || notInclude);
	}

	public boolean splitOdd10(int[] nums) {
		 
		return splitOdd10_helper(nums,0,0,0);
		
	}	
	
	private boolean splitOdd10_helper(int[] nums, int i, int group1, int group2) {
		// TODO Auto-generated method stub
		if(i==nums.length) {
			return ( ((group1%2==1) && (group2%10==0)) || ( ( group2%2==1) && (group1%10==0) ));
		}
		boolean include= (splitOdd10_helper(nums, i + 1, group1 + nums[i], group2));
		
		boolean notInclude = splitOdd10_helper(nums, i + 1, group1, group2 + nums[i]);
		
		return ( include || notInclude);
	}

	public static boolean splitArray(int[] nums)
	{	
		return sidesAreEqual(nums, 0, 0);
	}
	
	private static boolean sidesAreEqual(int[] nums, int i, int balance) {
		// TODO Auto-generated method stub
		if(i == nums.length) {
			if(balance == 0) {
				return true;
			}
			else {
				return false;
			}
		}
		boolean include=(sidesAreEqual(nums, i + 1, balance + nums[i]));
		boolean notInclude= sidesAreEqual(nums, i + 1, balance - nums[i]);
	
		return ( include || notInclude);
		
	}

	public static boolean splitArray2(int[] nums) {
		/*
		 Given an array of ints, is it possible to divide the ints into two groups, so that the
		  sums of the two groups are the same. Every int must be in one group or the other. Write a 
		  recursive helper method that takes whatever arguments you like, and make the initial call to
		  your recursive helper from splitArray(). (No loops needed.)
		 */
		int n=nums.length;
		int splitPoint = findSplitPoint(nums, n); 
		if (splitPoint == -1 || splitPoint == n ) { 
            return false; 
        }
		else {
			return true;
		}		
	}	
	public static int findSplitPoint(int[] arr, int n){
		 int leftSum = 0;
		 for (int i = 0 ; i < n ; i++) 
		        leftSum += arr[i]; 
		 int rightSum = 0; 
		 for (int i = n-1; i >= 0; i--) 
		    { 
		        // add current element to right_sum 
		        rightSum += arr[i]; 
		  
		        // exclude current element to the left_sum 
		        leftSum -= arr[i] ; 
		  
		        if (rightSum == leftSum) 
		            return i ; 
		    } 
		 return -1; 
    }
	
	
	public static boolean groupSumClump(int start, int[] nums, int target) {
		/*
		 Given an array of ints, is it possible to choose a group of some of the ints, such that the group 
		 sums to the given target, with this additional constraint: if there are numbers in the array that 
		 are adjacent and the identical value, they must either all be chosen, or none of them chosen. For
		  example, with the array {2, 2, 2, 2, 5, 2}, either all three 2's in the middle must be chosen or not,
		   all as a group. (one loop can be used to find the extent of the identical values).  
		 */
		if(start>nums.length-1) {
			if(target==0) {
				return true;
			}else {
				return false;
			}
		}
		int sum=nums[start],i=0;
		for(i=start;i<nums.length-1;i++) {
			if(nums[i]==nums[i+1]) {
				sum+=nums[i];
			}
			else {
				break;
			}
		}
		start=i;
		boolean include = 	groupSumClump(start+1,nums,target-sum);
		boolean notInclude = groupSumClump(start+1,nums,target);
		
		return ( include || notInclude);
		
	}

	
	public static boolean groupSum5(int start, int[] nums, int target) {
		/*
		 
		 Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given
		  target with these additional constraints: all multiples of 5 in the array must be included in the group. If the value
		   immediately following a multiple of 5 is 1, it must not be chosen. (No loops needed.)
		 
		 */

		if(start>nums.length-1) {
			if(target==0) {
				return true;
			}else {
				return false;
			}
		}
		if(nums[start]%5==0) {
			target=target-(nums[start]);
			if( (start+2<=nums.length) &&  nums[start+1]==1) {
				boolean include = 	groupSum5(start+2,nums,target-nums[start]);
				boolean notInclude = groupSum5(start+2,nums,target);
				return ( include || notInclude);
			}
		}

		boolean include = 	groupSum5(start+1,nums,target-nums[start]);
		boolean notInclude = groupSum5(start+1,nums,target);

		return ( include || notInclude);
	  }
	
	
	public static boolean groupNoAdj(int start, int[] nums, int target) {
		if(start>=nums.length) {
	    	if(target==0) {
		    	   return true;
		    }else {
		    	return false;
		    }
	    }
		
		boolean include = 	groupNoAdj(start+2,nums,target-nums[start]);
	    boolean notInclude = groupNoAdj(start+1,nums,target);
	    return   ( include || notInclude);		
	}
	
	
	public static boolean groupSum6(int start, int[] nums, int target) {
		if(start>=nums.length) {
	    	if(target==0) {
		    	   return true;
		    }else {
		    	return false;
		    }
	    }
		if(nums[start]==6) {
			target=target-6;
		}
		boolean include = 	groupSum6(start+1,nums,target-nums[start]);
	    boolean notInclude = groupSum6(start+1,nums,target);
	    return   ( include || notInclude);	    
	}

	

	public static  boolean groupSum(int start, int[] nums, int target) {
	    if(start>=nums.length) {
	    	if(target==0) {
		    	   return true;
		    }else {
		    	return false;
		    }
	    }
	    boolean include = 	groupSum(start+1,nums,target-nums[start]);
	    boolean notInclude = groupSum(start+1,nums,target);
	    return   ( include || notInclude);
	}	
}
