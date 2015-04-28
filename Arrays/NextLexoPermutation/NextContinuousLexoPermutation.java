

import java.util.Arrays;
import java.util.Scanner;


public class NextContinuousLexoPermutation {

	public static void main(String[] args) {
		int [] arr;
		System.out.println("enter size of N");
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		arr=new int[N];
		
		System.out.println("Enetr elememts space separated");
		
		for(int i=0;i<arr.length;++i){
			
			arr[i]=scan.nextInt();
			
		}
		
		System.out.println("Original Array = " + Arrays.toString(arr)); 
		
		nextPerm(arr);
		/*printArr(arr);
		nextPerm(arr);
		printArr(arr);
		nextPerm(arr);
		printArr(arr);
		*/
		
	}
	
	public static void printArr(int [] arr){
		
		System.out.println("Permuted Array = " + Arrays.toString(arr)); 
	}
	
	public static void nextPerm(int [] arr){
		
		boolean isFinished=false;
		
		while(!isFinished){
			
		int i=arr.length-2;
		while(i>=0 && arr[i]<arr[i+1])
			break;
		
		if(i==-1)
			isFinished=true;
		else{
		int j=arr.length-1;
		
		/*while(j>=0 && arr[j]<arr[i] )
			j--;
		*/
		
		for(;j>=0;--j){
			if(j>=0){
			if(arr[j]>arr[i])
				break;
			}
		}
		
		swap(arr,i,j);
		
		
		reverse(arr,i+1);		
		
		printArr(arr);
		
		
		}
		
		
		}
		
	}
	
	public static void swap(int [] arr,int i,int j){
		
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
		
	}
	
	public static void reverse(int [] arr,int n){
		
		
		
		for(int i=n,j=arr.length-1;j>i ;++i,--j ){
			
			swap(arr,i,j);
					
		}
		
		
	}

}
