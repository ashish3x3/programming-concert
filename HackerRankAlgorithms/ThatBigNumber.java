import java.util.Scanner;


public class ThatBigNumber {
	static long M=10000007;
	public static void main(String[] args) {
		int N;
		Scanner scan=new Scanner(System.in);
		
		N=scan.nextInt();
		long [] arr=new long[N];
		long max=0;
		long a=0;
		for(int i=0;i<N;++i){
			
			a=scan.nextLong();
			
			arr[i]=a;
			if(arr[i]>max)
				max=arr[i];
			
			
			
		}//for
		
//System.out.println(" max =" +max);
		
		T(arr,max);
		
		

	

      }
	
	
	public static  void T(long [] arr,long max){
		
		
		long [] temp=new long[7];
		long [] T=new long[arr.length];
		temp[0]=0;
		temp[1]=1;
		temp[2]=3;
		temp[3]=3;
		temp[4]=1;
		
		/*
		System.out.print(" =" +temp[1]);
		System.out.print(" =" +temp[2]);
		System.out.print(" =" +temp[3]);
		System.out.print(" =" +temp[4]);
		System.out.print(" ");
		System.out.print("\n ");
		*/
		long count=5;
		long a,b,c,d,e;
		int i=5;
		if(max>4){
			max=max-4;
			//count=5;
		}
	//	System.out.print(" \nmax now=" +max);
		while(max-- >0){
			//System.out.println("\nmax=== =" +max +"\n");
			
			//System.out.println("\n temp=== =" +"\n");
			//System.out.print(" =" +temp[1]);
			//System.out.print(" =" +temp[2]);
			//System.out.print(" =" +temp[3]);
			//System.out.print(" =" +temp[4]);
			
			//System.out.print("\n abcd=== ="  +"\n");
			a=temp[i-4];
			//System.out.print("a =" +a);
			
			b=3*temp[i-3];
			//System.out.print("b*t-3 =" +b +""+temp[i-3]);
			c=3*temp[i-2];
			//System.out.print("b*t-2 =" +c +""+temp[i-2]);
			
			d=temp[i-1];
			//System.out.print("t-1 =" +d +""+temp[i-1]);
			/*
			System.out.println("\nabcd together=== ="+"\n");
			System.out.print(" =" +a);
			System.out.print(" =" +b);
			System.out.print(" =" +c);
			System.out.print(" =" +d);
			System.out.print(" ");
			System.out.print("\n ");
			
			*/
			
			temp[i]=(a+b+c+d)%M;
			
			for(int k=0;k<arr.length;++k){
			if(count==arr[k])
				T[k]=temp[i];
			else if(arr[k]==1) 
				T[k]=1;
			else if(arr[k]==2) 
				T[k]=3;
			else if(arr[k]==3) 
				T[k]=3;
			else if(arr[k]==4) 
				T[k]=1;
			}
		//	System.out.print(" =" +temp[i]);
			
			
			
			temp[i-4]=temp[i-3];
			temp[i-3]=temp[i-2];
			temp[i-2]=temp[i-1];
			temp[i-1]=temp[i];
			/*
			System.out.println("\n new temp=== ="+"\n");
			System.out.print(" =" +temp[1]);
			System.out.print(" =" +temp[2]);
			System.out.print(" =" +temp[3]);
			System.out.print(" =" +temp[4]);
			*/
			
			//System.out.print("\ncount =" +count);
		count++;	
		}
		
		print(T);
	}	
	
	public static void print(long [] T){
		
		for(int i=0;i<T.length;++i){
			System.out.println(""+T[i]);
			
		}
		
		
	}
		
		
		
	}//class 
	


