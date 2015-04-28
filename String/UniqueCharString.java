import java.util.Arrays;
import java.util.Scanner;


public class UniqueCharString {
	
	public static void main(String [] args){
		
		String str;
		System.out.println("enter the string");
		Scanner scan =new Scanner(System.in);
		str=scan.nextLine();
		boolean res=isUniqueCharString(str);
		if(res!=false)
			System.out.println("Yes all Unique Character");
		else
			System.out.println("NOT all Unique Character");
			
	}
	
	public static Boolean isUniqueCharString(String str){
		
		/*
		boolean[] mask= new boolean[256];
		for(int i=0; i < str.length();++i){
			if (mask[str.charAt(i)])
				return false;
		    mask[str.charAt(i)]=true;
		}
		    
		    return true;
	*/
		
		/*
		char[] char1=str.toCharArray();
		Arrays.sort(char1);
		for(int i=0;i<char1.length-1;++i){
			if(char1[i]==char1[i+1])
				return false;
		}
		return true;
		*/
		char[] str1=str.toCharArray();
		for (int x = 0; x < str1.length; x++)
	    {
	        for (int y = 0; y < str.length(); y++)
	        {
	            if (str1[x] == str1[y] && x != y) 
	            	return false;
	        }
	    }
	    return true;
				 
		
		
		
	} //end of function
	
	
	
    
} //end of class


