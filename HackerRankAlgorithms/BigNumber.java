import java.util.*;
public class BigNumber {
	
	static long M=10000007;
	
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		int N;
		N=scan.nextInt();	
		long[] arr=new long[N];
		long[] res=new long[N];
		
		for(int i=0;i<arr.length;++i){
			
			arr[i]=scan.nextLong();
			//res[i]=T(arr[i]);
			//System.out.println(" "+ arr[i]);
		}
		// find max
		for(int i=0;i<arr.length;++i){
			
			System.out.println(" "+ res[i]);
		}
		
		//long max=findMax(arr);
		
		//findBigNumber(arr,max);

	}
	
	/*public static long T(long n){
	    if (n==1 || n==4){
	       return 1;
	    } else if (n==2 || n==3){
	       return 3;
	    } else {
	       return T(n-1)+3*T(n-2)+3*T(n-3)+T(n-4);
	    }
	}
	*/
	
	public static long findMax(long[] arr) {

	   if(arr.length==0) return 0;

	     long max_value = Long.MIN_VALUE;
	    // System.out.println(" long max=" + Long.MAX_VALUE + "Integer max =" + Integer.MAX_VALUE);

	    for ( long value : arr ) {
	        if ( value > max_value ) {
	            max_value = value;
	        }
	    }

	    return max_value;
	}
	
	public static void findBigNumber(long [] arr,long max){
		
		if(max>Integer.MAX_VALUE){
		  int maxHalf1=(int) (max % Math.pow(2, 25)); 
		  int maxHalf2=(int) (max-maxHalf1);
		  System.out.println(" maxhalf1= "+maxHalf1 );
		 long [] g=new long[maxHalf1+1];
		 long [] g1=new long[maxHalf1+1];
		 g[0]=0;
		 g[1]=1;
		 g[2]=3;
		 g[3]=3;
		 g[4]=1;
		 long a,b,c,d;
		 for(int i=5;i<maxHalf1;++i){
			 a=g[i-1]% M;
			// b=3*(g[i-2]%M);
			 b=(3*(g[i-2]))%M;
			// c=3*(g[i-3]%M);
			 c=(3*(g[i-3]))%M;
			 d=g[i-4]%M;
			 
			 g[i]=(a+b+c+d)%M;
			 
		 }
		 int count=0;
		 int len=g.length;
		 for(int j=0;j<maxHalf2;++j){
			 if(j<=3){
				 count++;
				 if(count==1){  //g[5]
					 a=g[len-1]%M;
					 b=(3*g[len-2])%M;
					 c=(3*g[len-3])%M;
					 d=(g[len-4])%M;
					 g1[j]=(a+b+c+d)%M;
					 
				 }
				 else
				 if(count==2){  //g[5]
					 a=g1[g1.length-g1.length]%M;
					 b=(3*g[len-1])%M;
					 c=(3*g[len-2])%M;
					 d=(g[len-3])%M;
					 g1[j]=(a+b+c+d)%M;
					 
				 }
				 else
				 if(count==3){  //g[5]
					 a=g1[(g1.length-g1.length)+1]%M;
					 b=(3*g[(g1.length-g1.length)])%M;
					 c=(3*g[len-1])%M;
					 d=(g[len-2])%M;
					 g1[j]=(a+b+c+d)%M;
					 
				 }
				 
				 else
					 if(count==4){  //g[5]
						 a=g1[(g1.length-g1.length)+2]%M;
						 b=(3*g[(g1.length-g1.length)+1])%M;
						 c=(3*g[g1.length-g1.length])%M;
						 d=(g[len-1])%M;
						 g1[j]=(a+b+c+d)%M;
						 
					 }
				 
				 
				 
				 
			 }
			 
			 
			 a=g1[j-1]%M;
			 b=(3*g[j-2])%M;
			 c=(3*g[j-3])%M;
			 d=(g[j-4])%M;
			 g1[j]=(a+b+c+d)%M;
			 
			 
		 }
		 
		 
		
		printRes(g,g1,arr,maxHalf1);
	}//if max>int.max
	
	
	else{
		long [] g=new long[(int) (max+1)];
		 g[0]=0;
		 g[1]=1;
		 g[2]=3;
		 g[3]=3;
		 g[4]=1;
		 long a,b,c,d;
		 for(int i=5;i<=max;++i){
			 a=g[i-1]% M;
			// b=3*(g[i-2]%M);
			 b=(3*(g[i-2]))%M;
			// c=3*(g[i-3]%M);
			 c=(3*(g[i-3]))%M;
			 d=g[i-4]%M;
			 
			 g[i]=(a+b+c+d)%M;
			 
		 }
		
		 printRest(g,arr);
	}//else
		
		
	}
		public static void printRest(long [] g,long [] arr){
			
			for(int i=0;i<arr.length;++i){
			
				
			System.out.println(" arr "+i+" "+ g[(int) arr[i]]);
			
			
			
			}//for
			
		}	
			
		
		
	
		
	
	public static void printRes(long [] g,long [] g1,long [] arr,int maxHalf1){
		long index=0;
		for(int i=0;i<arr.length;++i){
		if(arr[i]<maxHalf1)	{
			
		System.out.println(" arr "+i+" "+ g[(int) arr[i]]);
		}
		else{
			index=arr[i]-maxHalf1;
			System.out.println(" arr "+i+" "+ g1[(int)index]);
			
		}
		
		}//for
		
	}

}
