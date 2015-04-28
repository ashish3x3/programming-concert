import java.math.BigInteger;
import java.util.*;

public class BigNumberInteger {

	public static void main(String[] args) {
		int N;
		Scanner scan=new Scanner(System.in);
		String a=null;
		N=scan.nextInt();
		long [] arr=new long[N];
		long max=0;
		for(int i=0;i<N;++i){
			
			a=scan.next();
			
			arr[i]=Long.parseLong(a);
			if(arr[i]>max)
				max=arr[i];
			
			
			
		}//for
		
		String [] str=new String[N];
		for(int j=0;j<N;++j){
			
			str[j]=bigNum(arr[j]);
			//System.out.println(" "+j+" "+ str[j]);
			System.out.println(""+ str[j]);
		}

	}//main
	
	public static String bigNum(long ar){
		BigInteger g1=new BigInteger("1");
		BigInteger g2=new BigInteger("3");
		BigInteger g3=new BigInteger("3");
		BigInteger g4=new BigInteger("1");
		
	//	BigInteger [] big=new BigInteger[new BigInteger("5")];
		
		
		
		BigInteger a,b,c,d,e = null;
		e=e.ZERO;
		long num=0;
		if(ar>4){
		 num=ar-4;
		}
		
		while(num-->0){
			a=g4;
			b=g3.multiply(new BigInteger("3"));
			c=g2.multiply(new BigInteger("3"));
			d=g1;
			
			e=(((a.add(b)).add(c)).add(d)); 
			
			g1=g2;
			g2=g3;
			g3=g4;
			g4=e;
			
			
		}
		
		if(ar<5 && ar>0){
			if(ar==1 || ar==4) e=new BigInteger("1");
			if(ar==2 || ar==3) e=new BigInteger("3");
			
		}
		
		return e.toString();
		
	}//bigNum

}
