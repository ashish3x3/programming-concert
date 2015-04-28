import java.util.*;
public class MaxSubArray {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N;
		N=scan.nextInt();
		int [] a=new int[N];
		System.out.println("Enter the array");
		
		for(int i=0;i<N;++i){
		a[i]=scan.nextInt();
		}
		
		int I=0;
		int len=a.length;
		for(int i=len-1;i>0;--i){
			if(a[i]<a[i-1]){
				I=i;
				break;
				
			}
			
		}
		
		int [] temp=new int[I+1];
		for(int i=0;i<temp.length;++i){
			temp[i]=a[i];
			
		}
		
		Arrays.sort(temp); 
		
		for(int i=0;i<temp.length;++i){
			a[i]=temp[i];
			
		}
		
		System.out.println("Array= "+Arrays.toString(a));
		
		System.out.println("SubArray= 0 to"+I);
		
		
		
		
		scan.close();
	}

}
