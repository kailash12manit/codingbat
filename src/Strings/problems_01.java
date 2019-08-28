package Strings;

import java.security.spec.EncodedKeySpec;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class problems_01 {
	public static void main(String[] args) {
		problems_01 m = new problems_01();
		
		String str = "dsadasly";
		//System.out.println(m.endsLy(str));
		//System.out.println(m.nTwice(str, 2));
		//System.out.println(startWord("hippo","xip"));
		//System.out.println(withoutX("xHix")); 
		//System.out.println(withoutX2("Hix"));
		//System.out.println(countHi("ABChi hi"));
		//System.out.println(catDog("catxdogxdogxcat"));
		//System.out.println(countCode("cozcop"));

	}
	
	public boolean endsLy(String str) {
		  return str.endsWith("ly");
	}
	
	public String nTwice(String str, int n) {
		  int len=str.length();
		  if(len==2){
		    return str;
		  }
		  else{
		    return str.substring(0,n)+str.substring(len-n);
		  }
	}
	
	public static String startWord(String str, String word) {
		int len1=str.length();
		  int len2 = word.length();
		  
		  if(len1<len2){
		    return "";
		  }
		  
		  if(len2==0 || len2==1){
		    return ""+str.charAt(0);
		  }
		  String s1 = str.substring(1,len2);
		  String s2 = word.substring(1,len2); 
		  
		  if(s1.equals(s2)){
		     return str.substring(0,len2);
		  }
		  else{
		    return "";
		  }
	}
	public static String withoutX(String str) {
		  if(str.startsWith("x")){
		    str=str.replaceFirst("x","");
		  }
		  if(str.endsWith("x")){
		    str= str.substring(0,str.length()-1);
		  }
		  return str;
	}

	public static String withoutX2(String str) {
		int len =  str.length();
		if(len==0){
			return "";
		}
		if(len==1){
			if(str.charAt(0)=='x'){
				return "";
			}
		}

		if(len==2){
			String s1 = ""+str.charAt(0);
			String s2 = ""+str.charAt(1);

			if(s1.equals("x")){
				if(s2.equals("x")){
					return "";
				}
				else{
					return ""+str.charAt(1);
				}
			}
			else{
				if(s2.equals("x")){
					return ""+str.charAt(0);
				}
				else{
					return str;
				}
			}
		}

		if(len>2){    // Hix
			String s1 = ""+str.charAt(0);
			String s2 = ""+str.charAt(1);

			if(s1.equals("x")){
				if(s2.equals("x")){
					return str.substring(2);
				}
				else{
					return str.substring(1);
				}
			}
			else {
				if(s2.equals("x")){
					return ""+str.charAt(0)+str.substring(2);
				}
				else{
					return str;
				}
			}
		}
		return str;
	}

	public static int countHi(String str) {		
   	    str=str.trim();
	    str=str.replaceAll("hi","+");
	    int temp=0;
	    char[]arr = str.toCharArray();
	    for(char kk : arr) {
	    	if(kk=='+') {
	    		temp++;
	    	}
	    }
		return temp;
	}
	
	public static boolean catDog(String str) {
		/*
		 Return true if the string "cat" and "dog" appear the same number of times in the given string.
		 */
		
		System.out.println(str);
		String arr = str;
		
		
		int index = str.indexOf("cat");
		int count = 0;
		while (index != -1) {
		    count++;
		    str = str.substring(index + 1);
		    index = str.indexOf("cat");
		}
		//System.out.println("No of cat in the input is : " + count);
		
		
		index = arr.indexOf("dog");
		int count2 = 0;
		while (index != -1) {
		    count2++;
		    arr = arr.substring(index + 1);
		    index = arr.indexOf("dog");
		}
		//System.out.println("No of dog in the input is : " + count2);
		
		if(count==count2) {
			return true;
		}
		return false;
		
	}

	public static int countCode(String str) {
		System.out.println(str);
		//Return the number of times that the string "code" appears anywhere in the given string, 
		//except we'll accept any letter for the 'd', so "cope" and "cooe" count.
		int count=0;
		int index=str.indexOf("co");
		//System.out.println(index);
		
		while(index!=-1) {
			    if(str.length()>3 && (index+3)<=str.length()) { 
				if(str.charAt(index+3)=='e') {
					count++;
					str = str.substring(index+3);
					index=str.indexOf("co");
				}else {
					str = str.substring(index+1);
					index=str.indexOf("co");
				}	
			    }else {
			    	break;
			    }
		}
		//System.out.println(count);
		
		return count;
		  
	}

	
	
	
	

}
