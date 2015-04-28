import java.util.*;
public class StringDivideReverse {
	
	public static void main(String [] args){
		
	String str= "This";
	int [] num = {1,2,3,4,5,6,7,8};
	String reverse=reverseDivide(str);
	int [] num1= reverseNumDivide(num,0,num.length-1);
	
	String charstr="Ashish";
	char [] characters=charstr.toCharArray();
	char [] revchar=new char[characters.length];
	
	for(int i=0;i<characters.length;++i){
		revchar[i]=characters[(characters.length-1)-i];
		
		
	}
	String revchar1=new String(revchar);
	System.out.println(""+revchar1);
	
	String str2= new StringBuffer("Ashish").reverse().toString();
	System.out.println(""+str2);
	
	System.out.println(""+reverse);
	System.out.println(""+Arrays.toString(num1));
	
	}

	public static String reverseDivide(String str){
		if(str.length()<=1)
			return str;
		
		else{
		return  reverseDivide(str.substring(str.length()/2,str.length()))+reverseDivide(str.substring(0,str.length()/2));
			
		}
		
		
	}
	
	public static int[] reverseNumDivide(int[] num,int start,int end){
		if(start<end){
			int t=num[start];
			num[start]=num[end];
			num[end]=t;
			reverseNumDivide(num,start+1,end-1);
		}
		return num;
	}
	
		
		
	}


