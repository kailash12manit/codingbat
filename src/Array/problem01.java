package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class problem01 {
	public static void main(String[] args) {
		int[] arr = {1,2,6};
		//System.out.println(firstLast6(arr));
		//System.out.println(sum3(arr));
		//System.out.println(rotateLeft3(arr));   //rotateLeft3([1, 2, 3]) → [2, 3, 1]
		//System.out.println(reverse3(arr));
		System.out.println(has23(arr));
		
	}
	
	public static boolean has23(int[] arr) {
		  List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
			return (list.contains(2) ||list.contains(3) );
		  
		}

	
	public static int reverse3(int[] arr) {
	    int len=arr.length;
	    int res[]=new int[len];
	    for(int i=len-1;i>=0;i--) {
	    	res[len-i-1]=arr[i];
	    }
	    return 1;
	}

	
	
	public static int rotateLeft3(int[] arr) {
	    int len=arr.length;
	    for(int i=0;i<len-1;i++) {
	    	int temp = arr[i];
	    	arr[i]=arr[i+1];
	    	arr[i+1]=temp;
	    }  
	    List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
	    System.out.println(list);
	    System.out.println(list.contains(2));
	    
	    return 1;		  
	}
	
	public static int sum3(int[] nums) {
	      
		OptionalInt max= Arrays.stream(nums).max();
		
	      return Arrays.stream(nums).sum();
	    		  
	}
	
	public static  boolean firstLast6(int[] arr) {
		int len=arr.length;
		if(arr[0]==6 || arr[len-1]==6) {
			return true;
		}
		else {
			return false;
		}
	}		
}

