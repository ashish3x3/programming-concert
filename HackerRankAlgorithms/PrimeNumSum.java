/*
 * 
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.

 * o/p
 * 142913828922
 */
public class PrimeNumSum {

	public static void main(String[] args) {
		long sum=0;
		
		for(long i=2;i<2000000;++i){
			
			if(isPrime(i)){
				
				sum+=i;
				//System.out.println(""+i);
				
			}
			
			
			
		}
		
		System.out.println(""+sum);

	}
	
	public static boolean isPrime(long num){
		
		for(int i=2;i<=Math.sqrt(num);++i){   //for 4num=4,sqrt(4)==2  so condition is <=sqrt(4)
			
			if(num%i==0)
				return false;
			
			
		}
		return true;
		
		
	}

}
