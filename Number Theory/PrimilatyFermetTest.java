import java.util.Random;
import java.util.Scanner;


public class PrimilatyFermetTest {
	
	public static void main(String[] args){
		
		long num;
		
		System.out.println("Enetr the number of which You want to find prime greater than  number ");
		Scanner scan =new Scanner(System.in);
		
		num=scan.nextInt();
		PrimalityTest(num);
		
	}
	
	public static void PrimalityTest(long num){
		
		long prime=num;
		boolean yes=false;
		Random rand=new Random();
		int randomNum=rand.nextInt((prime-1)+1)+1;
		
		//fermet test
		
		
		while(yes!=true){
			
			if(((randomNum) ^ (prime-1))==(1%prime))
				yes=true;
			
			else{
				yes=false;
				prime++;
				
			}
			
			
			
		}
		
		System.out.println("The first prime number greater than " + num +" is " + prime);
		
		
	}

}
