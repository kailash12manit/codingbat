package Strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pattern_example {
	public static void main(String[] args) {
		
		System.out.println(catDog("catxxdogxxxdog"));		
		
	}
	
	public static boolean catDog(String str) {
		//System.out.println(str);
		
		int i=0;
		Pattern p = Pattern.compile("cat");
		Matcher m = p.matcher(str);
		while(m.find()) {
			i++;
		}
		System.out.println("cat : "+i);
		int j=0;
		Pattern d = Pattern.compile("dog");
		m = d.matcher(str);
		while(m.find()) {
			j++;
		}
		System.out.println("cat : "+j);
		
		return true;
		
		
	}

}
