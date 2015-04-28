
import java.util.*;

public class GcdAndLcm {

	public static void main(String[] args) {
		new GcdAndLcm().find();

	}
	
	public void find(){
		
		
		System.out.println(" Enter the two  numbers ");
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int M=scan.nextInt();
		//findGCD(N);
		findLCM(N,M);
		
		
		
		scan.close();
	}
	
	public void findLCM(int num1,int num2){
		
		int res=(num1*num2)/findGCD(num1,num2);
		System.out.println(" "+res);
		
		
	}
	
	public int findGCD(int a,int b){
		
		if(a==0) return b;
		
		return findGCD(b%a,a);
		
		
		
	}
	
}
