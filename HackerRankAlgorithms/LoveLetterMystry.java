import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LoveLetterMystry {

    public static void main(String[] args) {
    	
    	Scanner scan=new Scanner(System.in);
    	String str;
    	int T;
    	T=scan.nextInt();
    	
    	int [] ans=new int[T];
    	int m=0;
    	if(T>0 && T<=10){
    	while(T>0){
    		
    		//System.out.println(""+T);
    	str=scan.next();
    	if(str.length()>=1 && str.length()<=Math.pow(10, 4)){ 
    		
    	ans[m]=findCount(str.toLowerCase());
    	
    	
          }  //if power
    	
    	m++;
    	T--;
    	//System.out.println(""+T);
    	
    	}// while
    	
    	}//if T>=0
    	
    	for(int k=0;k<ans.length;++k)
    		System.out.println(""+ ans[k]);
        
    } //main
    
    
    public static int findCount(String str){
    	
    	char[] str1=str.toCharArray();
    	//str1=str.toCharArray();
    	//System.out.println(""+Arrays.toString(str1)); 
    	int count=0;
    	int temp=0;
    	for(int i=0,j=str1.length-1;i<j;++i,--j){
    		
    		if(str1[i]!=str1[j]){
    			
    			temp=Math.abs(str1[j]-str1[i]);
    		       count+=temp;
    		       }
    		}
    			
    		
    	
    	
    	
    	/*char[] str1=new char[str.length()];
    	str1=str.toCharArray();
    	System.out.println(""+Arrays.toString(str1)); 
    	int count=0;
    	for(int i=0,j=str1.length-1;i<=str1.length/2;++i,--j){
    		
    		while(str1[i]!=str1[j]){
    			if(str1[i]<str1[j]){
    		       if(str1[j]--!='a');	{
    		           count++;
    		       }
    			}
    			
    		}
    		
    		//String str2=Arrays.toString(str1);
    		//System.out.println(""+str2);
    		//System.out.println(""+count);
    		 
    		
    		 
    		
    	}
    	*/
    	
    	return count;
    	
    	
    	
    	
    	
    }  //findCount
    
    
    
    
    
} // class