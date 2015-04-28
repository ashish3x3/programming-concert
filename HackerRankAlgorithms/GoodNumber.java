import java.math.BigInteger;
import java.util.*;
public class GoodNumber {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N;
		String str=null;
		N=scan.nextInt();
		//long [] arr=new long[N];
		BigInteger [] b=new BigInteger[N];
		BigInteger big=null;
		for(int i=0;i<N;++i){
			str=scan.next();
			
			b[i]=new BigInteger(str);
		}
			
		isGood(b);
		
	}//main
	
	public static void isGood(BigInteger[] arr){
		
		BigInteger [] bin=new BigInteger[64];
		for(int i=0;i<arr.length;++i){
			
			bin=toBinary(arr[i]);
			BigInteger k=arr[i];
			BigInteger j=new BigInteger("0"); 
			//System.out.println(" "+ bitCount(str));
			do{
				k=k.add(new BigInteger("1"));
				 j=k;
				// System.out.println(" "+ bitCount(bin));
				// System.out.println(" "+ bitCount(toBinary(j)));
				
			}while(!(bitCount(bin).equals(bitCount(toBinary(j)))));
			
			System.out.println(" "+ j);
			
			
		}//for
		
		
		
	}//isGood
	
	public static BigInteger[] toBinary(BigInteger number){
		BigInteger [] remainder=new BigInteger[64];
		
		
		int k=0;
		while(number.compareTo(new BigInteger("0"))!=0){
        

        remainder[k] = number.mod(new BigInteger("2"));  
        
        k++;
        number=number.divide(new BigInteger("2")); 
		}
		
		return remainder;
			
		}
       
        
		
		
		
	
	
	public static  String bitCount(BigInteger[] str){
		//System.out.println(""+Arrays.toString(str)); 
		BigInteger count=new BigInteger("0"); 
		for(int i=0;i<str.length;++i){
			if(str[i]!=null){
			if(str[i].compareTo(new BigInteger("1"))==0){
				count=count.add(new BigInteger("1"));
			}
			}
			
		}
		
		
		return count.toString();
	}
	
	

}
