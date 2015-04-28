import java.util.*;


public class MaxMultiple {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		int N;
		N=scan.nextInt();
		int [] a=new int[N];
		System.out.println("Enter the array");
		
		for(int i=0;i<N;++i){
		a[i]=scan.nextInt();
		}
		
		int max=0;
		int I = 0,J = 0,K = 0;
		int i,j,k;
		for(i=0;i<N-2;++i){
			for(j=i+1;j<N-1;++j){
				for(k=j+1;k<N;++k){
					if(a[i]*a[j]*a[k]>max){
						max=a[i]*a[j]*a[k];
						I=i;J=j;K=k;
						
					}
					
				}
			}
			
			
		}
		
		System.out.println("max= "+max);
		System.out.println("I= "+I+"J="+J+"K="+K);
		
		
		scan.close();
	}

}
