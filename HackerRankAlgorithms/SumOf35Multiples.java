// Sum of all number which are multiplesof 3 and 5 below 1000
//eg. 10=3,5,6,9=23
public class SumOf35Multiples {

	public static void main(String [] args){
		
		int sum=0;
		for(int i=0;i<1000;++i){
			
			if(i%3==0 || i%5==0 ){
				
				sum+=i;
				
			}
			
			
		}
		
		System.out.println(""+sum);
		
		
		
		
	}
	
	
}
