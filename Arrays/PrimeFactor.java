import java.util.*;
public class PrimeFactor {
		
	//36=2*2*3*3
	
	public static void main(String[] args) {
		
		int N;
		System.out.println("Enter thr number for prime factorization");
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		
		primeFactor(N);
		

	}
	
	public static void primeFactor(int num){
		
		int primeNum=nextPrime(0);
		
		while(num!=1){
			
			while(num%primeNum==0){
				System.out.print(""+ primeNum + "*");
			
			num=num/primeNum;
			
			}
			
			primeNum=nextPrime(primeNum);

	
		}
		
		
	}
	
	public static int nextPrime(int num){
		
		if(num<2)
			return 2;
		
		//if(num%2==0)
			//num++;
		
		while(!isPrime(++num)){
			//num++;
			
			
		}
		return num;
		
	}
	
	public static boolean isPrime(int num){
		
		if(num==2) return true;
		
		if(num<2) return false;
		
		if(num%2==0) return false;
		
		for(int i=3;i<Math.sqrt(num);i+=2){
			if(num%i==0)
				return false;
			
			
		}
		
		
		return true;
		
		
		
		
		
	}

}
