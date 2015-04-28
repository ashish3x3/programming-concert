import java.util.Scanner;


public class UglyNumbers {

	public static void main(String[] args) {
		long num;
		Scanner scan=new Scanner(System.in);
		System.out.println("Enetr the number for which yopu want to find Ugly Number");
		num=scan.nextLong();
		System.out.println("");
		System.out.println(""+num+"th "+ "Ugly number is :" + findNthUglyNumber(num));

	}
	
	public static long findNthUglyNumber(long num){
		
		long i=1;
		long count=1;
		while(num>count){
			
			i++;
			if(isUgly(i))
				count++;
			
		}
		
		/*
		 * in case of find nth no of seq 2,3,4,5,6,8,10,12  where each is either 
		 * divisible by 2,3,5
		 * but 1 is absent so you have to make adjustment by making num>=count and count=i=2 not 1
		 * if(num==1)
			return 2;
		long i=2;
		long count=2;
		while(num>=count){
			
			i++;
			if(isUgly(i))
				count++;
			
		}
		*/
		
		return i;
	}
	
	public static boolean isUgly(long num){
		//long no;
		num=findUgly(num,2);
		System.out.print("" + num );
		num=findUgly(num,3);
		num=findUgly(num,5);
		return num==1?true:false;
	}
	
	public static long findUgly(long a ,int b){
		 while(a%b==0)
			 a=a/b;
		
		return a;
	}

}
