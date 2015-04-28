import java.util.*;
public class StringToFloat {
	
	static final long MEGABYTE=1024L;

	public static void main(String[] args) {
		System.out.println("Enter the string to change to float");
		Scanner scan=new Scanner(System.in);
		//String str=scan.next();
		String str="22.33";
		long startUsual=System.nanoTime();
		double d=stringToFloat(str);
		System.out.println("1-->"+d);
		long execTime=System.nanoTime()-startUsual;
		System.out.println("without-Thraead------------>"+execTime);
		
		Runnable t1=new Runnable(){
			
			public void run(){
				//String str=scan.next();
				double d=stringToFloat("123.32e7");
				System.out.println("T1-->"+d);
			}
			
			
		};
		
		long startUsualThread=System.nanoTime();
		new Thread(t1).start();
		long execTimeThread=System.nanoTime()-startUsual;
		System.out.println("with Thread---------------->"+execTimeThread);
		
		Runnable t2=new Runnable(){
			
			public void run(){
			double d=stringToFloat("-34.54er4");
			System.out.println("T2-->"+d);
			}
			
		};
		
		new Thread(t2).start();
		
		Thread t3=new Thread(){
		
			public void run(){
				final String str="-34.54er4";
				double d=stringToFloat(str);
				System.out.println("T3-->"+d);
				
			}
			
			
		};
		
		t3.start();
		
		Runnable[] t4=new Runnable[]{
	
		new Runnable(){
			
			public void run(){
				
				final String str="-884.54er4";
				double d=stringToFloat(str);
				System.out.println("T4-->"+d);
				
			}
			
		},
		
		new Runnable(){
			
			public void run(){
				
				//Runtime runtime=Runtime.getRuntime();
				
				//long memoryBefore=runtime.totalMemory()-runtime.freeMemory();
				//System.out.println("---Memory Before--->"+memoryBefore+"  Bytes");
				final String str="-64.54";
				double d=stringToFloat(str);
				System.out.println("T5-->"+d);
				//long memoryAfter=runtime.totalMemory()-runtime.freeMemory();
				//System.out.println("---Memory After--->"+memoryAfter+"  Bytes");
				
				//System.out.println("---Memory Used--->"+(memoryAfter-memoryBefore)+"  Bytes");
				
			}
		}
	};
		Runtime runtime=Runtime.getRuntime();
		for(int i=0;i<3-1;++i){
			runtime.gc();
			long memoryBefore=runtime.totalMemory()-runtime.freeMemory();	
			new Thread(t4[i]).start();
			long memoryAfter=runtime.totalMemory()-runtime.freeMemory();
			System.out.println("---Memory Used--->"+((memoryAfter-memoryBefore)/MEGABYTE)+" Mega Bytes");
	    
		}
		
		
		

	} //main
	
	public static double stringToFloat(String str){
		
		if(str==null)
			return 0;
		
		double integerPart=0;
		float fractionPart=0;
		int divisor=1;
		int i=0;
		int sign=1;
		boolean isFraction=false;
		
			
			if(str.charAt(i)=='-'){
				sign*=-1;
				i++;
				
			}
			else if(str.charAt(i)=='+'){
				
				i++;
				
			}
			while(i<str.length()){                 //while(arr[i]==' ') 
				if(isSpecialChar(str.charAt(i)))    //to stop at special char 12*54==12.0
					return sign*(integerPart+fractionPart/divisor); 
			 if((str.charAt(i)>='0' && str.charAt(i)<='9') ){
				
				
				if(isFraction){
				
				fractionPart=fractionPart*10+(str.charAt(i)-'0');
				divisor*=10;
				
			}
			  else {
				  
				  integerPart=integerPart*10+(str.charAt(i)-'0');
				  
			  }
			
		      }
			
			else if(str.charAt(i)=='.'){
				
				if(isFraction){
					return sign*(integerPart+fractionPart/divisor);
					
				}
				else
				  isFraction=true;
				
				
			}
			 
			//else   // for case 1cd123.65gh==123.65
				//return sign*(integerPart+fractionPart/divisor);
			
			i++;
			
		}
		
		
		
		return sign*(integerPart+fractionPart/divisor);
	}
	
	public static boolean isSpecialChar(char ch){
		
		if((ch>='a'&&ch<='z')||(ch>='A' ||ch<='Z')&&( ch>='0'&& ch<='9' ||ch=='.'))
			return false;
		
		return true;
		
		
		
	}

}
/* All passed Test Cases
 * 
 * Fun time - Breaking the code
1. Pass NULL/empty string
2. Pass string with +ve and -ve sign, +2.0/-5.5
3. Pass pure character string. What is expected?
4. Pass mix of character and numbers, 2.33abc/2abc/2.abc
5. Check what happens if string passed results in overflow/underflow, our code doesn't take care of it
6. String with leading/trailing zeroes, +0000.002/-1.0000
7. Pass all zeroes, 0.000/000
8. What happens if there are more than one decimal point like 1.234.5/1..2?
9. Also look for some corner cases like +.1/-.2/etc. These are all valid cases.
Pass a string with alphabets in it, it should return the number till the point where alphabets end.
Pass a string with special characters in the string like "*" or "," and ".". 
It should convert number only till the special character.
 * 
 *  
 *  */
 