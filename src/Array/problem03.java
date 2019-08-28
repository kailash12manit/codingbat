package Array;

import java.util.Arrays;

public class problem03 {

	public static void main(String[] args) {
		
		int arr[]= {1, 2, 3, 8, 9, 3, 2, 1}; 
		
		
		//System.out.println(maxSpan(arr));
		//fix34(arr);
		//fix45(arr);
		//System.out.println(canBalance(arr));
		int []out= {2, 2, 2, 2, 2};
		int []inner= {2, 4};
		
		//System.out.println(linearIn(out,inner));
		//squareUp(3);
		//seriesUp(3);
		System.out.println(maxMirror(arr));
	}
	
	public static int maxMirror(int[] nums) {
	       int max=0;
	        for(int start=0 ;start<nums.length;start++) {
	        	for(int begin=nums.length-1;begin>=0;begin--) {
	        		int size=0;
	        		int i=start;
	        		int j=begin;
	        		
	        		while(i<nums.length && j>0 && nums[i]==nums[j]) {
	        			size++;
	        			i++;
	        			j--;
	        		}
	        		max=Math.max(max,size);
	        		
	        	}
	        }
	       return max;
	}

	
	
	public static void seriesUp(int n) {
		int res[]= new int[n*(n+1)/2];
		int k=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				 res[k]=j+1;
				 k++;
			}		
		}		
		for(int kk:res) {
			  System.out.print(kk+" ");
		}
		
	}
	

	public static void squareUp(int n) {
		  int k=0;
		  int res[]= new int[n*n];
		  for(int i=0;i<n;i++) {
			  int j=0;
			  for(j=0;j<n-i-1;j++) {
				  res[k]=0; 
				  k++;
			  }
			 while(j<n) {
				  res[k]=n-j;
				  j++;
				  k++;
			  }	
		  }
		  /*		
		  for(int kk:res) {
			  System.out.print(kk+" ");
		  }
		  */
		  
	}
	
	public static boolean linearIn(int[] outer, int[] inner) {
		    int found=0;
			int out_len=outer.length;
			if(inner.length==0){
			  return true;
			}
			int k=0;
			for(int i=0;i<out_len;i++) {
				if(outer[i]==inner[k]) {
					found++;
					k++;
				}
				else if(outer[i]>inner[k]) {
					return false;
				}				
				if(found==inner.length) {
					return true;
				}
			}
			return false;		
			
	}

	
	
	public static boolean canBalance(int[] nums) {
		int len= nums.length;
		if(len<2) {
			return false;
		}
		for(int i=0;i<len;i++) {
			int sumpre=0;
			int sumpost=0;
			for(int j=0;j<i;j++) {
				sumpre+=nums[j];
			}
			for(int j=i+1;j<len;j++) {
				sumpost+=nums[j];
			}

			if( (sumpre+nums[i]==sumpost)||  (sumpre==nums[i]+sumpost) )
			{
				return true;

			}			
		}
		return false;

	}
	
	
	public static void fix45(int[] nums) {
		int len = nums.length;
		for(int i=0;i<len-1 ;i++) {
			int found=0;
			//System.out.println(" i: "+i+" found: "+found+" nums[i] "+nums[i]);
			if(nums[i]==4 && nums[i+1]!=5) {
			for(int j=i+1;j<len;j++) {
					if(nums[j]==5) {
						int temp=nums[j];
						nums[j]=nums[i+1];
						nums[i+1]=temp;
						found=1;
						i++;
						break;
					}
				}			   
			}

			if(found==0) {
				//System.out.println(" i: "+i+" found: "+found+" nums[i] "+nums[i]);
				if(nums[i]==4) {
					for(int j=i-1;j>=0;j--) {
						if(j>0 && nums[j]==5 && nums[j-1]!=4) {
							int temp=nums[i+1];
							nums[i+1]=nums[j];
							nums[j]=temp;
							//i++;
							found=1;
						}
						if(j==0 && nums[j]==5) {
							int temp=nums[i+1];
							nums[i+1]=nums[j];
							nums[j]=temp;
							//i++;
							found=1;
						}
						
					}
				}			   
			}
			/*
			for(int kk:nums) {
				System.out.print(kk+" ");
			}
			System.out.println();
			*/

		}	
		

		
	}	
	
	
	public static void fix34(int[] nums) {
		// [5, 3, 4, 5, 5, 5, 5, 5, 3, 4, 3, 4]
		//  5, 3, 4, 5, 5, 4, 5, 5, 3, 5, 3, 4 
		
		int len = nums.length;
		for(int i=0;i<len-1 ;i++) {
			int found=0;
			System.out.println(" i: "+i+" found: "+found+" nums[i] "+nums[i]);
			if(nums[i]==3 && nums[i+1]!=4) {				
				for(int j=i+1;j<len;j++) {
					if(nums[j]==4) {
						int temp=nums[j];
						nums[j]=nums[i+1];
						nums[i+1]=temp;
						found=1;
						i++;
						break;
					}
				}			   
			}
			
			if(found==0) {
				System.out.println(" i: "+i+" found: "+found+" nums[i] "+nums[i]);
				if(nums[i]==3) {
				  for(int j=i-1;j>0;j--) {
					if(nums[j]==4 && nums[j-1]!=3) {
						int temp=nums[i+1];
						nums[i+1]=nums[j];
						nums[j]=temp;
						found=1;
					}
				 }
				}			   
			}
			for(int kk:nums) {
				System.out.print(kk+" ");
			}
			System.out.println();
			
		}
		for(int kk:nums) {
			System.out.print(kk+" ");
		}
		System.out.println();
		
	}

	public static  int maxSpan(int[] nums) {
		int len=nums.length;
		int max=1;
		for(int i=0;i<len;i++) {
			for( int j=len-1;j>=0;j--) {
				if(i<j && nums[i]==nums[j]) {
					int temp= j-i;
					if(temp>max) {
						max=temp;
					}
				}				
			}			
		}
		return max;		
	}

}
