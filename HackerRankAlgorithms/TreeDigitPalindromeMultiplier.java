/*
 * A palindromic number reads the same both ways. The largest palindrome made from 
 * the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
*/
 
public class TreeDigitPalindromeMultiplier {

	public static void main(String[] args) {
		
		boolean flag=false;
		int sum=0;
		int I=0,J=0;
		for(int i=100;i<999;++i){
			for(int j=100;j<999;++j){
				
				if(isPalindrome(i*j)){
					if(sum<i*j){
					sum=i*j;
					I=i;
					J=j;
					}
					
				//flag=true;
				//	break;
				}
				
			}
			//if(flag==true)
		//	break;
			
		}
		System.out.println("i= "+I+"  j= "+J+ "  "+sum);

	}
	
	public static boolean isPalindrome(int num){
		
		int N=num;
		int deg,rev=0;
		while(N!=0){
			deg=N%10;
			rev=rev*10+deg;
			N=N/10;
			
			
		}
		
		return(rev==num);
		
		
		
	}

}
