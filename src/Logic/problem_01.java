package Logic;

import java.util.Set;
import java.util.TreeSet;

public class problem_01 {
	public static void main(String[] args) {
		//System.out.println(sumLimit(8, 3));
		//System.out.println(shareDigit(12, 43));
		//System.out.println(blueTicket(6, 1, 4));
		
		System.out.println(fizzString("fig"));
		
		
	}
	
	public static  String fizzString(String str) {
	    /*
	     
Given a string str, if the string starts with "f" return "Fizz". If the string ends with "b" return "Buzz". If both the "f" and "b"
conditions are true, return "FizzBuzz". In all other cases, return the string unchanged.
	     */
		if(str.charAt(0)=='f' && str.charAt(str.length()-1)=='b') {
			return "FizzBuzz";
		}
		
		if(str.charAt(0)=='f') {
			return "Fizz";
		}
	  
		if(str.charAt(str.length()-1)=='b') {
			return "Buzz";
		}
		return str;
	}

	
	public boolean answerCell(boolean isMorning, boolean isMom, boolean isAsleep) {
		if(isAsleep){
			return false;
		} 

		if(isMorning && isMom ){
			return true;
		}

		if(isMorning && !isMom ){
			return false;
		}

		return true;
	}



	public boolean inOrder(int a, int b, int c, boolean bOk) {
		if(bOk) {
			if(c>b) {
				return true;
			}
			return false;			
		}
		if(a<b && b<c) {
			return true;
		}
		return false;

	}

	
	
	public boolean inOrderEqual(int a, int b, int c, boolean equalOk) {
		if(equalOk) {
			if(a==b && !(b>c) || b==c && !(a>b) || a==c && !(a<b)) {
				return true;
			}			
		}
		if(a<b && b<c) {
			return true;
		}
		return false;

	}

	
	public boolean lastDigit(int a, int b, int c) {
		if( a%10==b%10 || b%10==c%10 || a%10==c%10){
			return true;
		}
		return false;
	}
	
	public static boolean lessBy10(int a, int b, int c) {
		 /*
		Given three ints, a b c, return true if one of them is 10 or more less than one of the others.
		  */
		if(Math.abs(a-b)>=10){
		    return true;
		  }  
		  
		  if(Math.abs(c-b)>=10){
		    return true;
		  }  
		  
		  if(Math.abs(a-c)>=10){
		    return true;
		  }  
		  return false;	
	}
	
	public static int withoutDoubles(int die1, int die2, boolean noDoubles) {
		  /*
		   
Return the sum of two 6-sided dice rolls, each in the range 1..6. However, if noDoubles is true, if the two dice show the same value, 
increment one die to the next value, wrapping around to 1 if its value was 6.
		   */
		if(noDoubles ==true) {
			if(die1==die2) {
				die1=(die1+1)>6 ? die1+1-6 : die1+1;
				return die1+die2;
			}
			else {
				return die1+die2;
			}	
		}
		return die1+die2;	 
		
	}

	
	public static int maxMod5(int a, int b) {
		/*
		 Given two int values, return whichever value is larger. However if the two values have the same 
		 remainder when divided by 5, then the return the smaller value. However, in all cases, if the two 
		 values are the same, return 0. Note: the % "mod" operator computes the remainder, e.g. 7 % 5 is 2.
		  */
		if(a==b) {
			return 0;
		}		
		if(a%5==b%5) {
			return a>b ? b:a;
		}
		
		return a>b ? a:b;
		
	}

	
	
	public static int redTicket(int a, int b, int c) {
		  /*
		   
You have a red lottery ticket showing ints a, b, and c, each of which is 0, 1, or 2. If they are all 
the value 2, the result is 10. Otherwise if they are all the same, the result is 5. Otherwise so long as
 both b and c are different from a, the result is 1. Otherwise the result is 0.
		   */
		if(a+b+c==6) {
			return 10;
		}
		if(a==b && b==c) {
			return 5;
		}
		if(a!=b && a!=c) {
			return 1;
		}
		
		return 0;
		   	
	}
	
	
	
	public static int greenTicket(int a, int b, int c) {
		/*
		
You have a green lottery ticket, with ints a, b, and c on it. If the numbers are all different from each other, 
the result is 0. If all of the numbers are the same, the result is 20. If two of the numbers are the same,
the result is 10. 
		 */
       Set<Integer> set= new TreeSet<Integer>();
       set.add(a);
       set.add(b);
       set.add(c);
       if(set.size()==3) {
    	   return 0;
       }
       if(set.size()==2) {
    	   return 10;
       }
       if(set.size()==1) {
    	   return 20;
       }   
       return 0;
	}
	
	
	
	public static int blueTicket(int a, int b, int c) {
		/*
You have a blue lottery ticket, with ints a, b, and c on it. This makes three pairs, which we'll call
ab, bc, and ac. Consider the sum of the numbers in each pair. If any pair sums to exactly 10, the result is 10. 
Otherwise if the ab sum is exactly 10 more than either bc or ac sums, the result is 5. Otherwise the result is 0.
		 */
		int ab= a+b;
		int bc=b+c;
		int ac= a+c;
		if(ab==10 || bc==10|| ac==10) {
			return 10;
		}
		if((ab-bc)==10 || (ab-ac)==10){
			return 5;
		}
		return 0;
	}
	
	
	
	public static boolean shareDigit(int a, int b) {
	/*
	 Given two ints, each in the range 10..99, return true if there is a digit that appears in both
	 numbers, such as the 2 in 12 and 23. (Note: division, e.g. n/10, gives the left digit while
	 the % "mod" n%10 gives the right digit.)
	 */
		char []aa = String.valueOf(a).toCharArray();
		char []bb = String.valueOf(b).toCharArray();

		if(aa[0]==bb[0]) {
			if(aa[0]!=bb[1] && aa[1]!=bb[1]) {
				return true;
			}		 
		}

		if(aa[0]==bb[1]) {
			if(aa[0]!=bb[0] && aa[1]!=bb[0]) {
				return true;
			}		 
		}

		if(aa[1]==bb[0]) {
			if(aa[1]!=bb[1] && aa[0]!=bb[0]) {
				return true;
			}		 
		}

		if(aa[1]==bb[1]) {
			if(aa[1]!=bb[0] && aa[0]!=bb[0]) {
				return true;
			}		 
		}
		return true;
	}	
	
	
	public static int sumLimit(int a, int b) {
	    /*
	     
 Given 2 non-negative ints, a and b, return their sum, so long as the sum has the same number of digits
 as a. If the sum has more digits than a, just return a without b. (Note: one way to compute the number 
 of digits of a non-negative int n is to convert it to a string with String.valueOf(n) and then check the
 length of the string.)
	     */
		int len = String.valueOf(a).length();
		int sum=a+b;
		int len_sum = String.valueOf(sum).length();
		if(len_sum > len) {
			return a;
		}
		return sum;
	}
}
