import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ServiceLane {
	
	public static void main(String [] args){
		Scanner scan =new Scanner(System.in);
		int N;
		N=scan.nextInt();
		if(N>=100000 && N<=2){
			System.out.println("");
			//wait();
			
		}
			
			
		  int[] width=new int[N];
		  
		
		
		int T;
		T=scan.nextInt();
		
		int [] ans=new int[T];
		
		for(int i=0;i<N;++i)
			width[i]=scan.nextInt();
		
		int m=0;
		int i,j;
		
		if(T>=1 && T<=1000){
			
			while(T>0){
				
				i=scan.nextInt();
				j=scan.nextInt();
				try{
				if((i>=0 && i<j) && (j>=0 && j<N)){
				   ans[m]=calc(width,i,j);
				}
				
				}  //try
				catch (InputMismatchException inputExepction) {
					
					System.out.println("wrong input");
				} //catch
				
				
				//}//if
				
				T--;
				m++;
				
			} //end of while
			
			//System.out.println(""+Arrays.toString(ans)); 
			
			for(int k=0;k<=ans.length-1;++k){
	    		System.out.println(""+ans[k]);
	    		
	    	}
			
			
		} //end of if
		
		
		
		
		scan.close();
	} // end of main
	
	
	public static int calc(int[] width,int i,int j){
		
		int [] arr=new int[j-i+1];
		for(int m=i,n=0;m<=j;++m,n++){
			arr[n]=width[m];
			
			
		} //for
		
		//System.out.println(""+Arrays.toString(arr)); 
		Arrays.sort(arr); 
		//System.out.println(""+Arrays.toString(arr)); 
		
		return arr[0];
		
	}
	
	
	

}  //end of class
