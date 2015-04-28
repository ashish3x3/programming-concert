import java.util.Scanner;


public class UglyNumDynamicProg {
	
	public static long [] arr;
	
	

	public static void main(String[] args) {
		long num;
		Scanner scan=new Scanner(System.in);
		System.out.println("Enetr the number for which yopu want to find Ugly Number");
		num=scan.nextLong();
		System.out.println("");
		System.out.println(""+num+"th "+ "Ugly number is :" + findNthUglyNumber(num));

	}
	
	public static long min(long a,long b,long c){
		if(a<b)
			b=a;
		if(b<c)
			c=b;
		
		return c;
	}
	
	public static long findNthUglyNumber(long num){ 
		
		long[] ugly=new long[(int) num];
		long nextUgly=0;
		int ugly2,ugly3,ugly5;
		ugly2=ugly3=ugly5=0;
		int i;
		
		ugly[0]=1;
		long nextMultiple2,nextMultiple3,nextMultiple5;
		nextMultiple2=2;
		nextMultiple3=3;
		nextMultiple5=5;
		
		for(i=1;i<num;++i){
		
		nextUgly = min(nextMultiple2,nextMultiple3,nextMultiple5);
		
		ugly[i]=nextUgly;
		
		if(nextUgly==nextMultiple2){
			ugly2++;
			nextMultiple2 = ugly[(int) ugly2]*2;
		}
		
		if(nextUgly==nextMultiple3){
			ugly3++;
			nextMultiple3 = ugly[(int) ugly3]*3;
		}
		
		if(nextUgly==nextMultiple5){
			ugly5++;
			nextMultiple5 = ugly[(int) ugly5]*5;
		}
		
		
		
	} 
		return nextUgly;
	
	

}
	
}
