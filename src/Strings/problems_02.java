package Strings;

public class problems_02 {
	public static void main(String[] args) {
	
		//System.out.println(mixString("Hi", "There"));
		//System.out.println(repeatEnd("Hello", 3));
		//System.out.println(repeatFront("Chocolate", 4));
		//System.out.println(repeatSeparator("Word", "X", 3));
		//System.out.println(prefixAgain("abXYabc", 3));
		//System.out.println(xyzMiddle("xyzxyzxyzBxyzxyz"));
		//System.out.println(getSandwich("breadjambread"));
		//System.out.println(sameStarChar("*xa*az"));
		//System.out.println(oneTwo("tcagdo"));
	    //System.out.println(zipZap("zi"));// zpzp
		//System.out.println(starOut("ab**cd"));
		//System.out.println(plusOut("12xy34", "xy"));
		System.out.println(wordEnds("abcXY123XYijk", "XY"));
	}
	
	
	public static String wordEnds(String str, String word) {
		  String res="";
				int i = str.indexOf(word);
				while(i!=-1){
					if(i!=0){
						res+=str.charAt(i-1);
					}
					if(i+word.length()==str.length()){
						break;
					}
					res+=str.charAt(i+word.length());
					i=str.indexOf(word,i+1);		
				}
				return res;	
	}
	
	public static String plusOut(String str, String word) {
		  String res="";
				int index = str.indexOf(word);
				while(index!=-1){
					for(int i=0;i<index;i++){
						res+="+";
					}
					res+=word;
					str= str.substring(index+word.length());
					
					index = str.indexOf(word);
				}
				for(int i=0;i<str.length();i++){
					res+="+";
				}	
				return res;		
	}
	
	public static String starOut(String str) {
		StringBuilder  sb = new StringBuilder();
		
	 	for(int i=0;i<str.length();i++){
	 		if(str.charAt(i)=='*'){
	 			continue;
	 		}
	 		if(i>0 && str.charAt(i-1)=='*'){
	 			continue;
	 		}
	 		if(i<str.length()-1 && str.charAt(i+1)=='*'){
	 			continue;
	 		}
	 		sb.append(str.charAt(i));	 		
	 	}
	 	return sb.toString();
	}
	
	public static String zipZap(String str) {
		int len = str.length();		
        String res = "";
        for(int i=0;i<len;i++) {
             res+=str.substring(i,i+1);
             if(i>0 && i<len-1) {
            	 if(str.charAt(i-1)=='z' && str.charAt(i+1)=='p') {
            		 res= res.substring(0,res.length()-1);            	 
            	 } 
             }        	
        }
		return res;
	}

	
	public static String oneTwo(String str) {
		String res="";
		int len = str.length();
		
		for(int i=0;i<len-2;i++) {
			res+=(""+str.charAt(i+1)+""+str.charAt(i+2));
			res+=(""+str.charAt(i));
		    i=i+2;
		    System.out.println(res);
		}
			
		return res;
	}

	
	
	public static boolean sameStarChar(String str) {
		int len=str.length();
		boolean res=true;
		for(int i=0 ; i  < len ; i++) {
			String sub = str.substring(i,i+1);
			if(sub.equals("*") && i>0 && i < len-1 ) {
				if(str.charAt(i-1)==str.charAt(i+1)) {
					res=true;
				}
				else {
					res=false;
				}
			}
		}
		return res;
	}
	
	public static String getSandwich(String str) {
		String res = "";
		int f = str.indexOf("bread");
		int l = str.lastIndexOf("bread");
		if(f==l) {
			return res;
		}
		res=str.substring(f+5,l);
		
		return res; 
	}
	
	public static boolean xyzMiddle(String str) {
		String sub="xyz";
		int len=str.length();
		System.out.println("len "+len);
		int middle = len/2;
		if(len<3) {
			return false;
		}
		if(len%2!=0) { //odd
			if(sub.equals(str.substring(middle-1, middle+2))) {
				return true;
			}
			else {
				return false;
			}			
		}
		if(len%2==0) {
			if(sub.equals(str.substring(middle-1, middle+2)) || sub.equals(str.substring(middle-2, middle+1)) ) {
				return true;				
			}
			else {
				return false;
			}
		}
		return false;
		
	}	
	
	public static boolean prefixAgain(String str, int n) {
	    		
		String sub = str.substring(0,n);
		str = str.substring(n);
		if(str.contains(""+sub)) {
			return true;
		}
		else {
			return false;
		}			
	}
	
	
	
	public static String repeatSeparator(String word, String sep, int count) {
		if(count==0) {
			return "";
		}
		if(count==1) {
			return word;
		}
		
		String res = "";
		int k1=count;
		int k2=count-1;
		int flag=0;
		do {
			if(flag==0) {
				res+=word;
				k1--;
				flag=1;
			}
			else {
				res+=sep;
				k2--;
				flag=0;
			}	
		}while(k1>=0 && k2>0);
		
		return res+word;
	}

	
	public static String repeatFront(String str, int n) {
		String res="";  
		if(n==0) {
			return res;
		}
		int len=str.length();
		if(len==0) {
			return res;
		}
		String sub = str.substring(0,n);
		int len2=sub.length();
		while(len2>=1) {
			res+=sub.substring(0,len2);
			len2--;
		}		
		
		return res;
		
	}


	private static String repeatEnd(String str, int n) {
		// TODO Auto-generated method stub
		if(n==0) {
			return "";
		}
		int len = str.length();
		String res="";
		for(int i=0;i<n;i++) {
			res+=""+str.substring(len-n);
		}	
		return res;
	}

	public static String mixString(String a, String b) {
		int len1=a.length();
		int len2=b.length();
		String res = "";
		int i=0;
		int j=0;
		int k=0;
		
		if(len1==0) {
			return b;
		}
		if(len2==0) {
			return a;
		}
		
		for(k=0;k<(len1+len2);k++) {
			if(k%2==0) {
				if(i<len1) {
					res+=""+a.charAt(i);
					i++;
				}else {
					break;
				}
			}
			else {
				if(j<len2) {
					res+=""+b.charAt(j);
					j++;
				}
				else {
					break;
				}
			}
		}
		if(i==len1) {
			res+=""+b.substring(j);
		}
		
		if(j==len2) {
			res+=""+a.substring(i);
		}
		
		return res.toString();
	
		
	}
	
}
