
public class MultipleOf1To20 {

	public static void main(String[] args) {
	long lcm=1;
	     for(long i=2;i<=20;i++)
	     {
	         lcm=findLCM(lcm,i);
	     }   
	     System.out.println("Lcm="+lcm);
	     
	     System.out.println("Lcm="+findLCM(10,5));
	    
		
		int i = 20;
		 
		while (i %  2 != 0 || i %  3 != 0 || i %  4 != 0 || i %  5 != 0 ||
		         i %  6 != 0 || i %  7 != 0 || i %  8 != 0 || i %  9 != 0 ||
		         i % 10 != 0 || i % 11 != 0 || i % 12 != 0 || i % 13 != 0 ||
		         i % 14 != 0 || i % 15 != 0 || i % 16 != 0 || i % 17 != 0 ||
		         i % 18 != 0 || i % 19 != 0 || i % 20 != 0)
		{
		    i += 20;
		
		
	}
		System.out.println("Lcm="+i);
	}
	
	public static long findLCM(long a,long b){
		
		long lcm,hcf = 0;
	     long i=1;
	     long ger=a<b?a:b;      //less than smallest because hcf on two number can't be bigger then smaller number
	     while(i<=ger)          //when smaller number than <= as lcm (2,1) and i=1 so we need <=
	     {
	         if((a%i==0) && (b%i==0))
	             hcf=i;    //number which is highest nad multiple of both a,b
	       
	         i++;
	     }
	     System.out.print(" -- "+hcf);
	     lcm=(a*b)/hcf;
	     return lcm;
		
		
	}

}
