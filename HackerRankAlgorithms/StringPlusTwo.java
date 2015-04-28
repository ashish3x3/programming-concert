import java.util.Arrays;
import java.util.Scanner;

// a+2=c -- aac+3=aaf   changing last character
public class StringPlusTwo {

	public static void main(String[] args) {
		
		System.out.println("Enetr string  and number ::: ");
		Scanner scan=new Scanner(System.in);
		String str=null;
		str=scan.next();
		System.out.println("Enetr Number to add to last characrer");
		int num=scan.nextInt();
		stringPlusNum(str,num);
		

	}
	
	public static void stringPlusNum(String str,int n){
		
		int L= str.length()-1;
		//int result=n>0?str.charAt(L)-'a':str.charAt(L);
		
		char[] s=str.toCharArray();
		int result=s[L]-'a'+n;
		
		if(result>=0){
			
			result=result %26;
		}
		
		s[L]=(char) ('a'+result);
			
			
		System.out.println("  "+Arrays.toString(s)); 	
		}
		
		
		
	//}

}
