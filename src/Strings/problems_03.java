package Strings;

public class problems_03 {
	public static void main(String[] args) {

		System.out.println(countYZ("fez day"));
		System.out.println(withoutString("Hello there", "llo"));
		System.out.println(equalIsNot("This is not") );
		System.out.println(gHappy("xxggxx") );
		System.out.println(countTriple("abcXXXabc") );
		System.out.println(sumDigits("aa1bc2d3"));
		System.out.println(sameEnds("abXYab"));
		System.out.println(mirrorEnds("abXYZba"));
		System.out.println(maxBlock("hoopla"));
		System.out.println(sumNumbers("abc123xyz14") );
		System.out.println(notReplace("is test") );
	}

	public static String notReplace(String str) {
		StringBuilder sb =  new StringBuilder();
		int len=str.length();
		if(len==0){
			return "";
		}
		for(int i=0;i<len;i++){
			if( i-1 >=0 && Character.isLetter(str.charAt(i-1))
					|| (i+2<len && Character.isLetter(str.charAt(i+2)))){
				sb.append(""+str.charAt(i));
			}
			else if(i+1<len && str.substring(i,i+2).equals("is")){
				sb.append("is not");
				i++;
			}
			else{
				sb.append(""+str.charAt(i));
			}
		}
		return sb.toString();
	}


	public static int sumNumbers(String str) {
		int sum=0;
		for(int i=0;i<str.length();i++){
			if(Character.isDigit(str.charAt(i))){
				int j=0;
				for(j=i+1;j<str.length();j++){
					if(!Character.isDigit(str.charAt(j))){
						break;
					}
				}
				sum+=Integer.parseInt(str.substring(i,j));
				i=j;
			}
		}
		return sum;
	}

	public static int maxBlock(String str) {
		int res=0;
		int len=str.length(); 
		int temp=1;
		if(len==0){
			return 0;
		}

		for(int i=0;i<len;i++){
			if( i<len-1  && str.charAt(i)==str.charAt(i+1)){
				temp++;
			}
			else{
				temp=1;
			}

			if(temp>res){
				res=temp;
			}
		}
		return res;
	}



	public static String mirrorEnds(String str) {
		String res="";
		int len=str.length();
		for(int i=0;i<len;i++){
			if(str.charAt(i)==str.charAt(len-i-1)){
				res+=str.charAt(i);
			}
			else{
				return res;
			}
		}
		return res;
	}



	public static String sameEnds(String str) {
		if(str==null){
			return "";
		}
		String front="";
		String end="";
		for(int i=str.length()/2;i>=0;i--){
			front=str.substring(0,i);
			end=str.substring(str.length()-i);
			if(front.equals(end)){
				break;
			}		  
		}
		return front;		
	}


	public static int sumDigits(String str) {
		int sum=0;  
		for(int i=0;i<str.length();i++){
			if(Character.isDigit(str.charAt(i))){
				sum+=Integer.parseInt(""+str.charAt(i));
			}
		}		
		return sum;
	}


	public static int countTriple(String str) {
		int count=0;
		for(int i=0;i<str.length()-2;i++){
			if(str.charAt(i)==str.charAt(i+1) && str.charAt(i+1)==str.charAt(i+2)){
				count++;
			}
		}
		return count;
	}


	public static boolean gHappy(String str) {
		int len=str.length();
		boolean happy=true;

		for(int i=0;i<len;i++){
			if(str.charAt(i)=='g'){
				if(i>0 && str.charAt(i-1)=='g'){
					happy=true;
				}
				else if(i<len-1 && str.charAt(i+1)=='g'){
					happy=true;
				}
				else{
					happy=false;
				}
			}

		}
		return happy;
	}



	public static boolean equalIsNot(String str) {
		int is_count=0;
		int not_count=0;
		int len=str.length();

		for(int i=0;i<len;i++){
			if(i<len-2){
				String temp = str.substring(i,i+3);
				if(temp.equals("not")){
					not_count++;
				}
			}
			if(i<len-1){
				String temp = str.substring(i,i+2);
				if(temp.equals("is")){
					is_count++;
				}
			}    	
		}
		if(is_count==not_count){
			return true;
		}
		else{
			return false;
		}
	}


	public static String withoutString(String base, String remove) {

		int index=0;
		remove=remove.toLowerCase();
		int remlen=remove.length();

		while(true){
			index=base.toLowerCase().indexOf(remove);
			if(index==-1){
				break;
			}
			else{
				base = base.substring(0,index)+base.substring(index+remlen);
			}
		}		  
		return base; 
	}


	public static  int countYZ(String str) {
		int count=0;
		int len=str.length();
		str=str.toLowerCase();

		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='y' || str.charAt(i)=='z') {
				if(i<len-1 && !Character.isLetter(str.charAt(i+1))) {
					count++;
				}
				else if(i==len-1){
					count++;
				}
			}
		}
		return count;
	}	
}
