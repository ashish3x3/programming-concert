import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class UtopianTree {

    public static void main(String[] args) {
    	int testCase;
    	int cycle;
    	System.out.println("Enter Test cases ");
    	Scanner scan=new Scanner(System.in);
    	testCase=scan.nextInt();
    	int copy=testCase;
    	int[] ans= new int[testCase+1];
    	ans[0]=1;
    	int i=1;
    	int height=1;
    	
    	if(testCase>=1 && testCase<=10){
    	while(testCase>0){
    		cycle=scan.nextInt();
    		
    		if(cycle>=0 && cycle<=60){
    		ans[i]=utopianTree(cycle,false,height);
    		i++;
    		testCase--;
    		
    		
    		
    	  }
    	}
    }
    	if(copy==0)
    		System.out.println("--"+ans[0]);
    	
    	else{
    		
    	for(int j=1;j<=ans.length-1;++j){
    		System.out.println(""+ans[j]);
    		
    	}
    }	
    	  
    		
    		
    	
    	
    	scan.close();
    }
    
    public static int utopianTree(int cycle,boolean first,int height){
		
		if(cycle==0)
			return height;
		
		if(!first){
			height=height*2;
			return utopianTree(cycle-1,true,height);
		}
		else{
			
			height=height+1;
			return utopianTree(cycle-1,false,height);
			
		}
		
		
		
	}
    
   
}