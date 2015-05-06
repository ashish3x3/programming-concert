

/*You are given a list of N numbers a1,a2,…,an. For each i (1≤i≤N), define LEFT(i) to be the nearest index j before i such that aj>ai. Note that if j does not exist, we should consider LEFT(i) to be 0. Similarly, define RIGHT(i) to be the nearest index k after i such that ak>ai. Note that if k does not exist, we should consider RIGHT(i) to be 0.

Define INDEXPRODUCT(i) as the product of LEFT(i) and RIGHT(i). Find the maximum INDEXPRODUCT(i) among all 1≤i≤N.

Input Format

The first line contains an integer N, the number of integers. The next line contains the N integers.

Constraints:

1≤N≤105

Each of the N integers will range from 0 to 109

Output Format

Output the maximum INDEXPRODUCT among all indices from 1 to N.

Sample Input

5
5 4 3 4 5

Sample Output

8

Explanation

We can compute the following:

INDEXPRODUCT(1)=0
INDEXPRODUCT(2)=1×5=5
INDEXPRODUCT(3)=2×4=8
INDEXPRODUCT(4)=1×5=5
INDEXPRODUCT(5)=0

The largest of these is 8, so it is the answer.*/
import java.util.*;


public class FindMaximumIndexProduct{

	public static int [] arr=null;
	public static int [] left=null;
	public static int [] right=null;
	public static boolean [] visRight=null;
	public static  Scanner scan=new Scanner(System.in);

	public static void main(String [] args){

		int N=scan.nextInt();
		arr=new int [N];
		left=new int [N];
		right=new int [N];
		visRight=new boolean [N];
		int l=-1,r=-1,i,j=-1;

		for( i=0;i<N;++i){
			arr[i]=scan.nextInt();
		}

		for( i=1;i<N-1;++i){
			if( i!=1 && arr[i-1] < arr[i]){
				l=left[i-1]-1;
				while(l>=0){
					if(arr[l]>arr[i]){
						System.out.println("arr[l] "+arr[l] +" arr[i] "+ arr[i] + "l " +  l);
						break;
					}
					l--;
				}
			}

			else if(arr[i-1]>arr[i]){
				l=i-1;
			}
			if(l>=0){
				System.out.println("before left[i]=l ;;l= " +l + " at i "+ i);
				left[i]=l+1;
				if(visRight[l]!=true){
					visRight[l]=true;
					r=i+1;

					while(r<N){
						if(arr[r]>arr[l]){
							System.out.println("arr[r] "+arr[r] +" arr[l] "+ 
								arr[l] + " arr " +  r);
							break;
						}
						r++;
					}
					if(r!=N){

						right[l]=r+1;
					}
					else
						right[l]=0;


						} //visR[]!=T					
					}//l>=0
					else{
						System.out.println("l = 0 at i "+ i);
						
						left[i]=0;
					}


				}//for i main loop


				int q;
				System.out.println("\n arr after");
				for( q=0;q<N;++q){
					System.out.print(" "+arr[q]);
					
				}
				System.out.println();
				for( q=0;q<N;++q){
					System.out.print(" "+left[q]);
					
				}
				System.out.println();
				for( q=0;q<N;++q){
					System.out.print(" "+right[q]);
					
				}
				System.out.println();


				//find remaining right[]
				int z;
				for(int k=1;k<N-1;++k){

					if(visRight[k]!=true){

						z=k+1;
						while(z<N){
							if(arr[z]>arr[k])
								break;
							z++;
						}
						if(z!=N){
							right[k]=z+1;
							visRight[k]=true;
						}

				}//if vis[]


				}  //for K
				
				for( q=0;q<N;++q){
					System.out.print(" "+left[q]);
					
				}
				System.out.println();
				for( q=0;q<N;++q){
					System.out.print(" "+right[q]);
					
				}
				System.out.println();


				int max=0;
				int temp;

				for( i=1;i<N;++i){
					temp=left[i]*right[i];
					if(temp>=max){
						max=temp;
					}



				} //for i

				System.out.println(""+max);


		}//main
}//class