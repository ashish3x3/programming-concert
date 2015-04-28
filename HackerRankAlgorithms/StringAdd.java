import java.util.*;
public class StringAdd {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		String str1=null;
		String str2=null;
		
		System.out.println("enete number 1");
		str1=scan.next();
		
		System.out.println("enete number 2");
		str2=scan.next();
		
		add(str1,str2);
		

	}
	
	public static void add(String str1,String str2){
		int len=Math.max(str1.length(),str2.length());
		int ar1[] =new int [len];
		int ar2[]=new int[len];
		//System.out.println(""+str1);
		//System.out.println(""+str2);
	
		int res[] =new int [len+1];
		for(int i=0;i<str1.length();++i){
			ar1[i]=str1.charAt(str1.length()-1-i)-48;
			//System.out.println(""+ar1[len-1-i]); 
			
		}
		//System.out.println(""+Arrays.toString(ar1)); 
		
		for(int i=0;i<str1.length();++i){
			ar2[i]=str2.charAt(str2.length()-1-i)-48;
			
		}
		//System.out.println(""+Arrays.toString(ar2)); 
		
		
		int carry=0;
		
		for(int k=0;k<len;++k){
			res[k]=(ar1[k]+ar2[k]+carry)%10;
			
			if((ar1[k]+ar2[k]+carry)>9)
				carry=1;
			else 
				carry=0;
			
		}
		res[len]=carry;
		
		for(int k=len;k>=0;--k){
			
			System.out.print(""+res[k]); 
		}
		
		
	}

}

/*
 * 999999999
 * 999999999
 * == 1999999998
 * */
